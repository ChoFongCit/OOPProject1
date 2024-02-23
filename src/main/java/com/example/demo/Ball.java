package com.example.demo;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
public class Ball {
    private Circle ball;
    private double x, y, dx, dy, width, height;
    public Ball(double x, double y, double width, double height, double dx, double dy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = dx;
        this.dy = dy;
    }
    public void setSize(int change){
        width +=change;
        height +=change;
    }
    public void draw(GraphicsContext gc){
        gc.setFill(Color.INDIGO);
        gc.fillOval(x,y,width,height);
    }
    public void setUpdate(double x, double y){
        this.x = x;
        this.y = y;
    }
}
