package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationScreen extends Application{


    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrationScreen.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         stage.setScene(scene);
         stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}