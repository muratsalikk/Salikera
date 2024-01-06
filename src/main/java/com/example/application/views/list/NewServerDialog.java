package com.example.application.views.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class NewServerDialog extends Dialog {

    TextField hostName = new TextField("Host Name");
    Button discoverServerButton = new Button("Discover Server");
    TextArea ip = new TextArea("Ip");
    TextField sshUserName = new TextField("SSH user name");
    TextField sshUserPassword = new TextField("SSH user password");
    TextField sshPort = new TextField("SSH port:");
    Button cancelButton = new Button("Cancel", e -> this.close());
    Button connectToServerButton = new Button("Connect to the server");

    //ComboBox<Status> status = new ComboBox<>("Status");

    public NewServerDialog() {

        addClassName("new-server-dialog");
        setHeaderTitle("Add new server");
        discoverServerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        getFooter().add(cancelButton);
        getFooter().add(discoverServerButton);

        add(
                hostName
                //createButtonLayout()
        );
    }

    private Component createButtonLayout() {
        discoverServerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        return new HorizontalLayout(discoverServerButton, cancelButton);
    }
}
