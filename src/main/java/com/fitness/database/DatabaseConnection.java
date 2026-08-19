package com.fitness.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:fitness.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}