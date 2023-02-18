module com.example.demoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires  javafx.graphics;

    exports com.example.JanBahon;
    opens com.example.JanBahon to javafx.fxml;

}