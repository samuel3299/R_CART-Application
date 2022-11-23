package com.example.hcart;
// importing SQL
import java.sql.*;
public class Connector {
//    Initializing the Variables for Connection to SQL
    String URL = "jdbc:mysql://localhost:3306/cart?useSSL=false";
    String root = "root";
    String pass = "Ksamuel@1";
    Connection con = null;

    Connector(){
        try {
//            Making the Connection
            con = DriverManager.getConnection(URL, root, pass);
            if(con != null){
                System.out.println("Connected");
            }
        }
//        Exception if connection not established
        catch(Exception e){
            e.printStackTrace();
        }
    }
//    creating executable query to get values from tables in SQL
    public ResultSet executeQuery(String query) throws SQLException {
        ResultSet res = null;
//        creating a statement variable
        Statement statement = con.createStatement();
//        executing the statement called query
        res = statement.executeQuery(query);
        return res;

    }
//    creating executable query to update the table with new rows
    public int UpdateQuery(String query){
        int res = 0;
        try {
            Statement statement = con.createStatement();
            res = statement.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
