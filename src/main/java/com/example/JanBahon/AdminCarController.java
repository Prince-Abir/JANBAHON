package com.example.JanBahon;

import com.example.JanBahon.Database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminCarController implements Initializable {



    @FXML
    private ListView<vehicle> listView;

    @FXML
    private ImageView userImage;

    public Parent root;


    public ObservableList<vehicle> vehicleObservableList;

    public AdminCarController() throws SQLException {



        vehicleObservableList = FXCollections.observableArrayList();

        //add some Students
        vehicleObservableList.addAll(
//                new vehicle("Admin", "Car", "Malibag", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle1.jpg"))),"Rent", new Button("Rent")),
//                new vehicle("Admin", "Car", "Rajarbag", "45/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle2.jpg"))),"Rent", new Button("Rent"))
////                new vehicle("Admin", "Cycle", "Savar", "35/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle3.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Badda", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle4.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Paltan", "50/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle5.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Malibag", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle1.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Rajarbag", "45/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle2.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Savar", "35/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle3.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Badda", "40/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle4.jpg"))),"Rent", new Button("Rent")),
////                new vehicle("Admin", "Cycle", "Paltan", "50/hr", new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/cycle5.jpg"))),"Rent", new Button("Rent"))
        );

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

                if (Objects.equals(category, "Car")){
                    if (Objects.equals(service_type,"Rent")){
                        vehicleObservableList.add(new vehicle(owner,category,area,Rate,image,service_type,new Button("Delete")));
                    }

                }


            }
        }

    }



    @FXML
    void AddVehicleButton1(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AddVehicleButton2(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminAddVehicle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

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
    void cycleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminCycle.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Rent a Cycle");
        stage.setScene(scene);
        stage.show();
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
    void onMessageButtonClicked(MouseEvent event) {

    }

    @FXML
    void onRefreshButtonClicked(MouseEvent event) {

    }

    @FXML
    void onSavedButtonClicked(MouseEvent event) {

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
    void sellVehicleButton(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sellingVehicleButton2(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/adminSell.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Add New Vehicle");
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(vehicleObservableList);
        listView.setCellFactory(vehicleListView -> new VehicleListViewCell());


    }
}
