package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.OrderRepository;
import com.example.vic8.entity.Order;
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

public class OrderUpdateController implements Initializable {
    @FXML
    private TextField contractIdColumn;

    @FXML
    private TextField orderIdColumn;

    @FXML
    private TextField productCountColumn;

    @FXML
    private TextField productIdColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Order order = Bus.order;

        contractIdColumn.setText(order.getContId().toString());
        orderIdColumn.setText(order.getId().toString());
        productIdColumn.setText(order.getProductId().toString());
        productCountColumn.setText(order.getProductCount().toString());
    }
    @FXML
    void onUpdateClick(ActionEvent event) throws IOException {
        Order order = Bus.order;

        order.setCont_id(Integer.parseInt(contractIdColumn.getText()));
        order.setProduct_id(Integer.parseInt(productIdColumn.getText()));
        order.setProduct_count(Integer.parseInt(productCountColumn.getText()));

        OrderRepository.updateOrder(order);

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
