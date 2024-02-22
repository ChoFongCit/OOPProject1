package com.example.demo.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class MenuListener {

    public void setExit() {
        System.out.println("Exit");
        Platform.exit();
    }

    public void setAbout() {
        System.out.println("ABOUT");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Super Ping pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights resereved");
        alert.showAndWait().ifPresent((btnType) -> {
        });
    }

    public void setGameLimit() {
        TextInputDialog dialog = new TextInputDialog(); // create an instance
        dialog.setTitle("Title");
    }
}
