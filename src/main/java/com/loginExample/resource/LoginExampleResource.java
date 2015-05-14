package com.loginExample.resource;

import com.codahale.metrics.annotation.Timed;
import com.loginExample.Views.*;
import com.loginExample.authentication.User;
import com.loginExample.dao.PersonDAO;
import io.dropwizard.auth.Auth;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login-example")
public class LoginExampleResource {

    private PersonDAO personDAO;

    public LoginExampleResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GET
    @Path("/login")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View loginPageView(){
        return new LoginPageView(true);
    }

    @POST
    @Path("login-details")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View login(@FormParam("username") String username,
                      @FormParam("password") String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            return null;
        } else {
            int personId = personDAO.checkDetails(username, password);
            if(personId <= 0) {
                return new HomePageView();
            } else {
                return new LoginPageView(false);
            }
        }
    }

    @GET
    @Path("delete")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View deleteUserView(@Auth User user){
        return new DeleteUserView();
    }

    @GET
    @Path("create")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View createPerson(@Auth User user){
        return new CreatePersonView();
    }

    @GET
    @Path("view-all")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View viewAllPeople(@Auth User user){
        return new ViewAllPeopleView();
    }

    @GET
    @Path("find-person-by-id")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View findById(@Auth User user){
        return new FindByIdView();
    }
}
