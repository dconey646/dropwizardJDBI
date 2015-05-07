package com.loginExample.resource;

import com.codahale.metrics.annotation.Timed;
import com.loginExample.Views.DeleteUserView;
import com.loginExample.Views.HomePageView;
import com.loginExample.Views.LoginPageView;
import com.loginExample.dao.PersonDAO;
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
            return new LoginPageView(false);
        } else {
            int personId = personDAO.checkDetails(username, password);
            if(personId <= 0) {
                return new LoginPageView(false);
            } else {
                return new HomePageView();
            }
        }
    }

    @GET
    @Path("delete-user")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View deleteUserView(){
        return new DeleteUserView();
    }

    @GET
    @Path("create-person")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public void createPerson(){
    }

    @GET
    @Path("view-all")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public void viewAllPeople(){
    }

    @GET
    @Path("find-person-by-id")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public void findById(){
    }
}
