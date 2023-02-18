package com.example.JanBahon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private RadioButton admin;

    @FXML
    private Button loginButton;

    @FXML
    private RadioButton user;

    @FXML
    private Label signuplink;

    @FXML
    private Label statusText;
    @FXML
    private ToggleGroup userCategory;


    @FXML
    void OnActionLogin(ActionEvent event) {


       if (userCategory.getToggles().get(1) == userCategory.getSelectedToggle()){
           statusText.setText("User");
       }
        else if (userCategory.getToggles().get(0) == userCategory.getSelectedToggle()){
            statusText.setText("Admin");
        }
        else{
           statusText.setText("Please Select a user Type");
       }

    }

    @FXML
    void OnSignUpLinkClicked(MouseEvent event) throws IOException {

        if (event.getSource() == signuplink){

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationScreen.fxml")));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }



}
