package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.services.UserService;
import com.example.delivery_of_services_application.users.User;
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

public class CustomerProfilePageController {
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordField;
    @FXML
    private Label roleField;
    public void viewDataOnAction(ActionEvent actionEvent) throws IOException {
        String username=usernameTextField.getText();
        String password=passwordField.getText();

        if (username!=null && password!=null) {
            User current_user = UserService.returnCurrentUser(username, password);
            if (current_user != null) {
                roleField.setText(current_user.getRole());
            }
        }
    }
    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("NewCustomerPage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void updateButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ModifyCredentialsPage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
