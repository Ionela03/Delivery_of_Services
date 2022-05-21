package com.example.delivery_of_services_application;

import com.example.delivery_of_services_application.services.AnnouncementService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.delivery_of_services_application.services.FileSystemService;
import com.example.delivery_of_services_application.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        AnnouncementService.initAnnouncementsDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
        primaryStage.setTitle("Delivery of Services App");
        primaryStage.setScene(new Scene(root, 600, 451));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
