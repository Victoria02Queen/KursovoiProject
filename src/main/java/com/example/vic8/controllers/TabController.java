package com.example.vic8.controllers;

import com.example.vic8.Bus;
import com.example.vic8.HelloApplication;
import com.example.vic8.db.ContractRepository;
import com.example.vic8.db.OrderRepository;
import com.example.vic8.db.ProductRepository;
import com.example.vic8.db.WorkshopRepository;
import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Order;
import com.example.vic8.entity.Product;
import com.example.vic8.entity.Workshop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TabController implements Initializable {
    @FXML
    private TableView<Workshop> workshopTable;
    @FXML
    private TableColumn<Workshop, Integer> workshopIdColumn;
    @FXML
    private TableColumn<Workshop, String> workshopNameColumn;
    @FXML
    private TableColumn<Workshop, String> workshopChiefColumn;
    @FXML
    private TableColumn<Workshop, String> workshopPhoneColumn;
    @FXML
    private TableColumn<Product, Integer> productCostColumn;

    @FXML
    private TableColumn<Product, Integer> productCodeColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> workshopIdKeyColumn;
    @FXML
    private TableView<Contract> contractTable;
    @FXML
    private TableColumn<Contract, String> contractAddressColumn;
    @FXML
    private TableColumn<Contract, String> contractDateFinishColumn;

    @FXML
    private TableColumn<Contract, String> contractCreatingDateColumn;

    @FXML
    private TableColumn<Contract, String> contractNameColumn;

    @FXML
    private TableColumn<Contract, Integer> contractNumbColumn;

    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> contractNumbKeyColumn;
    @FXML
    private TableColumn<Order, Integer> productKeyCodeColumn;
    @FXML
    private TableColumn<Order, Integer> productCountColumn;
    private String currentTab;

    ObservableList<Workshop> workshops = FXCollections.observableArrayList();
    ObservableList<Product> products = FXCollections.observableArrayList();
    ObservableList<Contract> contracts = FXCollections.observableArrayList();
    ObservableList<Order> orders = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        currentTab = "Цех";
        initData();
        workshopIdColumn.setCellValueFactory(new PropertyValueFactory<Workshop, Integer>("id"));
        workshopNameColumn.setCellValueFactory(new PropertyValueFactory<Workshop, String>("name"));
        workshopChiefColumn.setCellValueFactory(new PropertyValueFactory<Workshop, String>("chief"));
        workshopPhoneColumn.setCellValueFactory(new PropertyValueFactory<Workshop, String>("phone"));
        workshopTable.setItems(workshops);

        productCodeColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("code"));
        productCostColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("cost"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        workshopIdKeyColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("workshop_id"));
        productTable.setItems(products);

        contractNumbColumn.setCellValueFactory(new PropertyValueFactory<Contract, Integer>("number"));
        contractNameColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("customerName"));
        contractAddressColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("customerAddress"));
        contractCreatingDateColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("creatingDate"));
        contractDateFinishColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("finishDate"));
        contractTable.setItems(contracts);

        contractNumbKeyColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("contId"));
        productKeyCodeColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("productId"));
        productCountColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("productCount"));
        orderTable.setItems(orders);
    }

    private void initData(){
        ArrayList<Workshop> workshopArrayList = WorkshopRepository.getWorkshops();
        workshops.addAll(workshopArrayList);

        ArrayList<Product> productArrayList = ProductRepository.getProducts();
        products.addAll(productArrayList);

        ArrayList<Contract> contractArrayList = ContractRepository.getContracts();
        contracts.addAll(contractArrayList);

        ArrayList<Order> orderArrayList = OrderRepository.getOrder();
        orders.addAll(orderArrayList);
    }
    @FXML
    void onAddClick(ActionEvent event) throws IOException{
        switch (currentTab){
            case "Цех":
                addWorkshop();
                break;
            case "Продукция":
                addProduct();
                break;
            case "Договоры":
                addContract();
                break;
            case "Заказы":
                addOrder();
                break;
        }
    }
    private void addWorkshop() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WorkshopAddView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
    private void addProduct() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("productAddView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
    private void addContract() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contractAddView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
    private void addOrder() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("orderAddView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

    @FXML
     void onDeleteClick(ActionEvent event) {
        Workshop workshop = workshopTable.getSelectionModel().getSelectedItem();
        WorkshopRepository.deleteWorkshopById(workshop.getId());
        workshops.removeIf(w-> w.getId() == workshop.getId());
        System.out.println(workshop);
    }
    @FXML
    void onUpdateClick(ActionEvent event) throws IOException {
        switch (currentTab){
            case "Цех":
                updateWorkshop();
                break;
            case "Продукция":
                System.out.println("обновление продукции");
                updateProduct();
                break;
            case "Договоры":
                updateContract();
                break;
            case "Заказы":
                updateOrder();
                break;
        }
    }
    private void updateWorkshop() throws IOException{
        Workshop workshop = workshopTable.getSelectionModel().getSelectedItem();
        Bus.workshop = workshops.stream().filter(w->w.getId() == workshop.getId()).findFirst().orElse(null);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }
    private void updateProduct() throws IOException{
        Product product = productTable.getSelectionModel().getSelectedItem();
        Bus.product = products.stream().filter(p->p.getId() == product.getId()).findFirst().orElse(null);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("productUpdateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

    private void updateContract() throws IOException{
        Contract contract = contractTable.getSelectionModel().getSelectedItem();
        Bus.contract = contracts.stream().filter(c->c.getId() == contract.getId()).findFirst().orElse(null);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("contractUpdateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

    private void updateOrder() throws IOException{
        Order order = orderTable.getSelectionModel().getSelectedItem();
        Bus.order = orders.stream().filter(o->o.getId() == order.getId()).findFirst().orElse(null);
        System.out.println("окно добавление заказов");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("orderUpdateView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        Stage stage = new Stage();
        HelloApplication.mainStage.setScene(scene);
        HelloApplication.mainStage.show();
    }

    @FXML
    void onProductTabClick(Event event) {
        Tab tab  = (Tab)event.getSource();
        currentTab = tab.getText();
    }
    @FXML
    void onWorkShopTabClick(Event event) {
        Tab tab  = (Tab)event.getSource();
        currentTab = tab.getText();
    }
    @FXML
    void onContractTabClick(Event event) {
        Tab tab  = (Tab)event.getSource();
        currentTab = tab.getText();
    }
    @FXML
    void onOrderTabClick(Event event) {
        Tab tab  = (Tab)event.getSource();
        currentTab = tab.getText();
    }

}
