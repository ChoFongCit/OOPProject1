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

    /**
     * Contructs a new keyboardListner instance
     * @param view1
     * @param menuListener
     */
    public KeyboardListener(View view1, MenuListener menuListener){
        this.view = view1;
        pause = false;
        this.menuListener = menuListener;
    }

    /**
     * Handles key inputs, P for toggle pausing, WD and Arrow keys(UP, DOWN) for player movement
     * @param keyEvent
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key = keyEvent.getCode();
        if(KeyCode.P.equals(key)){
            togglePause();
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
    public void togglePause(){
        this.pause = !this.pause;
    }
}
