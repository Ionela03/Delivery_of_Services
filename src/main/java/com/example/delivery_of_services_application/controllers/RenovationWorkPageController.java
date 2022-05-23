package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.users.Announcement;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Objects;

import static com.example.delivery_of_services_application.services.AnnouncementService.announcementRepository;

public class RenovationWorkPageController {
    @FXML
    private ListView<String> listView;
    public void initialize(){
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.domain, "Renovation Work"))
                listView.getItems().addAll(ad.noAnnouncement);
    }
}
