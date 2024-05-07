package pong;

import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import pong.controller.KeyboardListener;
import pong.controller.PongController;
import pong.controller.MenuListener;
import pong.model.Ball;
import pong.model.Game;
import pong.model.Player;
import pong.view.MenuList;
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
    private static double WIDTH = 800;  //Initial width of window
    private static double HEIGHT = 600; //Initial Height of window
    private static Game game;
    @Override
    public void start(Stage stage) throws IOException {
        try {
            View canvas = new View(WIDTH, HEIGHT);
            PongController control = new PongController(canvas);
            MenuListener menuListener = new MenuListener(control);
            MenuList options = new MenuList(menuListener);
            BorderPane stem = new BorderPane();
            stage.setResizable(true);
            Scene scene = new Scene(stem, WIDTH, HEIGHT);
            KeyboardListener keyboardListener = new KeyboardListener(canvas, menuListener);
            canvas.setOnKeyPressed(keyboardListener);
            canvas.setOnKeyTyped(keyboardListener);
            canvas.setFocusTraversable(true);

            stem.setCenter(canvas);
            stem.setTop(options);


            canvas.widthProperty().bind(stem.widthProperty());
            canvas.heightProperty().bind(stem.heightProperty());
            control.start();
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