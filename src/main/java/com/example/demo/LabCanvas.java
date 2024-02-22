package com.example.demo;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class LabCanvas extends Canvas {
    private static final int WIDTH = 800;
    private Player player1, player2;
    private Ball ball;
    private static final int HEIGHT = 600;
    public LabCanvas() {
        super(WIDTH,HEIGHT);
        GraphicsContext gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 5);
        player2 = new Player(WIDTH - 50, HEIGHT / 2 - 40, 20, 80, 5);
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, 30, 5, 5);
        ball.draw(gc);
        player1.draw(gc);
        player2.draw(gc);

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
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,WIDTH,HEIGHT);
    }
}
