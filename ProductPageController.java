package com.example.hcart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPageController {
//    calling FXML variables
    @FXML
            TextField Searchfld;
    @FXML
            Button search;
//  intitalizing ListView
    ListView<HBox> hb;
//creating list to view the Available Products
        public ListView<HBox> View() throws SQLException, IOException {
//            creating Observable List
        ObservableList<HBox> productList = FXCollections.observableArrayList();
//        creating query
        String query = String.format("Select * from Products");
//        adding query to resultSet
        ResultSet res = Main.connect.executeQuery(query);
//        initializing ListView and creating labels and HBox
        hb = new ListView<>();
        Label sno = new Label();
        Label name = new Label();
        Label price = new Label();
        Label desc = new Label();
        Label buy = new Label();
        HBox details = new HBox();
//      setting properties for Label
        sno.setMinWidth(40);
        name.setMinWidth(200);
        price.setMinWidth(200);
        desc.setMinWidth(400);
        buy.setMinWidth(70);
//      setting Headings for Labels
        sno.setText("S.NO");
        name.setText("Name");
        price.setText("Price");
        desc.setText("Description");
        buy.setText("Buy");
//      adding them to HBox and Observable List
        details.getChildren().addAll(sno,name,price,desc,buy);
        productList.add(details);
//        creating loop to call all rows while next exist
        while(res.next()){
//            Intializing label for each Row
            Label SNO = new Label();
            Label productName = new Label();
            Label ProductPrice = new Label();
            Label Desc = new Label();
            Button b1 = new Button();
            HBox ProductDetails = new HBox();
//          setting properties for each label
            SNO.setMinWidth(40);
            productName.setMinWidth(200);
            ProductPrice.setMinWidth(200);
            Desc.setMinWidth(400);
//            setting text to each label
            SNO.setText(res.getString("SNO"));
            productName.setText(res.getString("Nams"));
            ProductPrice.setText(res.getString("Price"));
            Desc.setText(res.getString("Descr"));
            b1.setText("buy");
//            action event for button Buy
            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
//                    Calling query and equating to res
                    ResultSet res = null;
                    try {
                        res = Main.connect.executeQuery("Select * from orders");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
//                    initializing value to upade query
                    int ordered = 0;
                    try {
                        if (res.next()){
//                            inserting into Products table in SQL
                            String query = String.format("Insert Into Orders Values(%s,'%s','%s','%s')",SNO.getText(),Main.email,productName.getText(),ProductPrice.getText());
//                            updating query after inserting it
                            ordered = Main.connect.UpdateQuery(query);
//                             if Query is updated showing a dialog box if order is placed
                            if(ordered > 0){
//                                creating dialog Box
                                Dialog<String> dialog = new Dialog<>();
//                                setting title
                                dialog.setTitle("Orders");
//                                creating button and adding action event
                                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//                                Diplay Message
                                dialog.setContentText("Your Order is Placed");
//                                adding button and message to box
                                dialog.getDialogPane().getButtonTypes().add(type);
//                                return type as wait
                                dialog.showAndWait();
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
//            finally adding to children of Observable list
            ProductDetails.getChildren().addAll(SNO, productName,ProductPrice,Desc, b1);
//            adding to listview
            productList.add(ProductDetails);
//            System.out.println("Yes");
        }
//        creating ancho pane and calling same file and setting properties to ListView
        AnchorPane pane = new AnchorPane();
        pane = FXMLLoader.load(getClass().getResource("productPage.fxml"));
        hb.setItems(productList);
        hb.setLayoutX(50);
        hb.setLayoutY(100);
        hb.setPrefWidth(400);
        hb.setPrefHeight(350);
//        adding to pane and finally to Group of main class and returning ListView
        pane.getChildren().add(hb);
        Main.root.getChildren().clear();
        Main.root.getChildren().add(pane);
        return hb;
    }
//updating the Products based on search
    public ListView<HBox> Search(MouseEvent mouseEvent) throws SQLException, IOException  {
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        String query = String.format("Select * from Products");
        ResultSet res = Main.connect.executeQuery(query);
        hb = new ListView<>();
        Label sno = new Label();
        Label name = new Label();
        Label price = new Label();
        Label desc = new Label();
        Label buy = new Label();
        HBox details = new HBox();

        sno.setMinWidth(40);
        name.setMinWidth(200);
        price.setMinWidth(200);
        desc.setMinWidth(400);
        buy.setMinWidth(70);

        sno.setText("S.NO");
        name.setText("Name");
        price.setText("Price");
        desc.setText("Description");
        buy.setText("Buy");

        details.getChildren().addAll(sno,name,price,desc,buy);
        productList.add(details);
//        Comparing each character of Name and returning if the character is present
        while(res.next() && res.getString("Nams").contains(Searchfld.getText())){
            Label SNO = new Label();
            Label productName = new Label();
            Label ProductPrice = new Label();
            Label Desc = new Label();
            Button b1 = new Button();
            HBox ProductDetails = new HBox();

            SNO.setMinWidth(40);
            productName.setMinWidth(200);
            ProductPrice.setMinWidth(200);
            Desc.setMinWidth(400);
            SNO.setText(res.getString("SNO"));
            productName.setText(res.getString("Nams"));
            ProductPrice.setText(res.getString("Price"));
            Desc.setText(res.getString("Descr"));
            b1.setText("buy");
            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ResultSet res = null;
                    try {
                        res = Main.connect.executeQuery("Select * from orders");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    int ordered = 0;
                    try {
                        if (res.next()){
                            String query = String.format("Insert Into Orders Values(%s,'%s','%s','%s')",SNO.getText(),Main.email,productName.getText(),ProductPrice.getText());
                            ordered = Main.connect.UpdateQuery(query);
                            if(ordered > 0){
                                Dialog<String> dialog = new Dialog<>();
                                dialog.setTitle("Orders");
                                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                                dialog.setContentText("Your Order is Placed");
                                dialog.getDialogPane().getButtonTypes().add(type);
                                dialog.showAndWait();
                            }
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            ProductDetails.getChildren().addAll(SNO, productName,ProductPrice,Desc, b1);
            productList.add(ProductDetails);
//            System.out.println("Yes");
        }
        AnchorPane pane = new AnchorPane();
        pane = FXMLLoader.load(getClass().getResource("productPage.fxml"));
        hb.setItems(productList);
        hb.setLayoutX(50);
        hb.setLayoutY(100);
        hb.setPrefWidth(400);
        hb.setPrefHeight(350);
        pane.getChildren().add(hb);
        Main.root.getChildren().clear();
        Main.root.getChildren().add(pane);
        return hb;
    }

    public void ShowOrd(MouseEvent mouseEvent) throws IOException {
//            redirecting to Orders page to view my orders
            AnchorPane Order = new AnchorPane();
            Order = FXMLLoader.load(getClass().getResource("myOrders.FXML"));
            Main.root.getChildren().clear();
            Main.root.getChildren().add(Order);
    }
}
