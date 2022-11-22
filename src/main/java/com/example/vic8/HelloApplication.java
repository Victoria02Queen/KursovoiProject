package com.example.vic8;

import com.example.vic8.db.*;
import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Order;
import com.example.vic8.entity.Product;
import com.example.vic8.entity.Workshop;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reg.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 440);
        mainStage = stage;
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
//        System.out.println(WorkshopRepository.getWorkshops());
//        System.out.println(ContractRepository.getContracts());
//        System.out.println(ProductRepository.getProducts());
//        System.out.println(OrderRepository.getOrder());
//        System.out.println(UserRepository.getUser());
//        Contract contract = new Contract();
//        contract.setNumber(2333);
//        contract.setCustomerName("Katya");
//        contract.setCustomerAddress("dot");
//        contract.setCreatingDate("01.03.20");
//        contract.setFinishDate("29.08.21");
//        ContractRepository.addContract(contract);
//        ContractRepository.deleteContractById(3);
//        contract.setId(7);
//        ContractRepository.updateContract(contract);

//        Workshop workshop = new Workshop();
//        workshop.setId(1);
//        workshop.setNumber(2);
//        workshop.setName("zavod #2");
//        workshop.setChief("Ilia");
//        workshop.setPhone("8964512344");
//        WorkshopRepository.updateWorkshop(workshop);


//        Product product = new Product();
//        product.setCode(2222);
//        product.setName("Nuckwe");
//        product.setCost(3456);
//        product.setWorkshop_id(6);
//        ProductRepository.addProduct(product);
//
//        Product product1 = new Product();
//        product1.setId(5);
//        product1.setCode(123);
//        product1.setName("twe");
//        product1.setCost(335);
//        product1.setWorkshop_id(1);
//        ProductRepository.updateProduct(product1);

//        WorkshopRepository.deleteWorkshopById(7);

//        Order order = new Order();
//        order.setProduct_id(5);
//        order.setCont_id(2);
//        order.setProduct_count(2324);
//        OrderRepository.addOrder(order);

//        Order order1 = new Order();
//        order1.setId(9);
//        order1.setProduct_id(6);
//        order1.setCont_id(4);
//        order1.setProduct_count(121);
//        OrderRepository.updateOrder(order1);
        launch();

    }
}