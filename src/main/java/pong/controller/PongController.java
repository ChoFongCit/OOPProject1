package pong.controller;

import pong.model.Game;
import pong.view.View;

import java.io.File;
/**
 * This class controls the game loop and condition checks
 */
public class PongController implements Runnable {
    private Game game;
    private View view;
    private volatile boolean isPaused = false;
    private volatile boolean running = true;
    /**
     * Object used to synchronize methods to thread
     */
    private final Object pauseLock = new Object();
    private String scoreMessage;
    /**
     * Consturcts an instance of the PongController class
     * @param game game model
     * @param view rendering class
     */
    public PongController(Game game, View view) {
        this.game = game;
        this.view = view;
    }
    public void run() {
        while (running) {
            synchronized (pauseLock) {
                if (!running) { // Handle the case where the game needs to stop
                    break;
                }
                if (isPaused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException ex) {
                        break;
                    }
                    if (!running) { // Check again if the game is still running after being notified
                        break;
                    }
                }
            }
            try {
                Thread.sleep(10);
                //checks goal and if the player has won or not
                switch (game.checkGoal()) {
                    case 1:
                        scoreMessage = game.getP1Name();
                        if(checkWin()){
                        }
                        else{
                        view.ScoreMessage(scoreMessage);
                    }
                        Thread.sleep(3000);

                        break;
                    case 2:
                        scoreMessage = game.getP2Name();
                        if(checkWin()){
                        }
                        else{
                            view.ScoreMessage(scoreMessage);
                        }
                        Thread.sleep(3000);

                        break;
                }


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            game.updateBallGame(view.getWidth(), view.getHeight());
            view.updateView();
        }
    }
    /**
     *pauses the game loop
     */
    public void setPaused() {
        synchronized (pauseLock){
           isPaused = true;
        }
    }
    /**
     * checks if a player has won
     * @return true when a player has won
     */
    public boolean checkWin(){
        switch(game.checkEndGame()){
            case 1:
                view.winMessage(game.getP1Name());
                setPaused();
                return true;
            case 2:
                view.winMessage(game.getP2Name());
                setPaused();
                return true;
        }
        return false;
    }
    /**
     * resumes the game loop
     */
    public void resume(){
        synchronized (pauseLock){
            isPaused = false;
            pauseLock.notifyAll();
        }
    }

    public void stop(){
        synchronized (pauseLock){
            running = false;
            resume();
        }
    }
    /**
     * resets the game instance
     */
    public void reset(){
        game.resetGame();
        view.updateView();
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

