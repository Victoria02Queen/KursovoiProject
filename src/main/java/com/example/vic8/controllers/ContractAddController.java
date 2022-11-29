package com.example.vic8.controllers;

import com.example.vic8.HelloApplication;
import com.example.vic8.db.ContractRepository;
import com.example.vic8.entity.Contract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ContractAddController {

    @FXML
    private TextField contractAddressColumn;

    @FXML
    private TextField contractCreatingDateColumn;

    @FXML
    private TextField contractFinicsDateColumn;

    @FXML
    private TextField contractNameColumn;

    @FXML
    private TextField contractNumberColumn;

    @FXML
    void onAddClick(ActionEvent event) throws IOException {
        Contract contract = new Contract();
        contract.setNumber(Integer.valueOf(contractNumberColumn.getText()));
        contract.setCustomerName(contractNameColumn.getText());
        contract.setCustomerAddress(contractAddressColumn.getText());
        contract.setCreatingDate(contractCreatingDateColumn.getText());
        contract.setFinishDate(contractFinicsDateColumn.getText());

        ContractRepository.addContract(contract);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 490, 407);
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
