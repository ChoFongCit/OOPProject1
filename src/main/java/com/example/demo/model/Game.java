package com.example.demo.model;

import com.example.demo.controller.BallManager;

public class Game {
    private int p1Score;
    private int p2Score;
    private Ball ball;
    private double windowWidth;
    private double windowHeight;
    private String p1Name;
    private String p2Name;
    private Player player1;
    private Player player2;
    public Game(Ball ball, Player player1, Player player2){
        p1Score = 0;
        p2Score =0;
        p1Name = "Player 1";
        p2Name = "Player 2";
        this.ball = ball;
        this.player1 = player1;
        this.player2 =player2;

    }

    public void setP1Name(String p1Name) {
        this.p1Name = p1Name;
    }

    public void setP2Name(String p2Name) {
        this.p2Name = p2Name;
    }

    public Ball getBall() {
        return ball;
    }

    public String getP1Name() {
        return p1Name;
    }

    public String getP2Name() {return p2Name;}

    public int getP1Score() {
        return p1Score;
    }
    public int getP2Score(){
        return p2Score;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void updateBallGame(double windowWidth, double windowHeight) {
        ball.ballUpdate(windowWidth, windowHeight);
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        ball.checkRacketCollisionP1(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight());
        ball.checkRacketCollisionP2(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());
    }
    public int checkGoal(){
        int side = 0;
        if(ball.checkP1Goal(player2.getX(), player2.getWidth())){
            p1Score++;
            ball.setX(windowWidth/2);
            ball.setY(windowHeight/2);
            ball.setDx(-1);
            System.out.println("player1goal");
            side = 1;
        }
        else if(ball.checkP2Goal(player1.getX(),player1.getWidth())){
            p2Score++;
            ball.setX(windowWidth/2);
            ball.setY(windowHeight/2);
            ball.setDx(1);
            System.out.println("player2goals");
            side = 2;
        }
        return side;
    }
}
