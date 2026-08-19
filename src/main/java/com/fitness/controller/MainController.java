package com.fitness.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private void openMembers(ActionEvent event) throws IOException {

        System.out.println(
                getClass().getResource("/fxml/members-view.fxml")
        );

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/fxml/members-view.fxml"));

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root, 1000, 650));
        stage.show();
    }
}