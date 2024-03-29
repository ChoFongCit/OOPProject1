package pong.view;

import pong.model.Ball;
import pong.model.Game;
import pong.model.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View extends Canvas {
    private static double Width ;
    private Player player1, player2;
    private Ball ball;
    private Game game;
    private static Font comic = new Font("Comic Sans", 30);
    private GraphicsContext gc;
    private static double HEIGHT ;
    public View(double width, double height, Game game, Player player1, Player player2) {
        super(width,height-20);
        gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        this.game = game;
        this.player1 = game.getPlayer1();
        this.player2 = game.getPlayer2();
        ball = game.getBall();
        this.drawScore(gc);
        drawNames(gc);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);
    }
    public void drawNames(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(game.getP1Name()+"\t\t"+game.getP2Name(), getWidth()/2 -100,getHeight()/2);
    }
    public void drawPlayer1(){

    }
    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(game.getP1Score()+"\t\t"+game.getP2Score(),getWidth()/2 -100,80);
    }
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,getWidth(),getHeight());
    }
    public void drawScoreLimit(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText("Score limit: "+ game.getScorelimit(), 0,30);
    }

    public void updateView(){
        player1.setUpdate(30, player1.getY());
        player2.setUpdate(getWidth()- 50, player2.getY());
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawBackground(gc);
        drawScoreLimit(gc);
        drawScore(gc);
        drawNames(gc);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);
        drawSpd();
    }
    public void ScoreMessage(String name){
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(name +" Scored",getWidth()/2 -40 ,getHeight()/2 - 50);
    }
    public void winMessage(String name){
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(name + "Wins", getWidth()/2 -40 , getHeight()/2 + 50);
    }
    public void drawSpd(){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText("BallSpd: "+Math.abs(ball.getDx()), 0, getHeight()-30);
    }
}
