package com.ithillel.service.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.put("user", "postgres");
        dbProperties.put("password", "123");
        String url = "jdbc:postgresql://localhost:5432/test_db";
        try {
            System.out.println("DA");
            return DriverManager.getConnection(url, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to db :(");
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection == null) {
            System.out.println("NE ROBIT");
        } else {
            System.out.println("ROBIT");
        }
    }
}
