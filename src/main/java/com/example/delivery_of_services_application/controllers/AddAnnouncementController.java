package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.exceptions.AnnouncementAlreadyExistsException;
import com.example.delivery_of_services_application.exceptions.UsernameAlreadyExistsException;
import com.example.delivery_of_services_application.services.UserService;
import com.example.delivery_of_services_application.services.AnnouncementService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.io.IOException;

public class AddAnnouncementController {
    @FXML
    private TextField noAnnouncement;
    @FXML
    private TextField county;
    @FXML
    private ChoiceBox domain;
    @FXML
    private TextField price;
    @FXML
    private ChoiceBox deplHome;
    @FXML
    private ChoiceBox negociablePrice;
    @FXML
    private TextField phone;
    @FXML
    private TextField description;
    @FXML
    private Text addMessage;



    @FXML
    public void initialize() {
        domain.getItems().addAll("Cleaning", "Renovation Work", "Medical Services", "IT Support","Others");
        deplHome.getItems().addAll("Yes", "No");
        negociablePrice.getItems().addAll("Yes", "No");
    }
    @FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ProviderHomePage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("log_in.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addButtonOnAction(ActionEvent actionEvent) {

            try {
                AnnouncementService.addAnnouncement(noAnnouncement.getText(), county.getText(), (String)domain.getValue(), (String)deplHome.getValue(),price.getText(),(String)negociablePrice.getValue(), phone.getText(),description.getText());
                addMessage.setText("Announcement added successfully!");
            } catch (AnnouncementAlreadyExistsException e) {
                addMessage.setText(e.getMessage());
            }
    }

}
