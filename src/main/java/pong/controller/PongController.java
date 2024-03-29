package pong.controller;

import pong.model.Game;
import pong.view.View;

public class PongController implements Runnable {
    private Game game;
    private View view;
    private volatile boolean isPaused = false;
    private volatile boolean running = true;
    private final Object pauseLock = new Object();
    private String scoreMessage;

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
    public void setPaused() {
        synchronized (pauseLock){
           isPaused = true;
        }
    }
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
    public void reset(){
        game.resetGame();
        view.updateView();
    }

    }

