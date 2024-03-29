package pong.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import pong.model.Game;

import java.util.Optional;

public class MenuListener {
    private Game game;
    private PongController pongController;

    public MenuListener(Game game, PongController controller){
        this.game = game;
        pongController = controller;
    }

    public void setExit() {
        System.out.println("Exit");
        System.exit(0);
    }

    public void setAbout() {
        pongController.setPaused();
        System.out.println("ABOUT");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Super Ping pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights resereved");
        alert.showAndWait().ifPresent((btnType) -> {
        });

        pongController.resume();
    }

    public void setGameLimit() {
        pongController.setPaused();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set Score Limit");
        dialog.setHeaderText("Enter New Score Limit:");
        dialog.setContentText("Score limit:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try {
                // Safely parse the integer and set the score limit.
                int scoreLimit = Integer.parseInt(string);
                game.setScorelimit(scoreLimit);
            } catch (NumberFormatException e) {
                // Handle invalid input (not an integer)
                // Optionally show an error message to the user
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not valid integer");
                alert.setContentText("please enter valid integer");
                alert.showAndWait().ifPresent((btnType) -> {
                        });
                setGameLimit();
            }
            pongController.resume();
        });
    }
    public void pauseGame(){
        pongController.setPaused();
    }
    public void resumeGame(){
        pongController.resume();
    }
    public void resetGame(){
        pongController.reset();
    }
}
