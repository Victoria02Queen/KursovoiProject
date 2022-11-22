package com.example.vic8.db;

import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Order;
import com.example.vic8.entity.Product;

import java.sql.*;
import java.util.ArrayList;

public class OrderRepository {

    private static final Connection connection;
    static {
        connection = ConnectionManager.getConnection();
    }
    public static ArrayList<Order> getOrder(){
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from orders");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int productId = resultSet.getInt("product_id");
                int contId = resultSet.getInt("cont_id");
                int productCount = resultSet.getInt("product_count");

                Order order = new Order();
                order.setId(id);
                order.setProduct_id(productId);
                order.setCont_id(contId);
                order.setProduct_count(productCount);

                orders.add(order);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public static void addOrder(Order order){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO orders(product_id, cont_id, product_count) " +
                    "VALUES ("+ order.getProductId() +", " +
                    order.getContId() + ", " +
                    order.getProductCount() + ");";
            System.out.println(sql);
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteOrderById(int id){
        try{
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM order WHERE id = " + id;
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateOrder(Order order){
        ArrayList<UpdateSetter> updateSetters = new ArrayList<>();

        if (order.getProductId() != null){
            updateSetters.add(new UpdateSetter("product_id", order.getProductId().toString()));
        }
        if (order.getContId() != null){
            updateSetters.add(new UpdateSetter("cont_id", order.getContId().toString()));
        }
        if (order.getProductCount() != null){
            updateSetters.add(new UpdateSetter("product_count", order.getProductCount().toString()));
        }
        if(updateSetters.size() == 0){
            System.out.println("Фильтр пустой");
            return;
        }
        try {
            Statement statement = connection.createStatement();
            UpdateHelper updateHelper = new UpdateHelper("Orders", updateSetters, order.getId());
            String sql = updateHelper.buildUpdate();
            System.out.println(sql);
            statement.execute(sql);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
