package com.loginExample;

import com.google.common.collect.ImmutableMap;
import com.loginExample.configuration.LoginExampleConfiguration;
import com.loginExample.dao.PersonDAO;
import com.loginExample.healthcheck.TemplateHealthcheck;
import com.loginExample.resource.LoginExampleResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;

public class LoginExampleApplication extends Application<LoginExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new LoginExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "login-example";
    }

    @Override
    public void initialize(Bootstrap<LoginExampleConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<LoginExampleConfiguration>() {
            @Override
            public ImmutableMap<String, ImmutableMap<String, String>> getViewConfiguration(LoginExampleConfiguration loginExampleConfiguration) {
                return loginExampleConfiguration.getViewRendererConfiguration();
            }
        });
    }

    @Override
    public void run(LoginExampleConfiguration configuration, Environment environment) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "postgresql");
        final PersonDAO dao = jdbi.onDemand(PersonDAO.class);
        final TemplateHealthcheck healthcheck = new TemplateHealthcheck(configuration.getTemplate());
        final LoginExampleResource resource = new LoginExampleResource(dao);
        environment.healthChecks().register("template", healthcheck);
        environment.jersey().register(resource);
    }
}
