package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminCycleController implements Initializable {

    @FXML
    private ListView<vehicle> listView;

    public Parent root;



    public ObservableList<vehicle> vehicleObservableList;



    public AdminCycleController() throws SQLException {



        vehicleObservableList = FXCollections.observableArrayList();

        //vehicleObservableList.addAll()

        getItemsFromDB();



    }


    public void getItemsFromDB() throws SQLException {

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();

        if (connection != null){
            String sql = "SELECT * FROM vehicle";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Image image = null;
                int id = resultSet.getInt("id");
                String owner = resultSet.getString("owner");
                String category = resultSet.getString("category");
                String area = resultSet.getString("area");
                int rate = resultSet.getInt("rate");
                String service_type = resultSet.getString("service_type");
                Blob blob = resultSet.getBlob("image");
                if (blob!= null){
                    InputStream inputStream =  blob.getBinaryStream();
                    image = new Image(inputStream);
                }
                String Rate = String.valueOf(rate);

                if (category.compareToIgnoreCase("Cycle") == 0){
                    if (Objects.equals(service_type,"Rent")){
                        vehicleObservableList.add(new vehicle(id,owner,category,area,Rate,image,service_type,new Button("Delete")));
                    }

                }


            }
            connection.close();
        }


    }



    @FXML
    void onAddVehicleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
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
    void onBikeButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminBike.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Bike");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCarButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCar.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Car");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCycleButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCycle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Cycle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onLogoutButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Jan Bahon");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void onProfileButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminProfile.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Profile Settings");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void onSellButtonClicked(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSellProductButtonClicked(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onMessageButtonClicked(MouseEvent event) {

    }

    @FXML
    void onRefreshButtonClicked(MouseEvent event) {

    }

    @FXML
    void onSavedButtonClicked(MouseEvent event) {

    }


    @FXML
    void ProfileButtonCorner(MouseEvent event) {

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listView.setItems(vehicleObservableList);
        listView.setCellFactory(vehicleListView -> new VehicleListViewCell());



    }



}

