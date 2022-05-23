package com.example.delivery_of_services_application.controllers;


import com.example.delivery_of_services_application.services.ChatService;
import com.example.delivery_of_services_application.users.Announcement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.delivery_of_services_application.services.AnnouncementService.announcementRepository;
import static com.example.delivery_of_services_application.services.UserService.userRepository;

public class RenovationWorkPageController {

    @FXML
    private ListView<String> listView;
    @FXML
    Label provider1;
    @FXML
    Label location1;
    @FXML
    Label price;
    @FXML
    Label negotiable;
    @FXML
    Label displacement;
    @FXML
    Label description;
    @FXML
    Label username;
    @FXML
    TextField request;
    public void initialize(){
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.domain, "Renovation Work"))
                listView.getItems().addAll(ad.noAnnouncement );

    }


    @FXML
    public void selectButtonOnAction(ActionEvent event){
        String s= listView.getSelectionModel().getSelectedItem();
        System.out.println("-"+s+"-");
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.noAnnouncement,s)){
                System.out.println("-"+ad.provider+"-");
                provider1.setText(ad.provider);
                location1.setText(ad.county);
                price.setText(ad.price);
                negotiable.setText(ad.negociablePrice);
                displacement.setText(ad.deplHome);
                description.setText(ad.description);
            }

    }
    @FXML
    public void sendRequestButtonOnAction(){

        String s= listView.getSelectionModel().getSelectedItem();
        System.out.println("-"+s+"-");
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.noAnnouncement,s)) {
                ChatService.initiateChat(username.getText(), ad.provider, "", "Yes", ad.noAnnouncement);
                request.setText("Request sent succesfully");
                return;
            }
    }



}



