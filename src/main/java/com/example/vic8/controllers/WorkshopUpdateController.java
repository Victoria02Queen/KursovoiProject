package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.WorkshopRepository;
import com.example.vic8.entity.Workshop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WorkshopUpdateController implements Initializable {
    @FXML
    private TextField workshopChief;
    @FXML
    private TextField workshopId;
    @FXML
    private TextField workshopName;
    @FXML
    private TextField workshopNumber;
    @FXML
    private TextField workshopPhone;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Workshop workshop = Bus.workshop;
        workshopId.setText(workshop.getId().toString());
        workshopChief.setText(workshop.getChief());
        workshopName.setText(workshop.getName());
        workshopNumber.setText(workshop.getNumber().toString());
        workshopPhone.setText(workshop.getPhone());
    }
    @FXML
    void onUpdateClick(ActionEvent event) throws IOException {
        Workshop workshop = Bus.workshop;
        workshop.setName(workshopName.getText());
        workshop.setChief(workshopChief.getText());
        workshop.setNumber(Integer.valueOf(workshopNumber.getText()));
        workshop.setPhone(workshopPhone.getText());
        WorkshopRepository.updateWorkshop(workshop);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

    @FXML
    void onBackMainForm(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
}
