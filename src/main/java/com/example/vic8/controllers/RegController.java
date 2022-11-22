package com.example.vic8.controllers;


import com.example.vic8.HelloApplication;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegController {
    public TextField field1;
    public TextField field2;

    @FXML
    void onAuth(ActionEvent event) throws IOException {
        if (!field1.getText().equals("admin") || !field2.getText().equals("admin")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Неверный логин или пароль " , ButtonType.OK);
            alert.showAndWait();
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
    

}
