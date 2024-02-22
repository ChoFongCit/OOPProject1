package com.example.demo;

import com.example.demo.controller.LabController;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.shape.*;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            LabCanvas canvas = new LabCanvas();
            StackPane root = new StackPane();
            LabController labController = new LabController();
            Scene scene = new Scene(root, 320, 240);
            root.getChildren().add(canvas);
            stage.setTitle("ping pong");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        launch();
    }
}