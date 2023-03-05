package com.example.JanBahon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminCycleController implements Initializable {

    @FXML
    private AnchorPane bikeButton;

    @FXML
    private AnchorPane carButton;


    @FXML
    private ListView<vehicle> listView;

    @FXML
    private AnchorPane logoutButton;

    @FXML
    private AnchorPane profileButton;

    @FXML
    private AnchorPane sellVehicleButton;

    @FXML
    private ImageView userImage;


    public ObservableList<vehicle> vehicleObservableList;

    public AdminCycleController() {


        vehicleObservableList = FXCollections.observableArrayList();

        //add some Students
        vehicleObservableList.addAll(
                new vehicle("Admin", "Cycle", "Malibag", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle1.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Rajarbag", "45/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle2.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Savar", "35/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle3.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Badda", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle4.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Paltan", "50/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle5.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Malibag", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle1.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Rajarbag", "45/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle2.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Savar", "35/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle3.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Badda", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle4.jpg"))),"Rent", new Button("Rent")),
                new vehicle("Admin", "Cycle", "Paltan", "50/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle5.jpg"))),"Rent", new Button("Rent"))
        );


    }


    @FXML
    void onAddVehicleButton(MouseEvent event) {

    }

    @FXML
    void onAddVehicleButton2(ActionEvent event) {

    }

    @FXML
    void onBikeButtonClicked(MouseEvent event) {

    }

    @FXML
    void onCarButtonClicked(MouseEvent event) {

    }

    @FXML
    void onCycleButtonClicked(MouseEvent event) {

    }

    @FXML
    void onLogoutButtonClicked(MouseEvent event) {

    }

    @FXML
    void onMessageButtonClicked(MouseEvent event) {

    }

    @FXML
    void onProfileButtonClicked(MouseEvent event) {

    }

    @FXML
    void onRefreshButtonClicked(MouseEvent event) {

    }

    @FXML
    void onSavedButtonClicked(MouseEvent event) {

    }

    @FXML
    void onSellButtonClicked(MouseEvent event) {

    }

    @FXML
    void onSellProductButtonClicked(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listView.setItems(vehicleObservableList);
        listView.setCellFactory(vehicleListView -> new VehicleListViewCell());

    }
}
