package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.users.Announcement;
import com.example.delivery_of_services_application.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Objects;

import static com.example.delivery_of_services_application.services.AnnouncementService.announcementRepository;
import static com.example.delivery_of_services_application.services.UserService.userRepository;

public class CleaningPageController {
    @FXML
    private ListView<String> listView;
    public void initialize(){
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.domain, "Cleaning"))
                listView.getItems().addAll(ad.noAnnouncement);

    }
}
