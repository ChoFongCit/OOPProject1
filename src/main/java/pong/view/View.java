package pong.view;

import pong.model.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View extends Canvas {
    /**
     * Font to be used
     */
    private static Font comic = new Font("Comic Sans", 30);
    private GraphicsContext gc;
    /**
     * Constructs an instance of the View class
     * draws all models
     * @param width width of the class
     * @param height height of the class
     */
    public View(double width, double height) {
        super(width,height-20);
        gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        this.drawScore(gc);
        drawNames(gc);
        drawBall(gc);
        drawPlayer1(gc);
        drawPlayer2(gc);
    }
    /**
     * draws the names of the players
     */
    public void drawNames(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(Game.getInstance().getP1Name()+"\t\t"+Game.getInstance().getP2Name(), getWidth()/2 -100,getHeight()/2);
    }
    /**
     * draws the scores of the players
     */
    public void drawScore(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(Game.getInstance().getP1Score()+"\t\t"+Game.getInstance().getP2Score(),getWidth()/2 -100,80);
    }

    /**
     * Draws ball object
     * @param gc
     */
    public void drawBall(GraphicsContext gc){
        gc.setFill(Color.INDIGO);
        gc.fillOval(Game.getInstance().getBall().getX(), Game.getInstance().getBall().getY(), Game.getInstance().getBall().getRadius(), Game.getInstance().getBall().getRadius());
    }

    /**
     * Draws player1 racket
     * @param gc
     */
    public void drawPlayer1(GraphicsContext gc){
        gc.setFill(Color.YELLOWGREEN);
        gc.fillRect(Game.getInstance().getPlayer1().getX(), Game.getInstance().getPlayer1().getY(),Game.getInstance().getPlayer1().getWidth(),Game.getInstance().getPlayer1().getHeight());
    }

    /**
     * draws player 2 racket
     * @param gc
     */
    public void drawPlayer2(GraphicsContext gc){
        gc.setFill(Color.YELLOWGREEN);
        gc.fillRect(Game.getInstance().getPlayer2().getX(), Game.getInstance().getPlayer2().getY(),Game.getInstance().getPlayer2().getWidth(),Game.getInstance().getPlayer2().getHeight());
    }
    /**
     * draws the background of the canvas
     */
    public void drawBackground(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,getWidth(),getHeight());
    }
    /**
     * draws the score limit of the game
     */
    public void drawScoreLimit(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText("Score limit: "+ Game.getInstance().getScorelimit(), 0,30);
    }

    /**
     * draws all models with the newest attributes
     */
    public void updateView(){
        Game.getInstance().getPlayer1().setUpdate(30, Game.getInstance().getPlayer1().getY());
        Game.getInstance().getPlayer2().setUpdate(getWidth()- 50, Game.getInstance().getPlayer2().getY());
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawBackground(gc);
        drawScoreLimit(gc);
        drawScore(gc);
        drawNames(gc);
        drawBall(gc);
        drawPlayer1(gc);
        drawPlayer2(gc);
        drawSpd();
    }
    /**
     * draws the scores of the players
     */
    public void ScoreMessage(String name){
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(name +" Scored",getWidth()/2 -40 ,getHeight()/2 - 50);
    }
    /**
     * draws a win message when the game ends
     */
    public void winMessage(String name){
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText(name + "Wins", getWidth()/2 -40 , getHeight()/2 + 50);
    }
    /**
     * draws the real-time spd of the ball
     */
    public void drawSpd(){
        gc.setFill(Color.WHITE);
        gc.setFont(comic);
        gc.fillText("BallSpd: "+Math.abs(Game.getInstance().getBall().getDx()), 0, getHeight()-30);
    }
}
