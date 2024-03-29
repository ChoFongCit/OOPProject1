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
public class Ball {


    private double x, y, dx, dy, radius;
    public Ball(double x, double y, double radius, double dx, double dy){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
    }
    public void setSize(int change){
        radius+=change;
    }
    public void draw(GraphicsContext gc){
        gc.setFill(Color.INDIGO);
        gc.fillOval(x,y,radius, radius);
    }
    public void ballUpdate(double windowWidth, double windowHeight){
        this.x += dx;
        this.y += dy;
        if (y-radius < 0 || y+radius > windowHeight) dy *= -1;
    }
    public void setDx(double dx){
        this.dx = dx;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getX(){return this.x;}

    public double getY() {
        return y;
    }


    public void setDy(double dy) {this.dy = dy;}
    public void checkRacketCollisionP1(double player1X, double player1Y, double player1W, double player1H){
        if((x-(radius/2)) <=  player1X +player1W && ((y<=(player1Y+(player1H)))&& (y>=(player1Y)))){
            this.dx *= -1;
        }
    }
    public void checkRacketCollisionP2(double player2X, double player2Y, double player2W, double player2H){
        if((x+(radius/2)) >=  player2X - player2W && ((y<=(player2Y+(player2H)))&& (y>=(player2Y)))){
            this.dx *= -1;
        }
    }
    public boolean checkP1Goal(double player2X, double player2W){
        return(this.x >= player2X + player2W);
    }
    public boolean checkP2Goal(double player1X, double player1W){
        return(this.x<= player1X-player1W);
    }
    public void resetPos(double windowWidth, double windowHeight){
        this.x = windowWidth/2;
        this.y = windowHeight/2;
    }
}
