package com.fitness.database;

import com.fitness.model.Subscription;

import java.util.List;

public class SubscriptionInitializer {

    public static void initialize() {

        SubscriptionRepository repository =
                new SubscriptionRepository();

        List<Subscription> subscriptions = repository.findAll();

        if (!subscriptions.isEmpty()) {
            return;
        }

        repository.save(new Subscription("1 Month", 1, 50.00));
        repository.save(new Subscription("3 Months", 3, 130.00));
        repository.save(new Subscription("6 Months", 6, 240.00));
        repository.save(new Subscription("12 Months", 12, 400.00));

        System.out.println("Default subscriptions created.");
    }
}