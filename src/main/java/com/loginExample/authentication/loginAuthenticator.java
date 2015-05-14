package com.loginExample.authentication;

import com.google.common.base.Optional;
import com.loginExample.dao.PersonDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class LoginAuthenticator implements Authenticator<BasicCredentials, User>{

    private PersonDAO personDAO;

    public LoginAuthenticator(PersonDAO personDao){
        this.personDAO = personDao;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        //Insert password hashing and DB interaction
        if(basicCredentials.getUsername() == null || basicCredentials.getUsername().isEmpty() || basicCredentials.getPassword() == null || basicCredentials.getPassword().isEmpty()){
            return null;
        } else {
            int personId = personDAO.checkDetails(basicCredentials.getUsername(), basicCredentials.getPassword());
            if(personId <= 0) {
                return Optional.of(new User());
            } else {
                return null;
            }
        }
    }
}
