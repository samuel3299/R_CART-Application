package com.example.hcart;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class Header {
//    making global variable to directly access anchor pane for executing mouse event
    public AnchorPane root;
    Header() throws IOException {
//        calling fxml file
        root = FXMLLoader.load(getClass().getResource("header.fxml"));
    }

}
