package pong;

import pong.controller.KeyboardListener;
import pong.controller.PongController;
import pong.controller.MenuListener;
import pong.model.Ball;
import pong.model.Game;
import pong.model.Player;
import pong.view.View;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;


import java.io.IOException;

public class main extends Application {
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

            ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, -1, 1);
            Player player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 10);
            Player player2 = new Player(WIDTH - 50, HEIGHT/ 2 - 40, 20, 80, 10);
            Game game = new Game(ball, player1, player2);

            MenuListener menu = new MenuListener(game);

            StackPane stem = new StackPane();
            stage.setResizable(true);
            View canvas = new View(WIDTH, HEIGHT,game, player1, player2);
            Scene scene = new Scene(stem, WIDTH, HEIGHT);

            KeyboardListener keyboardListener = new KeyboardListener(game,canvas);

            canvas.setOnKeyPressed(keyboardListener);
            canvas.setOnKeyTyped(keyboardListener);
            canvas.setFocusTraversable(true);

//            StackPane root = new StackPane();
            stem.getChildren().add(canvas);
            stem.getChildren().add(options);
            stem.setAlignment(options, Pos.BOTTOM_CENTER);

//            BallManager ballManager = new BallManager(game,canvas);
            PongController control = new PongController(game,canvas);
            Thread ballThread = new Thread(control);
            ballThread.start();

            ballThread.yield();

            about.setOnAction(e-> menu.setAbout());
            exitBtn.setOnAction(e -> menu.setExit());
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