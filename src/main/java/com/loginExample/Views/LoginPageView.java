package com.loginExample.Views;

import io.dropwizard.views.View;

public class LoginPageView extends View {

    private final Boolean success;

    public LoginPageView(Boolean success){
        super("/templates/partials/loginPage.ftl");
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }
}
