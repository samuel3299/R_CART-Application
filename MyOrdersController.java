package com.example.hcart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.xml.sax.HandlerBase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyOrdersController {
//    initializing children in anchor pane by calling its file name
    ListView<HBox> Ord;
    @FXML
    Button logout;
    @FXML
    Button View;
    public void Back(MouseEvent mouseEvent) {
//        Back button mouse event sending it back to previous Page
        LoginController lc = new LoginController();
//        clearing scene and adding new scene
        Main.root.getChildren().clear();
        Main.root.getChildren().add(lc.ProductPage);
    }
//this is to view Orders after logging in by pressing view button and returning HBox containig table as result to show
    public ListView<HBox> ViewOrders(MouseEvent mouseEvent) throws SQLException, IOException {
//      Creating Observable list to make it visible in ListView
        ObservableList<HBox> OrderList = FXCollections.observableArrayList();
//        creating query
        String query = String.format("Select * from orders");
//        adding into result set
        ResultSet res = Main.connect.executeQuery(query);
//      creating lable, HBox and intiializing ListView
        Ord = new ListView<>();
        Label sno = new Label();
        Label name = new Label();
        Label price = new Label();
        HBox details = new HBox();
//      setting the properties
        sno.setMinWidth(100);
        name.setMinWidth(100);
        price.setMinWidth(100);
//      Initializing the name to  heading
        sno.setText("S.NO");
        name.setText("Name");
        price.setText("Price");
//      adding to Hbox and ObservableList
        details.getChildren().addAll(sno,name,price);
        OrderList.add(details);
//        Selecing only the users Orders from total Orders
        while(res.next() && res.getString("UserId").equals(Main.email)){
//            creating Label for next user Order rows
            Label Sno = new Label();
            Label Name = new Label();
            Label Price = new Label();
            HBox Details = new HBox();
//          Setting properties
            Sno.setMinWidth(100);
            Name.setMinWidth(100);
            Price.setMinWidth(100);
//            Setting text to labels
            Sno.setText(res.getString("Sno"));
            Name.setText(res.getString("NameofProd"));
            Price.setText(res.getString("Price"));
//            adding to HBox and observable List
            Details.getChildren().addAll(Sno,Name,Price);
            OrderList.add(Details);
        }
//        creating new Pane and calling same Same
        AnchorPane pane1 = new AnchorPane();
        pane1 = FXMLLoader.load(getClass().getResource("myOrders.fxml"));
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

    public void Logout(MouseEvent mouseEvent) throws IOException {
//        to logout from user and to return to main page
        Header head = new Header();
        Main.root.getChildren().clear();
        Main.root.getChildren().add(head.root);
    }
}
