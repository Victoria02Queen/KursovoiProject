package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.WorkshopRepository;
import com.example.vic8.entity.Workshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkshopAddController {
    @FXML
    private TextField workshopChiefColumn;

    @FXML
    private TextField workshopNameColumn;

    @FXML
    private TextField workshopNumberColumn;

    @FXML
    private TextField workshopPhoneColumn;

    @FXML
    void onAddClick(ActionEvent event) throws IOException {
        Workshop workshop = new Workshop();
        workshop.setNumber(Integer.valueOf(workshopNumberColumn.getText()));
        workshop.setName(workshopNameColumn.getText());
        workshop.setChief(workshopChiefColumn.getText());
        workshop.setPhone(workshopPhoneColumn.getText());

        WorkshopRepository.addWorkshop(workshop);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
}
