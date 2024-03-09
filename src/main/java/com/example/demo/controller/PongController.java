package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.view.View;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

public class PongController {
    private Game game;
    private View view;
    public PongController(Game mygame, View view,Scene scene){
        this.game = mygame;
        this.view = view;
        startLoop(scene);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    private void startLoop(Scene scene){
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
//    private void initControls(Scene scene){
//            scene.setOnKeyPressed(e -> {
//                switch (e.getCode()) {
//                    case UP: game.getPlayer2().upMove(); break;
//                    case DOWN: game.getPlayer2().downMove(); break;
//                    case W: game.getPlayer1().upMove();  break;
//                    case S: game.getPlayer1().downMove();  break;
//                }
//            });
//
//    }
}
