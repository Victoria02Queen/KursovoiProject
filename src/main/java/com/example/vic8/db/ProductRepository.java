package com.example.vic8.db;

import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Order;
import com.example.vic8.entity.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {
    private static final Connection connection;
    static {
        connection = ConnectionManager.getConnection();
    }

    public static ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from product");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int code = resultSet.getInt("code");
                String productName = resultSet.getString("name");
                int productCost = resultSet.getInt("cost");
                int productWorkshopId = resultSet.getInt("workshop_id");



                Product product = new Product();
                product.setId(id);
                product.setCode(code);
                product.setName(productName);
                product.setCost(productCost);
                product.setWorkshop_id(productWorkshopId);

                products.add(product);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static void addProduct(Product product){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Product(code, name, cost, workshop_id) " +
                    "VALUES ("+ product.getCode() +", " +
                    "'" + product.getName() + "', " +
                    "'" + product.getCost() + "', "+
                    "'" + product.getWorkshop_id() + "');";
            statement.execute(sql);
            System.out.println(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteProductById(int id){
        try{
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM product WHERE id = " + id;
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateProduct(Product product){
        ArrayList<UpdateSetter> updateSetters = new ArrayList<>();

        if (product.getCode() != null){
            updateSetters.add(new UpdateSetter("code", product.getCode().toString()));
        }
        if (product.getName() != null){
            updateSetters.add(new UpdateSetter("name", "'" + product.getName() + "'"));
        }
        if (product.getCost() != null){
            updateSetters.add(new UpdateSetter("cost", product.getCost().toString()));
        }
        if (product.getWorkshop_id() != null){
            updateSetters.add(new UpdateSetter("workshop_id", product.getWorkshop_id().toString()));
        }
        if(updateSetters.size() == 0){
            System.out.println("Фильтр пустой");
            return;
        }
        try {
            Statement statement = connection.createStatement();
            UpdateHelper updateHelper = new UpdateHelper("Product", updateSetters, product.getId());
            String sql = updateHelper.buildUpdate();
            System.out.println(sql);
            statement.execute(sql);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
