package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    PreparedStatement statement;
    ResultSet result;

    @FXML
    private RadioButton admin;

    @FXML
    private TextField login_email;

    @FXML
    private TextField loginPassword;

    @FXML
    private Button loginButton;

    @FXML
    private RadioButton user;

    @FXML
    private Label signUpLink;

    @FXML
    private Label statusText;
    @FXML
    private ToggleGroup userCategory;


    @FXML
    void OnActionLogin(ActionEvent event) throws IOException, SQLException {

        String email = login_email.getText();
        String password = loginPassword.getText();
        String query = "SELECT email,password_ FROM users WHERE email= '" + email + "' AND password_='" + password + "'";

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();

        if (email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Field cannot be empty!");
            alert.setContentText("Please fill all the input field carefully..");
            alert.show();
        } else {

            statement = connection.prepareStatement(query);
            result = statement.executeQuery();

            if (result.next()) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("JAN BAHON");
                stage.setScene(scene);
                stage.show();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("user not found! ");
                alert.show();
            }

        }


        if (userCategory.getToggles().get(1) == userCategory.getSelectedToggle()) {

        } else if (userCategory.getToggles().get(0) == userCategory.getSelectedToggle()) {
            statusText.setText("Admin");
        } else {
            statusText.setText("Please Select a user Type");
        }


    }

    @FXML
    void OnSignUpLinkClicked(MouseEvent event) throws IOException {

        if (event.getSource() == signUpLink) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationScreen.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }


}
