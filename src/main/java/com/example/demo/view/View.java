package com.example.demo.view;

import com.example.demo.model.Ball;
import com.example.demo.model.Game;
import com.example.demo.model.Player;
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
    private static double HEIGHT ;
    public View(double width, double height, Game game, Player player1, Player player2) {
        super(width,height-20);
        GraphicsContext gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        ball = game.getBall();
        this.drawScore(gc);
        drawNames(gc);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);
    }
    public void drawBall(GraphicsContext gc)
    {
        gc.setFill(Color.BLUE);
        gc.fillOval(getWidth()/2,getHeight()/2,30,30);
    }
    public void drawRacket(GraphicsContext gc )
    {
        gc.setFill(Color.YELLOW);
        gc.fillRect(getWidth()-50, getHeight()/2, 30,100);
    }
    public void drawNames(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(game.getP1Name()+"\t\t"+game.getP2Name(), getWidth()/2 -100,getHeight()/2);

    }
    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(game.getP1Score()+"\t\t"+game.getP2Score(),getWidth()/2 -100,50);
    }
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,getWidth(),getHeight());
    }
    public void updateDetails(){
//        setWidth(this.getWidth());
//        setHeight(height);

//        ball.ballUpdate(this.getWidth(), this.getHeight());
        player1.setUpdate(30, player1.getY());
        player2.setUpdate(getWidth()- 50, player2.getY());
        game.updateBallGame(getWidth(),getHeight());
    }
    public void updateView(){
        GraphicsContext gc =this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawBackground(gc);
        drawScore(gc);
        drawNames(gc);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);
    }
}
