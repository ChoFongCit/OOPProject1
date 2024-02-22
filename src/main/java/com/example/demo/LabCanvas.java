package com.example.demo;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class LabCanvas extends Canvas {
    public LabCanvas() {
        super(600,640);;
        GraphicsContext gc = this.getGraphicsContext2D();
        drawBall(gc);
        drawRacket(gc);
        drawBackground(gc);
    }
    public void drawBall(GraphicsContext gc)
    {
        gc.setFill(Color.YELLOWGREEN);
        gc.fillOval(100,100,30,30);
    }
    public void drawRacket(GraphicsContext gc )
    {
        gc.setFill(Color.YELLOW);
        gc.fillRect(10, 200, 30,100);
    }
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
    }
}
