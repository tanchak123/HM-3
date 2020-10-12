package com.ithillel.service.textprocessor;

import com.ithillel.service.connection.ConnectionUtil;

import java.sql.*;

public class PostgreTextProcessor {
    Connection connection = ConnectionUtil.getConnection();

    public void save(String text) {
        try (PreparedStatement statement = connection
                .prepareStatement("CALL save_on_db(?)")) {
            statement.setString(1, text);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String get(int id) {
        String result = null;
        try (PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM text_processor WHERE text_id = ?")) {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            result = resultSet.getString("text");
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void refresh() {
        try (PreparedStatement statement1 = connection
                .prepareStatement("DELETE FROM text_processor");
            Statement statement2 = connection
                .createStatement()) {
            statement1.executeUpdate();
            statement2.execute("ALTER SEQUENCE text_processor_text_id_seq RESTART WITH 1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PostgreTextProcessor postgreTestProcessor = new PostgreTextProcessor();
        postgreTestProcessor.refresh();
        postgreTestProcessor.save("Sanya");
        postgreTestProcessor.save("Vasya");
        postgreTestProcessor.save("Fedya");
        postgreTestProcessor.save("Alex");
        System.out.println(postgreTestProcessor.get(1));
        System.out.println(postgreTestProcessor.get(2));
        System.out.println(postgreTestProcessor.get(3));
        System.out.println(postgreTestProcessor.get(4));

    }
}
