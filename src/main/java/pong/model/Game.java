package pong.model;

import java.io.Serializable;

public class Game implements Serializable {
    private int p1Score;
    private int p2Score;
    private Ball ball;
    private double windowWidth;
    private double windowHeight;
    private String p1Name;
    private String p2Name;
    private Player player1;
    private Player player2;
    private int bounceIncrease;
    private int scorelimit = 3; //by default =3
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

    public int getScorelimit() {
        return scorelimit;
    }

    public void setScorelimit(int scorelimit) {
        this.scorelimit = scorelimit;
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

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
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
            ball.resetSpd();
            System.out.println("player1goal");
            side = 1;
        }
        else if(ball.checkP2Goal(player1.getX(),player1.getWidth())){
            p2Score++;
            ball.setX(windowWidth/2);
            ball.setY(windowHeight/2);
            ball.resetSpd();
            System.out.println("player2goals");
            side = 2;
        }
        return side;
    }
    public int checkEndGame(){
        int side = 0;
        if(p1Score>=scorelimit){
            System.out.println("player1Wins");
            side = 1;
        }
        else if(p2Score>=scorelimit){
            System.out.println("player2Wins");
            side = 2;
        }
        return side;
    }
    public void resetGame(){
        p1Score = 0;
        p2Score = 0;
        ball.resetPos(windowWidth,windowHeight);
        player1.resetPos((windowHeight/2)- player1.getHeight()/2);
        player2.resetPos((windowHeight/2)- player2.getHeight()/2);
    }
}
