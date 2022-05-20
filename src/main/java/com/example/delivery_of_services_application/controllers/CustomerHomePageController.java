package com.example.delivery_of_services_application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerHomePageController {

    @FXML
    private AnchorPane change;

    @FXML
    public void cleaningButtonOnAction() throws IOException {

        System.out.println("cleaning");
    }
    @FXML
    public void renovationWorkButtonOnAction(){
        System.out.println("renovation work");
    }
    @FXML
    public void medicalServicesButtonOnAction(){
        System.out.println("medicalServices");
    }
    @FXML
    public void itSupportButtonOnAction(){
        System.out.println("IT support");
    }
    @FXML
    public void othersButtonOnAction(){
        System.out.println("others");
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