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
        alert.setContentText("Controls:\n P1 up:W down: S\nP2 up: UpArrow down: DownArrow");
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
    public void setBallBounce(){
        pongController.setPaused();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set ball bounce");
        dialog.setHeaderText("Enter New bounce Limit:");
        dialog.setContentText("bounce limit:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try {
                // Safely parse the integer and set the score limit.
                int bounceLimit = Integer.parseInt(string);
                game.getBall().setBounce(bounceLimit);
            } catch (NumberFormatException e) {
                // Handle invalid input (not an integer)
                // Optionally show an error message to the user
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not valid integer");
                alert.setContentText("please enter valid integer");
                alert.showAndWait().ifPresent((btnType) -> {
                });
                setBallBounce();
            }
            pongController.resume();
        });
    }
    public void setBallspd(){
        pongController.setPaused();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set ball base Spd");
        dialog.setHeaderText("Enter New Spd:");
        dialog.setContentText("Speed:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try {
                // Safely parse the double and set the spd limit
                double spd = Double.parseDouble(string);
                game.getBall().resetSpd(spd);
            } catch (NumberFormatException e) {
                // Handle invalid input (not an integer)
                // Optionally show an error message to the user
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not valid integer");
                alert.setContentText("please enter valid double");
                alert.showAndWait().ifPresent((btnType) -> {
                });
                setBallspd();
            }
            pongController.resume();
        });
    }
    public void setp1Name(){
        pongController.setPaused();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set P1 Name");
        dialog.setHeaderText("Enter new p1 name");
        dialog.setContentText("new name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try {
                // Safely parse the integer and set the score limit.
                game.setP1Name(string);
            } catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not valid string");
                alert.showAndWait().ifPresent((btnType) -> {
                });
                setp1Name();
            }
            pongController.resume();
        });
    }
    public void setp2Name(){
        pongController.setPaused();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Set P2 Name");
        dialog.setHeaderText("Enter new p2 name");
        dialog.setContentText("new name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(string -> {
            try {
                // Safely parse the integer and set the score limit.
                game.setP2Name(string);
            } catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Not valid string");
                alert.showAndWait().ifPresent((btnType) -> {
                });
                setp2Name();
            }
            pongController.resume();
        });
    }
}
