package com.example.delivery_of_services_application.controllers;


import com.example.delivery_of_services_application.services.ChatService;
import com.example.delivery_of_services_application.users.Announcement;
import com.example.delivery_of_services_application.users.Chat;
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
import static com.example.delivery_of_services_application.services.ChatService.chatRepository;
import static com.example.delivery_of_services_application.services.UserService.userRepository;

public class OthersPageController {

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
    Label request;
    @FXML
    TextField username;
    public void initialize(){
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.domain, "Others"))
                listView.getItems().addAll(ad.noAnnouncement );

    }


    @FXML
    public void selectButtonOnAction(ActionEvent event){
        String s= listView.getSelectionModel().getSelectedItem();
        System.out.println("-" + s + "-");
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
    public void sendRequestButtonOnAction(){
        String s= listView.getSelectionModel().getSelectedItem();
        System.out.println("-"+s+"-");
        String user=username.getText();
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.noAnnouncement,s)) {
                for (Chat chat : chatRepository.find()){
                    if (Objects.equals(ad.noAnnouncement, chat.ad) ) {
                        request.setText("Request already sent!!!");
                        return;
                    }
                    if(Objects.equals(user, chat.expeditor)){
                        request.setText("You already selected an announcement");
                        return;
                    }
                }



                ChatService.initiateChat(user, ad.provider, "", "0", ad.noAnnouncement);
                request.setText("Request sent successfully");
                return;


            }

    }



}



