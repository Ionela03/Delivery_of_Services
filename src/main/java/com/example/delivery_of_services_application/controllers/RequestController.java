package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.services.ChatService;
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

import java.io.IOException;
import java.util.Objects;

import static com.example.delivery_of_services_application.services.ChatService.chatRepository;

public class RequestController {

        @FXML
        ListView<String> listView;
        @FXML
        TextField username;
        @FXML
        Label label1;
        @FXML
        Label label2;
        @FXML
        Label label3;

        public void seeAnnouncementsButtonOnAction(){

            for(Chat c: chatRepository.find() )
                if(Objects.equals(c.destinatar, username.getText()))
                    listView.getItems().addAll(c.ad );
            listView.getViewOrder();

        }

        @FXML
        public void backButtonOnAction(ActionEvent event) throws IOException {
            Stage stage;
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ProviderHomePage.fxml"));
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
                if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())){
                    label1.setText(c.expeditor+" ---> "+c.destinatar);
                    label2.setText("Status: "+c.status);
                }

        }


        public void affirmButtonOnAction(ActionEvent actionEvent) {
            for(Chat c: chatRepository.find() )
                if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())){
                    c.status="Yes";
                    label3.setText("Status"+c.status);
                    chatRepository.update(c);
                }

        }

        public void denyButtonOnAction(ActionEvent actionEvent) {
            for(Chat c: chatRepository.find() )
                if(Objects.equals(c.ad, listView.getSelectionModel().getSelectedItem())){
                    c.status="No";
                    label3.setText("Status"+c.status);
                    chatRepository.update(c);
                }
        }
    }


