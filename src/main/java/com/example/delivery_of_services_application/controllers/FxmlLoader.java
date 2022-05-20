package com.example.delivery_of_services_application.controllers;

import com.example.delivery_of_services_application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;
 public Pane getPage(String fileName) {
     try{
             //throw new FileNotFoundException("FXML can't be found");
         view = FXMLLoader.load(getClass().getClassLoader().getResource(fileName));;
     }catch(Exception e) {
          System.out.println("No found");
     }
     return view;
 }
}
