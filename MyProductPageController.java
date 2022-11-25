package com.example.hcart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyProductPageController {
    ListView<HBox> Ord;
    public ListView<HBox> View(MouseEvent mouseEvent) throws SQLException, IOException {
        //      Creating Observable list to make it visible in ListView
        ObservableList<HBox> OrderList = FXCollections.observableArrayList();
//        creating query
        String query = String.format("Select * from Products");
//        adding into result set
        ResultSet res = Main.connect.executeQuery(query);
//      creating lable, HBox and intiializing ListView
        Ord = new ListView<>();
        Label sno = new Label();
        Label name = new Label();
        Label price = new Label();
        Label desc = new Label();
        HBox details = new HBox();
//      setting the properties
        sno.setMinWidth(100);
        name.setMinWidth(200);
        price.setMinWidth(100);
        desc.setMinWidth(300);
//      Initializing the name to  heading
        sno.setText("S.NO");
        name.setText("Name");
        price.setText("Price");
        desc.setText("Description");
//      adding to Hbox and ObservableList
        details.getChildren().addAll(sno,name,price,desc);
        OrderList.add(details);
//        Selecing only the users Orders from total Orders;
        System.out.println(Main.email);
        while(res.next()) {
            if (res.getString("ProductUser").equals(Main.email)) {
//            creating Label for next user Order rows
                Label Sno = new Label();
                Label Name = new Label();
                Label Price = new Label();
                Label Desc = new Label();
                HBox Details = new HBox();
//          Setting properties
                Sno.setMinWidth(100);
                Name.setMinWidth(200);
                Price.setMinWidth(100);
                Desc.setMinWidth(300);
//            Setting text to labels
                Sno.setText(res.getString("SNO"));
                Name.setText(res.getString("Nams"));
                Price.setText(res.getString("Price"));
                Desc.setText(res.getString("Descr"));
//            adding to HBox and observable List
                Details.getChildren().addAll(Sno, Name, Price, Desc);
                OrderList.add(Details);
            }
        }
//        creating new Pane and calling same Same
        AnchorPane pane1 = new AnchorPane();
        pane1 = FXMLLoader.load(getClass().getResource("MyProductPage.fxml"));
//        adding Observable List to the ListView
        Ord.setItems(OrderList);
//        setting properties of List
        Ord.setLayoutX(70);
        Ord.setLayoutY(150);
        Ord.setPrefWidth(350);
        Ord.setPrefHeight(300);
//        adding List to Pane
        pane1.getChildren().add(Ord);
//        clearing and adding pane to root
        Main.root.getChildren().clear();
        Main.root.getChildren().add(pane1);
//        returning the view
        return Ord;
    }

    public void Back(MouseEvent mouseEvent) throws IOException {
        AnchorPane SellerPage = new AnchorPane();
        SellerPage = FXMLLoader.load(getClass().getResource("SellerPage.fxml"));
        Main.root.getChildren().clear();
        Main.root.getChildren().add(SellerPage);
    }

    public void Logout(MouseEvent mouseEvent) throws IOException {
        Header hd = new Header();
        Main.root.getChildren().clear();
        Main.root.getChildren().add(hd.root);
    }
}
