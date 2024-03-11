package com.example.demo.controller;

import com.example.demo.model.Ball;
import com.example.demo.model.Game;
import com.example.demo.view.View;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

public class PongController{
    private Game game;
    private View view;
    private BallManager ballManager;
    public PongController(Game mygame, View view,BallManager ballManager){
        this.game = mygame;
        this.view = view;
        this.ballManager = ballManager;
//        startLoop(scene);
    }

    public Game getGame() {
        return game;
    }

}
