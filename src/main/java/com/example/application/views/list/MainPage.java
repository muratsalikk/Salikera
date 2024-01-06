package com.example.application.views.list;

import com.example.application.data.entity.Server;
import com.example.application.services.ServerService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Salikera")
@Route(value = "main", layout = MainLayout.class)
public class MainPage extends VerticalLayout {
    Grid<Server> grid = new Grid<>(Server.class);
    TextField filterText = new TextField();
    ServerForm form ;
    NewServerDialog newServerDialog = new NewServerDialog();
    private ServerService service;

    public MainPage(ServerService service) {
        this.service = service;
        //setSpacing(false);
        addClassName("main-page");
        setSizeFull();

        configureGrid();
        configureForm();

        add(
                getToolbar(),
                getContent(),
                newServerDialog
        );

        updateList();
        closeServerForm();

    }

    private void closeServerForm() {
        form.setServer(null);
        form.setVisible(false);
        removeClassName("editing");
    }


    private Component getToolbar() {
        filterText.setPlaceholder("Filter by Host Name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button configureButton = new Button("Configure Presto");
        configureButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        configureButton.addClickListener(e -> UI.getCurrent().navigate(ConfigurationPage.class));

        Button addServerButton = new Button("Add new server", e -> newServerDialog.open());
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addServerButton, configureButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(1.5,grid);
        content.setFlexGrow(1.5, form);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassName("server-grid");
        grid.setSizeFull();
        grid.setColumns("hostName", "ip", "status");
        //grid.addColumn(server -> server.getHostName()).setHeader("Host Name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(e -> editServer(e.getValue()));

    }

    private void editServer(Server server) {
        if (server == null) {
            closeServerForm();
        } else {
            form.setServer(server);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void configureForm() {
        form = new ServerForm();
        form.setWidth("40em");
        form.addListener(ServerForm.CloseEvent.class, e -> closeServerForm());
    }

    private void updateList() {
        grid.setItems(service.findByHostName(filterText.getValue()));
    }


}
