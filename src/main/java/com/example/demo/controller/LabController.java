package com.example.demo.controller;

import com.example.demo.view.LabCanvas;
import com.example.demo.model.Game;
import javafx.animation.AnimationTimer;

public class LabController {
    private Game game;
    private LabCanvas view;
    public LabController(Game mygame, LabCanvas view){
        this.game = mygame;
        this.view = view;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    public void startLoop(){
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
}
