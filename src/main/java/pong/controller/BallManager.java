package pong.controller;

import pong.model.Game;
import pong.view.View;

public class BallManager implements Runnable {
    private Game game;
    private View view;
    private boolean isPaused = true;

    public BallManager(Game game, View view){
        this.game = game;
        this.view = view;
    }
//    public void setPausedPaused(boolean toggle, String message){
//        System.out.println(message);
//        isPaused = toggle;
//    }
    public void setPausedPaused(boolean toggle){
        isPaused = toggle;
    }
    @Override
    public void run() {
//    int counter = 0 ;
    while(true)
    {
        if(isPaused){
            try{

                Thread.sleep(3000);
                setPausedPaused(false);
            }catch (InterruptedException e){

            }
        }

        try{
            Thread.sleep(10);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
    }
        view.updateView();
    }
    }
}
