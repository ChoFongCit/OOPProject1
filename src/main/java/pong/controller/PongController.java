package pong.controller;

import pong.model.Game;
import pong.view.View;

public class PongController implements Runnable{
    private Game game;
    private View view;
    private boolean isPaused = true;
    private String scoreMessage;
    public PongController(Game game, View view){
        this.game = game;
        this.view = view;
    }
    public void setPaused(boolean toggle){
        isPaused = toggle;
    }
    @Override
    public void run() {
//    int counter = 0 ;
        while(true)
        {
            if(isPaused){
                try{

                    Thread.sleep(1);     //stops for 3 seconds

                }catch (InterruptedException e){
                }
            }
            try{
                Thread.sleep(10);
                switch (game.checkGoal()){
                    case 1:

                        scoreMessage = game.getP1Name();
                        view.ScoreMessage(scoreMessage);
                        Thread.sleep(3000);
                        break;
                    case 2:
                        scoreMessage = game.getP2Name();
                        view.ScoreMessage(scoreMessage);
                        Thread.sleep(3000);
                        break;
                }
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }

            game.updateBallGame(view.getWidth(),view.getHeight());
            view.updateView();
        }
    }
}
