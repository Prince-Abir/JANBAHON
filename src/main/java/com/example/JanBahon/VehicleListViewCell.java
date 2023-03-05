package com.example.JanBahon;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class VehicleListViewCell extends ListCell<vehicle> {


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
    private Button rentButton;

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

            }

            postedBy.setText(vehicles.getOwner_name());
            category.setText(vehicles.getCategory());
            location.setText(vehicles.getLocation());
            price.setText(vehicles.getPrice());
            image.setImage(vehicles.getImage());
            rentButton = vehicles.getButton();



            setText(null);
            setGraphic(listcell);


        }

    }

}
