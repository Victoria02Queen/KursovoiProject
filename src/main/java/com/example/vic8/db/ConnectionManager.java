package com.example.vic8.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/db1?User=root&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
