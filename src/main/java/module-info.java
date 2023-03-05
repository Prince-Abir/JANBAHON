module com.example.demoapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires  javafx.graphics;
    requires  java.sql;

    exports com.example.JanBahon;
    opens com.example.JanBahon to javafx.fxml;

    exports com.example.JanBahon.Database;
    opens com.example.JanBahon.Database to javafx.fxml;


}