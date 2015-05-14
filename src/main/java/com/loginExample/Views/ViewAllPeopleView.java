package com.loginExample.Views;

import io.dropwizard.views.View;

public class ViewAllPeopleView extends View {

    public ViewAllPeopleView() {
        super("/templates/partials/loginPage.ftl");
    }
}
