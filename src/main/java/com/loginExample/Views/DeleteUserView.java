package com.loginExample.Views;

import io.dropwizard.views.View;

public class DeleteUserView extends View {

    public DeleteUserView(){
        super("/templates/partials/deletePerson.ftl");
    }
}
