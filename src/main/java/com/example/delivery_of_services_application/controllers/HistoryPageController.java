package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.users.Announcement;
import com.example.delivery_of_services_application.users.Chat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectFilter;

import java.io.IOException;
import java.util.Objects;

import static com.example.delivery_of_services_application.services.AnnouncementService.announcementRepository;
import static com.example.delivery_of_services_application.services.ChatService.chatRepository;
import static org.dizitart.no2.filters.Filters.eq;

public class HistoryPageController {
    @FXML
    ListView<String> listView;
    @FXML
    TextField username;
    @FXML
    Label label1;
    @FXML
    Label label2;

    @FXML
    public void seeAnnouncementsButtonOnAction(){

        for(Chat c: chatRepository.find() )
            if(Objects.equals(c.expeditor, username.getText()))
                listView.getItems().addAll(c.ad );
        

    }

    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("NewCustomerPage.fxml"));
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
    @FXML
    public void seeDetailsButtonOnAction(){
        for(Chat c: chatRepository.find() )
            if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())) {
                chatRepository.update(c);
            }

        for(Chat c: chatRepository.find() )
            if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())){
                label1.setText(c.expeditor+" ---> "+c.destinatar);
                label2.setText("Status: "+c.status);
            }

    }
    @FXML
    public void deleteButtonOnAction(){
        for(Chat c: chatRepository.find() )
            if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())){
                c.expeditor="deleted";
                c.destinatar="deleted";
            }

    }


}
