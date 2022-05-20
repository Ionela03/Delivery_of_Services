package com.example.delivery_of_services_application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OthersPageController {
    @FXML
    private ListView<String> listView;
    public void initialize(){
        listView.getItems().addAll("Announcement1","Announcement2","Annoncement3");
    }
}
