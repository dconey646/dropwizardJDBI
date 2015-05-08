package com.loginExample.Views;

import io.dropwizard.views.View;

public class CreatePersonView extends View {

    public CreatePersonView(){
        super("/templates/partials/createPerson.ftl");
    }
}
