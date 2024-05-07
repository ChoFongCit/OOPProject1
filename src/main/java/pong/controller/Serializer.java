package pong.controller;

import pong.model.Game;

import java.io.*;
/**
 * Attempts to call all serialization methods in the project
 */
public class Serializer {
    public static synchronized void saveGame(Game game,String filename) {
        try  {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(game);
            out.flush();
            file.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }

