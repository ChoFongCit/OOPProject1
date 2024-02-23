package com.example.demo;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabCanvas extends Canvas {
    private static double WIDTH = 800;
    private Player player1, player2;
    private Ball ball;
    private Game game;
    private static Font comic = new Font("Comic Sans", 30);
    private static double HEIGHT = 600;
    public LabCanvas(Game inGame) {
        super(WIDTH,HEIGHT-20);
        GraphicsContext gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 5);
        player2 = new Player(WIDTH - 50, HEIGHT / 2 - 40, 20, 80, 5);
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, 30, 5, 5);
        this.drawScore(gc);
        drawNames(gc);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);
        game = inGame;
    }
    public void drawBall(GraphicsContext gc)
    {
        gc.setFill(Color.BLUE);
        gc.fillOval(WIDTH/2,HEIGHT/2,30,30);
    }
    public void drawRacket(GraphicsContext gc )
    {
        gc.setFill(Color.YELLOW);
        gc.fillRect(WIDTH-50, HEIGHT/2, 30,100);
    }
    public void drawNames(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText("Joe"+"\t\t"+"Joe", WIDTH/2 -100,HEIGHT/2);

    }
    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(player1.getScore()+"\t\t"+player2.getScore(),WIDTH/2 -50,50);
    }
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,WIDTH,HEIGHT);
    }
    public void setSize(int width, int height){
        WIDTH = width;
        HEIGHT = height;
    }
}
