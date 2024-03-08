package com.example.demo.controller;

import com.example.demo.model.Game;
import javafx.animation.AnimationTimer;

public class PongController {
    private Game game;
    private com.example.demo.view.view view;
    public PongController(Game mygame, com.example.demo.view.view view){
        this.game = mygame;
        this.view = view;
        startLoop();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    private void startLoop(){
        AnimationTimer gameloop = new AnimationTimer(){
            @Override
            public void handle(long l) {
                // Game logic
//                updateGame();
                // Render
                //game.updateBallGame(WIDTH,HEIGHT);
                view.updateDetails();
                view.updateView();
            }
        };
        gameloop.start();
    }
    private void initControls(){

    }
}
