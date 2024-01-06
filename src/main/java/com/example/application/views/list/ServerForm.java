package com.example.application.views.list;

import com.example.application.data.entity.Server;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class ServerForm extends FormLayout {

    Button backButton = new Button("Back");
    Button stopPrestoButton = new Button("Stop");
    Button startPrestoButton = new Button("Start");
    Button restartPrestoButton = new Button("Restart");


    Binder<Server> binder = new BeanValidationBinder<>(Server.class);

    TextField status = new TextField();
    TextField hostName = new TextField();
    TextField ip = new TextField();
    TextField OSVersion = new TextField("OS version");
    TextField javaVersion = new TextField("Java version");
    TextField prestoVersion = new TextField("Presto version");
    TextField nodeId = new TextField("Node id");
    TextField lastUpdateTime = new TextField("Last update time");
    TextField cpuCores = new TextField("CPU cores");
    TextField memory = new TextField("Memory");


    ProgressBar cpuUsageBar = new ProgressBar();
    ProgressBar cpuUsagePrestoBar = new ProgressBar();
    ProgressBar memoryUsageBar = new ProgressBar();
    ProgressBar memoryUsagePrestoBar = new ProgressBar();

    //ComboBox<Status> status = new ComboBox<>("Status");

    public ServerForm() {
        addClassName("new-server-form");
        backButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        backButton.addClickListener(e -> fireEvent(new CloseEvent(this)));
        binder.bindInstanceFields(this);

        /* header fields */
        status.setReadOnly(true);
        if (status.getValue().equals("Running")) {
            status.addClassName("statusFieldRunning");
        } else if (status.getValue().equals("Stopped")) {
            status.addClassName("statusFieldStopped");
        }
        hostName.setReadOnly(true);
        hostName.addClassName("headerField");
        ip.setReadOnly(true);
        ip.addClassName("headerField");

        /* informations */
        OSVersion.setReadOnly(true);
        javaVersion.setReadOnly(true);
        prestoVersion.setReadOnly(true);
        nodeId.setReadOnly(true);
        lastUpdateTime.setReadOnly(true);

        /* Usages */
        cpuCores.setReadOnly(true);
        memory.setReadOnly(true);



        add(
                backButton,
                new HorizontalLayout( hostName, ip),
                status,
                createButtonLayout(),
                new HorizontalLayout(OSVersion, javaVersion),
                new HorizontalLayout(prestoVersion, nodeId),
                lastUpdateTime,
                new HorizontalLayout(cpuCores,memory),
                CreateCpuUsageBar(),
                CreateCpuUsagePrestoBar(),
                CreateMemoryUsageBar(),
                CreateMemoryUsagePrestoBar()
        );

    }

    private Component CreateCpuUsagePrestoBar() {
        cpuUsagePrestoBar.setMin(0);
        cpuUsagePrestoBar.setMax(1);
        cpuUsagePrestoBar.setValue(0);
        NativeLabel cpuUsagePrestoBarLabelText = new NativeLabel("Cpu Usage of Presto");
        cpuUsagePrestoBarLabelText.setId("cupblabel");
        cpuUsagePrestoBarLabelText.getElement().setAttribute("aria-labelledby", "cupblabel");
        return new HorizontalLayout(cpuUsagePrestoBarLabelText, cpuUsagePrestoBar);
    }

    private Component CreateCpuUsageBar() {
        cpuUsageBar.setMin(0);
        cpuUsageBar.setMax(1);
        cpuUsageBar.setValue(0);
        NativeLabel cpuUsageBarLabelText = new NativeLabel("Cpu Usage of Server");
        cpuUsageBarLabelText.setId("cupblabel");
        cpuUsageBarLabelText.getElement().setAttribute("aria-labelledby", "cupblabel");
        return new HorizontalLayout(cpuUsageBarLabelText, cpuUsageBar);
    }

    private Component CreateMemoryUsagePrestoBar() {
        memoryUsagePrestoBar.setMin(0);
        memoryUsagePrestoBar.setMax(1);
        memoryUsagePrestoBar.setValue(0);
        NativeLabel memoryUsagePrestoBarLabelText = new NativeLabel("Memory Usage of Presto");
        memoryUsagePrestoBarLabelText.setId("mupblabel");
        memoryUsagePrestoBarLabelText.getElement().setAttribute("aria-labelledby", "mupblabel");
        return new HorizontalLayout(memoryUsagePrestoBarLabelText, memoryUsagePrestoBar);
    }

    private Component CreateMemoryUsageBar() {
        memoryUsageBar.setMin(0);
        memoryUsageBar.setMax(1);
        memoryUsageBar.setValue(0);
        NativeLabel memoryUsageBarLabelText = new NativeLabel("Memory Usage of Server");
        memoryUsageBarLabelText.setId("mupblabel");
        memoryUsageBarLabelText.getElement().setAttribute("aria-labelledby", "mupblabel");
        return new HorizontalLayout(memoryUsageBarLabelText, memoryUsageBar);
    }

    public void setServer(Server server) {
        binder.readBean(server);
        if(server != null ) {
            cpuUsageBar.setMax(server.getCpuCores());
            cpuUsageBar.setValue(server.getCpuUsage());
            cpuUsagePrestoBar.setMax(server.getCpuUsage());
            cpuUsagePrestoBar.setValue(server.getCpuUsagePresto());

            memoryUsageBar.setMax(server.getMemory());
            memoryUsageBar.setValue(server.getMemoryUsage());
            memoryUsagePrestoBar.setMax(server.getMemoryUsage());
            memoryUsagePrestoBar.setValue(server.getMemoryUsagePresto());
        }

    }

    private Component createButtonLayout() {
        Paragraph par1 = new Paragraph("Presto actions ");
        startPrestoButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        stopPrestoButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        restartPrestoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //restartPrestoButton

        return new HorizontalLayout(par1, startPrestoButton, stopPrestoButton, restartPrestoButton);
    }


    // Events
    public static abstract class ServerFormEvent extends ComponentEvent<ServerForm> {
        private Server server;

        protected ServerFormEvent(ServerForm source, Server server) {
            super(source, false);
            this.server = server;
        }

        public Server getServer() {
            return server;
        }
    }

    public static class SaveEvent extends ServerFormEvent {
        SaveEvent(ServerForm source, Server server) {
            super(source, server);
        }
    }

    public static class DeleteEvent extends ServerFormEvent {
        DeleteEvent(ServerForm source, Server server) {
            super(source, server);
        }

    }

    public static class CloseEvent extends ServerFormEvent {
        CloseEvent(ServerForm source) {
            super(source, null);
        }
    }

    public <T extends  ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
