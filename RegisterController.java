package com.example.hcart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    TextField Email;
    @FXML
    TextField Name;
    @FXML
    PasswordField pass;
    @FXML
    TextField Dob;
    @FXML
    Button login;
//to register if we are new Users
    @FXML
    public void Registered(MouseEvent mouseEvent) throws SQLException {
//      calling query from Login table
        ResultSet res = Main.connect.executeQuery("Select emailId from Login");
//        adding values to each column in Login table
        while (res.next()) {
            String an = res.getString("emailId");
            System.out.println(an);
            String ab = Email.getText();
//             if the user has already registered with same email then a dialog box with user already registerd will appear
            if (an.contains(ab)) {
//                creating dialog box
                Dialog<String> dialog = new Dialog<>();
//                setting title
                dialog.setTitle("Login");
//                adding ok button and its action event
                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//                setting content
                dialog.setContentText("You have already Registered, Login!!");
//                adding to box
                dialog.getDialogPane().getButtonTypes().add(type);
//                executing time to show
                dialog.showAndWait();
//                setting email to null
                Email.setText("");
//                making login button visible
                login.setOpacity(1);
                break;
            }
        }
//        if any of column is empty ti will go else part
        if (!Name.getText().equals("") && !pass.getText().equals("") && !Dob.getText().equals("")){
//            if all colums are filled
            int results = 0;
//            we are adding it to login table
        String query = String.format("Insert into Login values('%s','%s','%s','%s')", Email.getText(), Name.getText(), pass.getText(), Dob.getText());
        results = Main.connect.UpdateQuery(query);
//         if added it shows dialog box that we are registered
        if (results > 0) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Login");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Succesfully!! created your ID and Password");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
//        setting login button to be visible
            login.setOpacity(1);
    }
//        if any colum is empty slows dialog box that fill columns
        else{
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Login");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Fill all the Columns!!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        }
    @FXML
    public void LoginPage(MouseEvent mouseEvent) throws IOException {
//        heading to login page after Registering
        HeaderController hg = new HeaderController();
        hg.LoginPage(mouseEvent);
    }
}
