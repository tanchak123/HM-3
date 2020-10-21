package com.ithillel.service.connection;

import com.ithillel.service.storage.HashMapStorage;
import com.ithillel.service.storage.Storage;
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionPool {
    private String url;
    private String user;
    private String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();


    public static MyConnectionPool create(String url, String user,
            String password) throws SQLException {
        int INITIAL_POOL_SIZE = 10;
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new MyConnectionPool(url, user, password, pool);
    }

    public MyConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public static void main(String[] args) throws SQLException {
        MyConnectionPool connectionPool = MyConnectionPool
                .create("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        String query = "INSERT INTO text_processor (text) VALUES(?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(query)) {
            preparedStatement.setString(1, "TEST");
            preparedStatement.executeUpdate();
            connectionPool.releaseConnection(connection);
        } catch (SQLException throwables) {
            throw new RuntimeException("MISTAKE", throwables);
        }
    }
}
