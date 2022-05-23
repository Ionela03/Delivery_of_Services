package com.example.delivery_of_services_application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import com.example.delivery_of_services_application.services.UserService;
import com.example.delivery_of_services_application.users.User;



public class LoginController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane openClientInterface;
    @FXML
    private AnchorPane openInstructorInterface;

        @FXML
    public void loginButtonOnAction(ActionEvent event) throws IOException{
            String username=usernameTextField.getText();
            String password=passwordField.getText();

            if(username!=null && password!=null){
                int k;
                k= UserService.validateLogin(username,password);
                if(k!=0)
                {
                    if(k==1){
                        //open interface for Provider
                        Stage stage;
                        Parent root;
                        stage = (Stage) loginButton.getScene().getWindow();
                        root=FXMLLoader.load(getClass().getClassLoader().getResource("ProviderHomePage.fxml"));
                        stage.setScene(new Scene(root, 700, 400));
                        stage.show();
                    }
                    if(k==2){
                        //open interface for Customers
                        Stage stage;
                        Parent root;
                        stage = (Stage) loginButton.getScene().getWindow();
                        root=FXMLLoader.load(getClass().getClassLoader().getResource("NewCustomerPage.fxml"));
                        stage.setScene(new Scene(root, 800, 600));
                        stage.show();
                    }

                }
                else{
                    loginMessageLabel.setText("Please try again!");
                }
            }
            else{

                loginMessageLabel.setText("Please enter your username and password!");
            }
        }


    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void registrationButtonOnAction(ActionEvent event) throws IOException {
        Stage stage;

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
