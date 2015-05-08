package com.loginExample.Views;

import io.dropwizard.views.View;

public class FindByIdView extends View {

    public FindByIdView(){
        super("/templates/partials/findById.ftl");
    }
}
