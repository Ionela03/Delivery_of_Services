package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyCredentialsController {
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField newUsernameTextField;
    @FXML
    public PasswordField newPasswordField;
    @FXML
    public Label modifiedMessage;

    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ProviderProfilePage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void updateButtonOnAction(ActionEvent actionEvent) {
        String newUsername=usernameTextField.getText();
        String newPassword=passwordField.getText();


        if(UserService.updateProfile(newUsername,newPassword))
        {
            modifiedMessage.setText("Credentials modified successfully");
        }
        else
            modifiedMessage.setText("Please try again!");
    }
}
