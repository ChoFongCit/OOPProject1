package com.example.demo;

import com.example.demo.controller.LabController;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
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
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Ball ball;
    private Player player1, player2;
    @Override
    public void start(Stage stage) throws IOException {
        try {
            LabCanvas canvas = new LabCanvas();
            StackPane root = new StackPane();
            root.getChildren().add(canvas);
            LabController labController = new LabController();
            Scene scene = new Scene(root, WIDTH, HEIGHT);

//            ball = new Ball(WIDTH / 2, HEIGHT / 2, 10, 10, 5, 5);
//            player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 5);
//            player2 = new Player(WIDTH - 50, HEIGHT / 2 - 40, 20, 80, 5);
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