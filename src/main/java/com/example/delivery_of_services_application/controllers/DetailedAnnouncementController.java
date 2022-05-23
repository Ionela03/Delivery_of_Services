package com.example.delivery_of_services_application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedAnnouncementController implements Initializable{
    @FXML
    private Label title;




    public void communication(String text){
        title.setText(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
