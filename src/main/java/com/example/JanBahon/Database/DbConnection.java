package com.example.JanBahon.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    Connection connection;
    String URL = "jdbc:mysql://localhost:3306/janbahon";
    String USER = "root";
    String Password = "";


    public Connection connect() {


        try {
            connection = DriverManager.getConnection(URL,USER,Password);
            System.out.println("Connection Secured! ");
            return connection;
        } catch (SQLException e) {
            return null;
        }

    }
}
