package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.ContractRepository;
import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Product;
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

public class ContractUpdateContoller implements Initializable {
    @FXML
    private TextField contractCustomerAddress;

    @FXML
    private TextField contractCustomerName;

    @FXML
    private TextField contractDateFinish;

    @FXML
    private TextField contractCreatingDate;

    @FXML
    private TextField contractId;

    @FXML
    private TextField contractNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Contract contract = Bus.contract;

        contractId.setText(contract.getId().toString());
        contractNumber.setText(contract.getNumber().toString());
        contractCustomerName.setText(contract.getCustomerName());
        contractCustomerAddress.setText(contract.getCustomerAddress());
        contractCreatingDate.setText(contract.getCreatingDate());
        contractDateFinish.setText(contract.getFinishDate());
    }

    @FXML
    void onUpdateClick(ActionEvent event) throws IOException {
        Contract contract = Bus.contract;

        contract.setNumber(Integer.valueOf(contractNumber.getText()));
        contract.setCustomerName(contractCustomerName.getText());
        contract.setCreatingDate(contractCreatingDate.getText());
        contract.setFinishDate(contractDateFinish.getText());
        contract.setCustomerAddress(contractCustomerAddress.getText());

        ContractRepository.updateContract(contract);

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
