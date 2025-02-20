package com.example.session2fx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHandler {
Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5431/postgres", "postgres", "postgres");
        return connection;
    }


}
