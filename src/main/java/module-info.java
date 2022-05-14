module com.example.delivery_of_services_application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires nitrite;

    opens com.example.delivery_of_services_application to javafx.fxml;
    exports com.example.delivery_of_services_application;
    exports com.example.delivery_of_services_application.controllers;
    opens com.example.delivery_of_services_application.controllers to javafx.fxml;
}