package pong.controller;

import pong.model.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {
    private Game game;

    public void saveGame(String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
