package com.example.hcart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {
    @FXML
    TextField ProductName;
    @FXML
    TextField ProductPrice;
    @FXML
    TextField ProductDesc;
    @FXML
    public void Add(MouseEvent mouseEvent) throws SQLException {
//        Adding Seller items to ProductsTable
        ResultSet res1 = null;
            String que = String.format("Select max(SNO) from Products");
            res1 = Main.connect.executeQuery(que);
            int a = 0;
            if(res1.next()) {
                a = res1.getInt("max(SNO)")+1;
            }
            String ques = String.format("insert into Products values(%s,'%s','%s','%s','%s')",a,ProductName.getText(),ProductPrice.getText(),ProductDesc.getText(),Main.email);
            int ans = Main.connect.UpdateQuery(ques);
            if(ans > 0){
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Product");
                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Your Product is added");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
    }
//Going to my Product Page
    public void ViewProductPage(MouseEvent mouseEvent) throws IOException {
        AnchorPane SellerPage = new AnchorPane();
        SellerPage = FXMLLoader.load(getClass().getResource("MyProductPage.fxml"));
       Main.root.getChildren().clear();
       Main.root.getChildren().add(SellerPage);
    }
}
