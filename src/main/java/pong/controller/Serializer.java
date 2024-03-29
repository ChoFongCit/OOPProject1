package pong.controller;

import pong.model.Game;

import java.io.*;
/**
 * Attempts to call all serialization methods in the project
 */
public class Serializer {

    public static void saveGame(Game game,File filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(game);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            public static Game loadGame(File filename) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                    return (Game) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

