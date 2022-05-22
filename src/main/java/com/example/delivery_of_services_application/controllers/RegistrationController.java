package com.example.delivery_of_services_application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.example.delivery_of_services_application.exceptions.UsernameAlreadyExistsException;
import com.example.delivery_of_services_application.services.UserService;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;


    
    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Provider");
    }

    @FXML
    public void registerButtonOnAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }



    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
