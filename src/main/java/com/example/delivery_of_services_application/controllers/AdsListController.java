package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.exceptions.AnnouncementAlreadyExistsException;
import com.example.delivery_of_services_application.services.AnnouncementService;
import com.example.delivery_of_services_application.users.Announcement;
import com.example.delivery_of_services_application.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.delivery_of_services_application.services.AnnouncementService.announcementRepository;
import static com.example.delivery_of_services_application.services.UserService.userRepository;

public class AdsListController {
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField username;

    @FXML
    void seeAnnouncementsButtonOnAction(ActionEvent actionEvent){
        for(Announcement ad: announcementRepository.find() )
            if(Objects.equals(ad.provider, username.getText()))
                listView.getItems().addAll(ad.noAnnouncement);
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
    public void addButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addAnnouncementPage.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
