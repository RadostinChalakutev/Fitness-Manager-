package com.fitness.database;

import com.fitness.model.Subscription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {

    public void save(Subscription subscription) {

        String sql = """
                INSERT INTO subscriptions (name, duration_months, price)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, subscription.getName());
            statement.setInt(2, subscription.getDurationMonths());
            statement.setDouble(3, subscription.getPrice());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subscription> findAll() {

        List<Subscription> subscriptions = new ArrayList<>();

        String sql = "SELECT * FROM subscriptions";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Subscription subscription = new Subscription(
                        resultSet.getString("name"),
                        resultSet.getInt("duration_months"),
                        resultSet.getDouble("price")
                );

                subscription.setId(resultSet.getInt("id"));

                subscriptions.add(subscription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subscriptions;
    }
}