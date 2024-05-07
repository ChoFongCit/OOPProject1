package pong.model;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
/**
 * This class represents a player and its racket
 */
public class Player implements Serializable {
    /**
     * represents the coordinates and properties of player
     */
    private double x,y,width, height, movement;

    /**
     * constructs a player instance
     *
     * @param x,y coordinates of player
     * @param width,height width and height of player
     * @param dy rate of movement of player
     * @return an instance of player
     */
    public Player(double x, double y, double width, double height, double dy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.movement = dy;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }
    /**
     * updates player coordinates
     *
     * @param x,y new coordinates of player
     */
    public void setUpdate(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * moves racket up by movement
     */
    public void upMove(){
        this.y += -movement;
    }
    /**
     * moves racket down by movement
     */
    public void downMove(){
        this.y += movement;
    }
    /**
     * resets coordinates to start of game
     */
    public void resetPos(double y){
        this.y = y;
    }
}
