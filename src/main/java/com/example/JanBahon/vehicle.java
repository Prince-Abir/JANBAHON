package com.example.JanBahon;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class vehicle {
    private String owner_name;
    private String category;
    private String location;
    private String price;
    private Image image;

    private String serviceType;
    private Button button;

    public vehicle(String postedBy, String category, String location, String price, Image image,String serviceType,Button button) {
        this.owner_name = postedBy;
        this.category = category;
        this.location = location;
        this.price = price;
        this.image = image;
        this.serviceType = serviceType;
        this.button = button;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
