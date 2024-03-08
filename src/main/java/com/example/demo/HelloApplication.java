package com.example.demo;

import com.example.demo.controller.LabController;
import com.example.demo.controller.MenuListener;
import com.example.demo.model.Ball;
import com.example.demo.model.Game;
import com.example.demo.model.Player;
import com.example.demo.view.LabCanvas;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;


import java.io.IOException;

public class HelloApplication extends Application {
    private static double WIDTH = 800;
    private static double HEIGHT = 600;
    private Ball ball;
//    private Player player1, player2;
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
            Button changeNames = new Button("ChangeName");
            HBox options = new HBox(about, exitBtn, plusBall, minusBall,setRacket,setSpd,setWinCondition,changeNames);

            ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, 30, 5, 5);
            Player player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 5);
            Player player2 = new Player(WIDTH - 50, HEIGHT/ 2 - 40, 20, 80, 5);
            MenuListener menu = new MenuListener();
            Game game = new Game(ball, player1, player2);

            StackPane stem = new StackPane();
            stage.setResizable(true);
            LabCanvas canvas = new LabCanvas(WIDTH, HEIGHT,game, player1, player2);
            LabController control = new LabController(game,canvas);
            StackPane root = new StackPane();
            stem.getChildren().add(canvas);
            stem.getChildren().add(options);
            stem.setAlignment(options, Pos.BOTTOM_CENTER);


            Scene scene = new Scene(stem, WIDTH, HEIGHT);


            about.setOnAction(e-> menu.setAbout());
            exitBtn.setOnAction(e -> menu.setExit());
            control.startLoop();
            canvas.widthProperty().bind(stem.widthProperty());
            canvas.heightProperty().bind(stem.heightProperty());
//            canvas.widthProperty().addListener(evt -> canvas.setSize());
//            canvas.heightProperty().addListener(evt -> canvas.setSize());

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