package com.example.delivery_of_services_application.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerHomePageController {
    @FXML
    private Button logOutButton;
    @FXML
    public void backToLogin(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
