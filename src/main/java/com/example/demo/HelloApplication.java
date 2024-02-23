package com.example.demo;

import com.example.demo.controller.LabController;
import com.example.demo.controller.MenuListener;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
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
            Button about = new Button("About");
            Button exitBtn = new Button("Exit");
            Button plusBall = new Button("+ballsize");
            Button minusBall = new Button("-ballsize");
            Button setSpd = new Button("SetSpd");
            Button setRacket = new Button("setRacket");
            Button setWinCondition = new Button("WinCondition");
            HBox options = new HBox(about, exitBtn, plusBall, minusBall,setRacket,setSpd,setWinCondition);

            MenuListener menu = new MenuListener();
            Game game = new Game();
            BorderPane stem = new BorderPane();
            stage.setResizable(true);
            LabCanvas canvas = new LabCanvas(game);
            StackPane root = new StackPane();
            root.getChildren().add(canvas);
            stem.setCenter(root);
            stem.setTop(options);
            Scene scene = new Scene(stem, WIDTH, HEIGHT);


            about.setOnAction(e-> menu.setAbout());
            exitBtn.setOnAction(e -> menu.setExit());

            stage.setTitle("pongfx");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){

        }
    }

    public static void main(String[] args) {
        launch();
    }
}