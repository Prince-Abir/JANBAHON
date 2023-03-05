package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class RegistrationController {
    PreparedStatement statement;
    ResultSet result;
    DbConnection dbConnection;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private Label loginLink;

    @FXML
    private TextField nidNo;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private Button registarButton;

    @FXML
    private TextField username;

    @FXML
    void OnActionRegister(ActionEvent event) throws IOException, SQLException {


        dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();

        String user_name = username.getText();
        String user_email = email.getText();
        String user_password = password.getText();
        String user_phone = phone.getText();
        String user_address = address.getText();
        String user_nid = nidNo.getText();

        if (user_name.isEmpty() || user_email.isEmpty() || user_password.isEmpty() || user_phone.isEmpty() || user_address.isEmpty() || user_nid.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Field cannot be empty!");
            alert.setContentText("Please fill all the input field carefully..");
            alert.show();
        }
        else{

            String query = ("INSERT INTO users(username,email,password_,phone,address,nid) VALUES (?,?,?,?,?,?)");

            statement = connection.prepareStatement(query);

            statement.setString(1,user_name);
            statement.setString(2,user_email);
            statement.setString(3,user_password);
            statement.setString(4,user_phone);
            statement.setString(5,user_address);
            statement.setString(6,user_nid);

            statement.execute();


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("JAN BAHON");
            stage.setScene(scene);
            stage.show();
        }




    }

    @FXML
    void OnLoginLinkClicked(MouseEvent event) throws IOException {

        if (event.getSource() == loginLink){

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("JAN BAHON");
            stage.setScene(scene);
            stage.show();
        }
    }

}
