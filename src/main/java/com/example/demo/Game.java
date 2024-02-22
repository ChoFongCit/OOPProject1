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
public class Game {
    private int p1Score;
    private int p2Score;

    private String p1Name;
    private String p2Name;
    public Game(){
        p1Score = 0;
        p2Score =0;
        p1Name = "PLayer 1";
        p2Name = "Player 2";
    }
}
