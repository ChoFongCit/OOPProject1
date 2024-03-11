package com.example.demo.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import com.example.demo.model.*;
import com.example.demo.view.*;

public class KeyboardListener implements EventHandler<KeyEvent> {
    private Game game;
    private View view;

    public KeyboardListener(Game game1, View view1){
        this.game = game1;
        this.view = view1;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key = keyEvent.getCode();
        if(KeyCode.UP.equals(key)){
            game.getPlayer2().upMove();
        }
        if(KeyCode.DOWN.equals(key)){
            game.getPlayer2().downMove();
        }
        if(KeyCode.W.equals(key)){
            game.getPlayer1().upMove();
        }
        if(KeyCode.S.equals(key)){
            game.getPlayer1().downMove();
        }
    }
}
