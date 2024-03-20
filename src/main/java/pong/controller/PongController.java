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
//        startLoop(scene);
    }

    public Game getGame() {
        return game;
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
                    view.ScoreMessage(scoreMessage);
                    Thread.sleep(3000);     //stops for 3 seconds
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
//            if(game.checkGoal() == 1){
//                setPausedPaused(true);
//                scoreMessage = game.getP1Name();
//            }
//             if(game.checkGoal() == 2){
//                setPausedPaused(true);
//                scoreMessage = game.getP2Name();
//            }
             switch (game.checkGoal()){
                 case 1:
                     setPausedPaused(true);
                     scoreMessage = game.getP1Name();
                     break;
                 case 2:
                     setPausedPaused(true);
                     scoreMessage = game.getP2Name();
                     break;
             }

            view.updateDetails();
            view.updateView();
        }
    }
}
