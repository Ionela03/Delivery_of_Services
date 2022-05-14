package com.example.delivery_of_services_application.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class LoginController {
    @FXML
    private MenuButton roleButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button registrationButton;
    @FXML
    private Button cancelButton;
    @FXML
    private AnchorPane openregisterpane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    public void loginButtonOnAction() {
        System.out.println("Login");
    }

    public void cancelButtonOnAction() {
        System.out.println("cancel");
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registrationButtonOnAction(ActionEvent event) throws  IOException{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}