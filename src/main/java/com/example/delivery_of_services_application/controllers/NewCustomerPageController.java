package com.example.delivery_of_services_application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import com.example.delivery_of_services_application.controllers.FxmlLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class NewCustomerPageController {
   @FXML
   BorderPane mainPane;
    @FXML
    public void cleaningButtonOnAction(){
        FxmlLoader object =new FxmlLoader();
        Pane view= object.getPage("CleaningPage.fxml");
        mainPane.setCenter(view);
    }
    @FXML
    public void renovationWorkButtonOnAction(){
        FxmlLoader object =new FxmlLoader();
        Pane view= object.getPage("RenovationWorkPage.fxml");
        mainPane.setCenter(view);
    }
    @FXML
    public void medicalServicesButtonOnAction(){
        FxmlLoader object =new FxmlLoader();
        Pane view= object.getPage("MedicalServicesPage.fxml");
        mainPane.setCenter(view);
    }
    @FXML
    public void itSupportButtonOnAction(){
        FxmlLoader object =new FxmlLoader();
        Pane view= object.getPage("ITSupportPage.fxml");
        mainPane.setCenter(view);
    }
    @FXML
    public void othersButtonOnAction(){
        FxmlLoader object =new FxmlLoader();
        Pane view= object.getPage("OthersPage.fxml");
        mainPane.setCenter(view);
    }
    @FXML
    public void profileButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CustomerProfilePage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   @FXML
   public void historyButtonOnAction(ActionEvent event) throws IOException {
       Stage stage;
       Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HistoryPage.fxml"));
       stage=(Stage)((Node)event.getSource()).getScene().getWindow();
       Scene scene=new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
   @FXML
   public void logoutButtonOnAction(ActionEvent event) throws IOException {
    Stage stage;
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
   }






}
