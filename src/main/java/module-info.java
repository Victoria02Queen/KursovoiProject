module com.example.vic8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.vic8.entity to javafx.base;

    opens com.example.vic8 to javafx.fxml;
    exports com.example.vic8;
    exports com.example.vic8.controllers;
    opens com.example.vic8.controllers to javafx.fxml;
}