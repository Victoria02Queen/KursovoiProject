package com.example.vic8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;

    @FXML
    private TableView<User> col111;

    @FXML
    private TableColumn<User, String> colLogin;

    @FXML
    private TableColumn<?, ?> colPass;

    ObservableList<User> users = FXCollections.observableArrayList();


    public void onUpdateClick(ActionEvent event) {
    }

    public void onAdd(ActionEvent event) {
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setContentText("On");
        al.show();
    }

    public void onChange(ActionEvent event) {
    }

    public void onDelete(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users.add(new User("Ilia","Login"));
        users.add(new User("Vlad","Login1"));
        users.add(new User("Islam","Login2"));
        users.add(new User("Dima","Login3"));
        colLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        col111.setItems(users);
    }
}