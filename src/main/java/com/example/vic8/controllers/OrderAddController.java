package com.example.vic8.controllers;

import com.example.vic8.HelloApplication;
import com.example.vic8.db.OrderRepository;
import com.example.vic8.db.ProductRepository;
import com.example.vic8.entity.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderAddController {
    @FXML
    private TextField contractIdKeyColumn;

    @FXML
    private TextField productCountColumn;

    @FXML
    private TextField productIdKeyColumn;

    @FXML
    void onAddClick(ActionEvent event) throws IOException {
        Order order = new Order();

        order.setCont_id(Integer.parseInt(contractIdKeyColumn.getText()));
        order.setProduct_id(Integer.parseInt(productIdKeyColumn.getText()));
        order.setProduct_count(Integer.parseInt(productCountColumn.getText()));
//        OrderRepository.addOrder(order);
        try {
            OrderRepository.addOrder(order);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Такого договора или продукции не существует" , ButtonType.OK);
            alert.showAndWait();
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
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
