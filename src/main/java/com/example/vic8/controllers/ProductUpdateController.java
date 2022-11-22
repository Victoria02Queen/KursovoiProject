package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.ProductRepository;
import com.example.vic8.entity.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductUpdateController implements Initializable {

    @FXML
    private TextField productCost;

    @FXML
    private TextField productId;
    @FXML
    private TextField productName;
    @FXML
    private TextField productCode;
    @FXML
    private TextField workshopNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Product product = Bus.product;

        productId.setText(product.getId().toString());
        productName.setText(product.getName());
        productCost.setText(product.getCost().toString());
        productCode.setText(product.getCode().toString());
        workshopNumber.setText(product.getWorkshop_id().toString());

    }
    @FXML
    void onUpdateClick(ActionEvent event) throws IOException {
        Product product = Bus.product;

        product.setName(productName.getText());
        product.setCode(Integer.parseInt(productCode.getText()));
        product.setCost(Integer.parseInt(productCost.getText()));
        product.setWorkshop_id(Integer.parseInt(workshopNumber.getText()));

        ProductRepository.updateProduct(product);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

}
