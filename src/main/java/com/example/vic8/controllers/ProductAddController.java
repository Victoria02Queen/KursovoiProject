package com.example.vic8.controllers;

import com.example.vic8.HelloApplication;
import com.example.vic8.db.ProductRepository;
import com.example.vic8.entity.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ProductAddController {
    @FXML
    private TextField productCodeColumn;

    @FXML
    private TextField productCostColumn;

    @FXML
    private TextField productNameColumn;

    @FXML
    private TextField workshopIdColumn;

    @FXML
    void onAddClick(ActionEvent event) throws IOException {
        Product product = new Product();
        product.setName(productNameColumn.getText());
        product.setCost(Integer.parseInt(productCostColumn.getText()));
        product.setWorkshop_id(Integer.parseInt(workshopIdColumn.getText()));
        product.setCode(Integer.parseInt(productCodeColumn.getText()));

        try {
            ProductRepository.addProduct(product);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Такого цеха не существует " , ButtonType.OK);
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
