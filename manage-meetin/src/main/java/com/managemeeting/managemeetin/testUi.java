package com.managemeeting.managemeetin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class testUi extends UI {

    private VerticalLayout layout;

    @Override
    protected  void init(VaadinRequest vaadinRequest){
        addHeader();
        addActionButton();
        setupLayout();
        addMainThing();
    }

    private void setupLayout(){
        layout = new VerticalLayout();
        setContent(layout);
    }
    private void addHeader(){
        Label header = new Label("Manage Meeting");
        layout.addComponent(header);
    }
    private  void addActionButton(){
        Button loginButton = new Button ("Log in");
        layout.addComponent(loginButton);
    }

    private void addMainThing(){

    }
}
