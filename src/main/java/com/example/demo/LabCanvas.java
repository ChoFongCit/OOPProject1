package com.example.demo;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabCanvas extends Canvas {
    private static double Width ;
    private Player player1, player2;
    private Ball ball;
    private Game game;
    private static Font comic = new Font("Comic Sans", 30);
    private static double HEIGHT ;
    public LabCanvas(double width, double height) {
        super(width,height-20);
        GraphicsContext gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        player1 = new Player(30, height / 2 - 40, 20, 80, 5);
        player2 = new Player(width - 50, height/ 2 - 40, 20, 80, 5);
        ball = new Ball(width / 2, height / 2, 30, 30, 5, 5);
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
        gc.fillText("Joe"+"\t\t"+"Joe", getWidth()/2 -100,getHeight()/2);

    }
    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(player1.getScore()+"\t\t"+player2.getScore(),getWidth()/2 -100,50);
    }
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,getWidth(),getHeight());
    }
    public void setSize(){
//        setWidth(this.getWidth());
//        setHeight(height);
        ball.setUpdate(this.getWidth() / 2, this.getHeight() / 2);
        player1.setUpdate(30, getHeight() / 2 - 40);
        player2.setUpdate(getWidth()- 50, getHeight()/ 2 - 40);
    }
    public void update(){
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
