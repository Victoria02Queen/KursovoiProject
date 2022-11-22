package com.example.vic8.db;

import com.example.vic8.entity.Order;
import com.example.vic8.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    private static final Connection connection;
    static {
        connection = ConnectionManager.getConnection();
    }
    public static ArrayList<User> getUser(){
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from user");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                User user = new User();
                user.setId(id);
                user.setLogin(login);
                user.setPassword(password);

                users.add(user);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
