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
public class Player {
    private int score;
    private Rectangle racket;
    private String name;
    public Player(String inName){
        score = 0;
        racket = new Rectangle(10,40);
        name = "Player " + inName;
    }

    public Rectangle getRacket() {
        return racket;
    }

    public int getScore() {
        return score;
    }
    public void setName(String inName){
        name = inName;
    }
    public String getName(){
        return name;
    }
}
