package com.fitness.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String membersTable = """
                CREATE TABLE IF NOT EXISTS members (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    first_name TEXT NOT NULL,
                    last_name TEXT NOT NULL,
                    phone TEXT NOT NULL,
                    egn TEXT NOT NULL UNIQUE,
                    email TEXT NOT NULL UNIQUE,
                    email_verified INTEGER NOT NULL DEFAULT 0,
                    subscription_id INTEGER NOT NULL,
                    start_date TEXT NOT NULL,
                    end_date TEXT NOT NULL,
                    payment_method TEXT NOT NULL,
                    amount REAL NOT NULL,
                    FOREIGN KEY (subscription_id) REFERENCES subscriptions(id)
                )
                """;

        String subscriptionsTable = """
                CREATE TABLE IF NOT EXISTS subscriptions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    duration_months INTEGER NOT NULL,
                    price REAL NOT NULL
                )
                """;

        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            statement.execute(subscriptionsTable);
            statement.execute(membersTable);

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            System.out.println("Database initialization failed.");
            e.printStackTrace();
        }
    }
}