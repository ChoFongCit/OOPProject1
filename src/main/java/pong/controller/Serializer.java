package pong.controller;

import pong.model.Game;

import java.io.*;
/**
 * Attempts to call all serialization methods in the project
 */
public class Serializer {
    public static void saveSingletonInstance(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            System.out.println(Game.getInstance().getP1Name());
            out.writeObject(Game.getInstance());
            System.out.println("Game object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSingletonInstance(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"))) {
             Game.loadGame(((Game) in.readObject()));
            System.out.println("Game object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        }

