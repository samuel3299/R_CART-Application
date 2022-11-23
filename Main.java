package com.example.hcart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
//    Initiating Variables as Global to access in other classes
    public static Connector connect;
    public static String email;
//creating Global Scene so that we can keep them in same Scene
    public static Group root;
    public void start(Stage stage) throws IOException {
//        Initiatializing the variables
        email = "";
         connect = new Connector();
//         creating Header Obj
        Header head = new Header();
        root = new Group();
//        adding children to the Scene
        root.getChildren().add(head.root);
//        Setting scene properties
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("CART");
        stage.setScene(scene);
        stage.show();
//        closing the stage
        stage.setOnCloseRequest(e ->{
            try {
                connect.con.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
//launching the Main class
    public static void main(String[] args) {
        launch();
    }
}