package com.example.application.views.list;

import com.example.application.data.entity.Configuration;
import com.example.application.data.entity.ConfigurationCategory;
import com.example.application.services.ConfiguritonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Salikera")
@Route(value = "/configuration", layout = MainLayout.class)
public class ConfigurationPage extends FormLayout {
    private ConfiguritonService service;
    Grid<Configuration> grid = new Grid<>(Configuration.class, false);
    Binder<Configuration> binder = new BeanValidationBinder<>(Configuration.class);
    ComboBox<ConfigurationCategory> configurationCategory = new ComboBox<>();

    TextField filterText = new TextField();

    Button cancelButton = new Button("Cancel");

    public ConfigurationPage(ConfiguritonService service) {
        addClassName("new-configuration-form");
        this.service = service;
        binder.bindInstanceFields(this);

        add( new VerticalLayout(
                getToolbar(),
                configureGrid()
                )
        );
        updateList();
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by Property Name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        List<ConfigurationCategory> configurationCategories = service.findAllCategories();

        configurationCategory.setItems(configurationCategories);
        configurationCategory.setItemLabelGenerator(ConfigurationCategory::getCategoryName);
        configurationCategory.setAllowCustomValue(false);
        configurationCategory.setPlaceholder("Category");
        configurationCategory.setClearButtonVisible(true);
        configurationCategory.setManualValidation(true);

        cancelButton.addClickListener(e -> UI.getCurrent().navigate(MainPage.class));
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancelButton.addClickListener(e -> UI.getCurrent().navigate(ConfigurationPage.class));

        Button deployButton = new Button("Deploy Configuration");
        deployButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        HorizontalLayout toolbar = new HorizontalLayout(configurationCategory, filterText, deployButton, cancelButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private Component configureGrid() {
        Editor<Configuration> editor = grid.getEditor();

        Grid.Column<Configuration> configurationName = grid
                .addColumn(Configuration::getConfigurationName).setHeader("Property")
                .setWidth("2em").setFlexGrow(1);
        Grid.Column<Configuration> cValue = grid.addColumn(Configuration::getcValue)
                .setHeader("Value");
        Grid.Column<Configuration> editColumn = grid.addComponentColumn(configuration -> {
            Button editButton = new Button("Edit");
            editButton.addClickListener(e -> {
                if (editor.isOpen())
                    editor.cancel();
                grid.getEditor().editItem(configuration);
            });
            return editButton;
        }).setWidth("150px").setFlexGrow(0);

        editor.setBinder(binder);
        editor.setBuffered(true);

        TextField configurationNameField = new TextField();
        configurationNameField.setWidthFull();
        binder.forField(configurationNameField)
                .bind(Configuration::getConfigurationName, Configuration::setConfigurationName);
        configurationName.setEditorComponent(configurationNameField);

        TextField cValueField = new TextField();
        cValueField.setWidthFull();
        binder.forField(cValueField)
                .bind(Configuration::getcValue, Configuration::setcValue);
        cValue.setEditorComponent(cValueField);


        Button saveButton = new Button("Save", e -> editor.save());
        Button cancelButton = new Button(VaadinIcon.CLOSE.create(),
                e -> editor.cancel());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ICON,
                ButtonVariant.LUMO_ERROR);
        HorizontalLayout actions = new HorizontalLayout(saveButton,
                cancelButton);
        actions.setPadding(false);
        editColumn.setEditorComponent(actions);

        return grid;
    }

    private void updateList() {
        grid.setItems(service.findByConfigurationName(filterText.getValue()));
    }

}
