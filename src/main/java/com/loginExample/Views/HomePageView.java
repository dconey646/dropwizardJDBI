package com.loginExample.Views;

import io.dropwizard.views.View;

public class HomePageView extends View {

    public HomePageView(){
        super("/templates/partials/userHomePage.ftl");
    }
}
