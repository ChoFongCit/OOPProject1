package pong.controller;

import javafx.animation.AnimationTimer;
import pong.model.Game;
import pong.view.View;

/**
 * This class controls the game loop and condition checks
 */
public class PongController extends AnimationTimer {
    private View view;
    private volatile boolean isPaused = false;
    private String scoreMessage;

    /**
     * Constructs an instance of the PongController class
     * @param view rendering class
     */
    public PongController(View view) {
        this.view = view;
    }

    /**
     * The running game loop which uses Animation Timer
     * @param now
     */
    @Override
    public void handle(long now) {
        if (!isPaused) {
            try {
                // Check for goals and if the player has won or not
                switch (Game.getInstance().checkGoal()) {
                    case 1:
                        scoreMessage = Game.getInstance().getP1Name();
                        if (!checkWin()) {
                            view.ScoreMessage(scoreMessage);
                        }
                        Thread.sleep(3000);
                        break;
                    case 2:
                        scoreMessage = Game.getInstance().getP2Name();
                        if (!checkWin()) {
                            view.ScoreMessage(scoreMessage);
                        }
                        Thread.sleep(3000);
                        break;
                }

                // Update game state and view
                Game.getInstance().updateBallGame(view.getWidth(), view.getHeight());
                view.updateView();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Pauses the game loop
     */
    public void setPaused() {
        isPaused = true;
    }

    /**
     * Checks if a player has won
     *
     * @return true when a player has won
     */
    public boolean checkWin() {
        switch (Game.getInstance().checkEndGame()) {
            case 1:
                view.winMessage(Game.getInstance().getP1Name());
                setPaused();
                return true;
            case 2:
                view.winMessage(Game.getInstance().getP2Name());
                setPaused();
                return true;
        }
        return false;
    }

    /**
     * Resumes the game loop
     */
    public void resume() {
        isPaused = false;
    }

    /**
     * Resets the game instance
     */
    public void reset() {
        setPaused();
        Game.getInstance().resetGame();
        view.updateView();
    }
}
