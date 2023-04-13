package com.example.JanBahon;


import com.example.JanBahon.Database.DbConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class VehicleListViewCell extends ListCell<vehicle> {

    DbConnection dbConnection;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    vehicle vehicle;
    @FXML
    private Label postedBy;
    @FXML
    private Label category;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane listcell;
    @FXML
    private Label location;
    @FXML
    private Label price;
    @FXML
    private Button DeleteButton;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(vehicle vehicles, boolean empty) {
        super.updateItem(vehicles, empty);

        if (empty || vehicles == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("CustomListCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                dbConnection = new DbConnection();
                connection = dbConnection.connect();

                DeleteButton.setOnMouseClicked(event -> {

                    int id = vehicles.getVehicleId();


                    if (connection != null) {
                        String sql = "DELETE FROM `vehicle` WHERE id=" + id;


                        try {
                            preparedStatement = connection.prepareStatement(sql);
                            int affectedRow = preparedStatement.executeUpdate();

                            if (affectedRow > 0) {
                                getListView().getItems().remove(vehicles);
                                System.out.println("Item Deleted Successfully!" + id);
                            } else {
                                System.out.println("Item Deletion Failed!" + id);
                            }
                        } catch (SQLException e) {
                            System.out.println("SQL prepareStatement or  executeQuery" + e.getErrorCode());
                        }



                    }
                });


            }

            postedBy.setText(vehicles.getOwner_name());
            category.setText(vehicles.getCategory());
            location.setText(vehicles.getLocation());
            price.setText(vehicles.getPrice());
            image.setImage(vehicles.getImage());
            DeleteButton = vehicles.getButton();


            setText(null);
            setGraphic(listcell);


        }



    }

}
