package pong.controller;

import pong.model.Game;

import java.io.*;
/**
 * Serializes entire Game object to a file, data.obj
 */
public class Serializer {
    public static void saveSingletonInstance() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            System.out.println(Game.getInstance().getP1Name());
            out.writeObject(Game.getInstance());
            System.out.println("Game object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes object from data.obj, cast it to Game, and load it as the current game instance
     */
    public static void loadSingletonInstance() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"))) {
             Game.loadGame(((Game) in.readObject()));
            System.out.println("Game object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        }

