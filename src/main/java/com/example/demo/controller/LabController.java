package com.example.demo.controller;

import com.example.demo.Game;

public class LabController {
    private Game game;
    public LabController(Game mygame){
        this.game = mygame;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
