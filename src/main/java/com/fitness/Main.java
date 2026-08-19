package com.fitness;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.fitness.database.DatabaseInitializer;
import com.fitness.database.SubscriptionInitializer;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseInitializer.initialize();
        SubscriptionInitializer.initialize();
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/fxml/main-view.fxml"));

        Scene scene = new Scene(loader.load(), 1000, 650);

        stage.setTitle("Fitness Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}