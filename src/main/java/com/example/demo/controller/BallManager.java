package com.example.demo.controller;

import com.example.demo.model.Ball;
import com.example.demo.model.Game;
import com.example.demo.view.View;

public class BallManager implements Runnable {
    private Game game;
    private View view;
    private boolean isPaused;

    public BallManager(Game game, View view){
        this.game = game;
        this.view = view;
    }
    public void setPausedPaused(boolean toggle){
        isPaused = toggle;
    }
    @Override
    public void run() {
    Ball ball = game.getBall();
    int counter = 0 ;

    while(true)
    {
        if(isPaused){
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){

            }
        }

        try{
            Thread.sleep(10);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
    }
        view.updateDetails();
        view.updateView();
    }
    }
}
