package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class AdminAddVehicleController {

    Parent root;

    @FXML
    private Button AddVehicleButton;

    @FXML
    private Button SellingProductsListButton;


    @FXML
    private ImageView chatButton;

    @FXML
    private Button imageDeleteButton;

    @FXML
    private Button imageUploadButton;


    @FXML
    private ImageView refreshButton;

    @FXML
    private ImageView savedButton;


    @FXML
    private ImageView userCornerImage;


    @FXML
    private RadioButton optionRent;

    @FXML
    private RadioButton optionSell;


    @FXML
    private ToggleGroup toogleOptions;


    @FXML
    private TextField postedByInputBox;

    @FXML
    private TextField vehicleCategoryInputBox;

    @FXML
    private TextField areaInputBox;

    @FXML
    private TextField rateInputBox;

    PreparedStatement statement;

    FileInputStream fileInputStream;
    File file;
    @FXML
    private Circle circle;


    @FXML
    void OnAddVehicle(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onCycleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCycle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Cycle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBikeButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminBike.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Bike");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onCarButton(MouseEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCar.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Car");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onImageUploadButton(ActionEvent event) {

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
    void onCreatePostButton(ActionEvent event) throws IOException, SQLException {


        String owner = postedByInputBox.getText();
        String category = vehicleCategoryInputBox.getText();
        String area = areaInputBox.getText();
        String rates = rateInputBox.getText();
        String service_type = "";
        int rate = 0;

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();

        String sqlQuery = "INSERT INTO vehicle (owner,category,area,rate,service_type,image) VALUES(?,?,?,?,?,?)";


        if (toogleOptions.getSelectedToggle() == null) {
            service_type = "";
        } else if (toogleOptions.getSelectedToggle() == optionRent) {
            service_type = "Rent";
        } else {
            service_type = "Sell";
        }


        if (owner.isEmpty() || category.isEmpty() || area.isEmpty() || rates.isEmpty() || service_type.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setX(640);
            alert.setY(100);
            alert.setContentText("Fill all the field carefully..");
            alert.show();
        } else {
            try {
                rate = Integer.parseInt(rates);

                statement = connection.prepareStatement(sqlQuery);

                statement.setString(1, owner);
                statement.setString(2, category);
                statement.setString(3, area);
                statement.setInt(4, rate);
                statement.setString(5, service_type);
                statement.setBlob(6, fileInputStream);

                statement.execute();


                System.out.println("Inserted Successfully...");

                fileInputStream = null;

                postedByInputBox.setText("");
                vehicleCategoryInputBox.setText("");
                areaInputBox.setText("");
                postedByInputBox.setText("");
                rateInputBox.setText("");
                circle.setFill(null);

                fileInputStream.close();
                connection.close();
                statement.close();


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Rate Must be a Number");
                alert.show();
            }


        }


    }

    @FXML
    void onVehicleSellingButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    void onProfileButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminProfile.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onLogoutButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Jan Bahon");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onAddVehicleButton2(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onMessageButtonClicked(MouseEvent event) {

        System.out.println("Message Button Clicked! ");

    }

    @FXML
    void onRefreshButtonClicked(MouseEvent event) {

        System.out.println("Refresh Button Clicked! ");
    }

    @FXML
    void onSavedButtonClicked(MouseEvent event) {

        System.out.println("Saved Button Clicked");
    }


    @FXML
    void onImageClearButton(ActionEvent event) throws IOException {

        file = null;
        circle.setFill(null);
    }


    @FXML
    void onSellingProductsListButton2(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();

    }


}
