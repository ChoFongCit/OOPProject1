package pong.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pong.model.Game;
import pong.view.View;

public class KeyboardListener implements EventHandler<KeyEvent> {
    private View view;
    private boolean pause;
    private MenuListener menuListener;

    public KeyboardListener(View view1, MenuListener menuListener){

        this.view = view1;
        pause = false;
        this.menuListener = menuListener;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key = keyEvent.getCode();
        if(KeyCode.P.equals(key)){
            pause = !pause;
            if(pause){
                menuListener.pauseGame();
            }
            else{
                menuListener.resumeGame();
            }
        }
        if(!pause) {
            if (KeyCode.UP.equals(key)) {
                Game.getInstance().getPlayer2().upMove();
            }
            if (KeyCode.DOWN.equals(key)) {
                Game.getInstance().getPlayer2().downMove();
            }
            if (KeyCode.W.equals(key)) {
                Game.getInstance().getPlayer1().upMove();
            }
            if (KeyCode.S.equals(key)) {
                Game.getInstance().getPlayer1().downMove();
            }
            view.updateView();
        }
    }
}
