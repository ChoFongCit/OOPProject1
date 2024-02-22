package com.example.demo;
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
public class Player {
    private double x,y,width, height, movement;
    public Player(double x, double y, double width, double height, double dy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.movement = dy;
    }
    public void draw(GraphicsContext gc){
        gc.setFill(Color.YELLOWGREEN);
        gc.fillRect(x,y,width,height);
    }


}
