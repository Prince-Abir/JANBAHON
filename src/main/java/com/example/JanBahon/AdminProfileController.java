package com.example.JanBahon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


public class AdminProfileController {

    @FXML
    private TextField passwordInputBox;

    @FXML
    private ImageView profileImage;

    @FXML
    private TextField usernameInputBox;

    public Parent root;
    File file;
    FileInputStream fileInputStream;
    Circle circle;

    @FXML
    void bikeButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminBike.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Bike");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void carButton(MouseEvent event) throws IOException {


        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCar.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Car");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createPostButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cycleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCycle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Cycle");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void sellVehicleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void imageDeleteButton(ActionEvent event) {

    }

    @FXML
    void imageUploadButton(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        file = new FileChooser().showOpenDialog(stage);


        if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);

                String filePath = file.getAbsolutePath();
                circle.setFill(new ImagePattern(new Image(filePath)));

            } catch (Exception e) {
                System.out.println("Image Upload Exception : File Input Stream!!!!");
            }


        }

    }

    @FXML
    void logoutButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Jan Bahon");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void profileButton(MouseEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminProfile.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void chatButtonCorner(MouseEvent event) {

        System.out.println("Messsage Button Clicked!");
    }

    @FXML
    void refreshButtonCorner(MouseEvent event) {

        System.out.println("Refresh Button Clicked!");

    }

    @FXML
    void savedButtonCorner(MouseEvent event) {

        System.out.println("Saved Vehicle Button Clicked!");
    }


}
