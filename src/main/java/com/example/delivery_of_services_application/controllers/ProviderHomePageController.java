package com.example.delivery_of_services_application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProviderHomePageController {
    public void profileButtonOnAction(ActionEvent actionEvent) {
    }

    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void requestButtonOnAction(ActionEvent actionEvent) {
    }

    public void addButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addAnnouncementPage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
