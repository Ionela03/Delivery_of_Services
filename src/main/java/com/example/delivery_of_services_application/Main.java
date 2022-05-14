package com.example.delivery_of_services_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaystage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log_in.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 490);
        primaystage.setTitle("Delivery of Services App");
        primaystage.setScene(scene);
        primaystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}