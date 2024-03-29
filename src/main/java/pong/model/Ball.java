package pong.model;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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

import java.io.Serializable;
/**
 * This class represents a model of the Ball object
 */
public class Ball implements Serializable {

    /**
     * (x,y) represents the coordinates of the ball
     * (dx,dy) represents the rate of change of the coordinates
     * (baseDx, baseDy) represents the base rate of change before any multipliers
     */
    private double x, y, dx, dy, radius, baseDx,baseDy;
    /**
     * represents the number of bounces the ball bounces on any racket before speeding up
     */
    private int bounce = 2;
    /**
     * used to count the number of bounces
     */
    private int bounceCount = 0;

    /**
     * Constructs an ball object
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param dx rate of change of x-coordinate
     * @param dy rate of change of y-coordinate
     * @param radius radius of ball
     * @return an instance of ball object
     */
    public Ball(double x, double y, double radius, double dx, double dy){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        baseDx = dx;
        baseDy = dy;
    }
    /**
     * Sets radius of the ball
     *
     * @param radius the radius of ball

     */
    public void setRadius(double radius){
        this.radius = radius;
    }
    /**
     * draws itself in view
     *
     * @param gc GraphicsContext

     */
    public void draw(GraphicsContext gc){
        gc.setFill(Color.INDIGO);
        gc.fillOval(x,y,radius, radius);
    }
    /**
     * updates ball position according to its dx and dy values
     *
     * @param windowWidth
     * @param windowHeight
     */
    public void ballUpdate(double windowWidth, double windowHeight){
        this.x += dx;
        this.y += dy;
        if (y-radius < 0 || y+radius > windowHeight) dy *= -1;
    }
    /**
     * Sets dx value
     *
     * @param dx the radius of ball
     */
    public void setDx(double dx){
        this.dx = dx;
    }

    /**
     * Sets x-coordinate
     *
     * @param x the x-coordinate of ball
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Sets y-coordinate
     *
     * @param y the y-coordinate of ball

     */
    public void setY(double y){
        this.y = y;
    }
    public double getX(){return this.x;}

    public double getY() {
        return y;
    }

    /**
     * Sets bounce value of ball
     *
     * @param bounce the bounce value of ball

     */
    public void setBounce(int bounce) {
        this.bounce = bounce;
    }
    /**
     * resets dx and dy to baseDx and baseDy
     *
     */
    public void resetSpd(){
        dx = baseDx;
        dy = baseDy;
    }
    /**
     * sets dx and dy to spd
     *
     * @param spd the x-coordinate of ball

     */
    public void resetSpd(double spd){
        dx  = spd;
        dy = spd;
        baseDx = spd;
        baseDy = spd;
    }

    public void setDy(double dy) {this.dy = dy;}
    /**
     * gets dx value from ball
     * @return dx

     */
    public double getDx() {
        return dx;
    }
    /**
     * checks collision of ball with Player 1
     * reverses dx direction if collision
     *
     * @param player1X the x-coordinate of player1
     * @param player1H the Height of player1
     * @param player1W the Width of player1
     * @param player1Y the y-coordinate of player1

     */
    public void checkRacketCollisionP1(double player1X, double player1Y, double player1W, double player1H){
        if((x-(radius/2)) <=  player1X +player1W && ((y<=(player1Y+(player1H)))&& (y>=(player1Y)))){
            this.dx *= -1;
            increaseSpd();
        }
    }/**
     * checks collision of ball with Player 2
     * reverses dx direction if collision
     *
     * @param player2X the x-coordinate of player2
     * @param player2H the Height of player2
     * @param player2W the Width of player2
     * @param player2Y the y-coordinate of player2

     */
    public void checkRacketCollisionP2(double player2X, double player2Y, double player2W, double player2H){
        if((x+(radius/2)) >=  player2X - player2W && ((y<=(player2Y+(player2H)))&& (y>=(player2Y)))){
            this.dx *= -1;
            increaseSpd();
        }
    }
    /**
     * Multiplies ball spd by 1.25 each bounce times
     */
    public void increaseSpd(){
        if(bounceCount >= bounce){
            dx *= 1.25;
            dy *=1.25;
            bounceCount=0;
        }
        else{
            bounceCount++;
        }
    }
    /**
     * check if P1 scores
     *
     * @param player2X coordinates of player2
     * @param player2W width of player 2
     * @return true if goal
     */
    public boolean checkP1Goal(double player2X, double player2W){
        return(this.x >= player2X + player2W);
    }
    /**
     * check if P2 scores
     *
     * @param player1X coordinates of player1
     * @param player1W width of player 1
     * @return true if goal
     */
    public boolean checkP2Goal(double player1X, double player1W){
        return(this.x<= player1X-player1W);
    }
    /**
     * resets ball position to center of window
     *
     * @param windowWidth width  of window
     * @param windowHeight height of window

     */
    public void resetPos(double windowWidth, double windowHeight){
        this.x = windowWidth/2;
        this.y = windowHeight/2;
    }
}
