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
    public void ballUpdate(double windowWidth, double windowHeight){
        this.x += dx;
        this.y += dy;
        if (x < 0 || x > windowWidth) dx *= -1;
        if (y < 0 || y > windowHeight) dy *= -1;
    }
    public void setDx(double dx){
        this.dx = dx;
    }

    public void setDy(double dy) {this.dy = dy;}
    public void checkRacketCollisionP1(double player1X, double player1Y, double player1W, double player1H){
        if(x <=  player1X +player1W && ((y<=(player1Y+(player1H)))&& (y>=(player1Y)))){
            this.dx *= -1;
        }
    }
    public void checkRacketCollisionP2(double player2X, double player2Y, double player2W, double player2H){
        if(x >=  player2X - player2W && ((y<=(player2Y+(player2H)))&& (y>=(player2Y)))){
            this.dx *= -1;
        }
    }
}
