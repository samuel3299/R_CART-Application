package com.example.hcart;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HeaderController {

//Performing mouse Event register
    public void register(MouseEvent mouseEvent) throws IOException {
//        Adding new Anchor Pane to perform Action for Mouse Event
        AnchorPane anchorPane = new AnchorPane();
//        calling fxml file
        anchorPane = FXMLLoader.load(getClass().getResource("register.fxml"));
//        clearing the existing scene
        Main.root.getChildren().clear();
//        making new connection
        Main.root.getChildren().add(anchorPane);
    }
    public void LoginPage(MouseEvent mouseEvent) throws IOException {
//        adding fxml file to new Pane and for mouse event
        AnchorPane loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
//        clearing the root
        Main.root.getChildren().clear();
//        adding the page to root
        Main.root.getChildren().add(loginPage);
    }
}
