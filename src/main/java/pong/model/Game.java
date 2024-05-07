package pong.model;


import java.io.*;

/**
 * Game class represents the model of the game
 */
public class Game implements Serializable {
    private final long serialVersionUID = 1L;
    private static Game singleTon = new Game();
    private int p1Score;
    private int p2Score;
    private Ball ball;
    private double windowWidth;
    private double windowHeight;
    private double WIDTH = 800;  //Initial width of window
    private double HEIGHT = 600; //Initial Height of window
    private String p1Name;
    private String p2Name;
    private  Player player1;
    private  Player player2;
    private int scorelimit = 3; //by default =3
    private Game(){
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, -1, 1);
        player1 = new Player(30, HEIGHT / 2 - 40, 20, 80, 20);
        player2 = new Player(WIDTH - 50, HEIGHT/ 2 - 40, 20, 80, 20);
        p1Score = 0;
        p2Score =0;
        p1Name = "JOHN";
        p2Name = "PRICK";
    }
    private Game(Game game){
        this.singleTon = game;
    }
    public static synchronized Game getInstance(){
        return singleTon;
    }
//    public Object readResolve() throws ObjectStreamException {
//        // Ensure that the singleton instance is maintained after deserialization
//        return getInstance();
//    }

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

    /**
     * updates the game properties and checks collision of ball
     */
    public void updateBallGame(double windowWidth, double windowHeight) {
        ball.ballUpdate(windowWidth, windowHeight);
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        ball.checkRacketCollisionP1(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight());
        ball.checkRacketCollisionP2(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());
    }
    /**
     * checks if the ball has gone in a goal
     * @returns 1 if player 1 goal, 2 if player 2 goal
     */
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
    /**
     * checks if score has reached score limit
     * @returns 1 if player 1 reaches limit, 2 if player 2 reaches limit
     */
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
    /**
     * resets game properties and model positions
     */
    public void resetGame(){
        p1Score = 0;
        p2Score = 0;
        ball.resetPos(windowWidth,windowHeight);
        player1.resetPos((windowHeight/2)- player1.getHeight()/2);
        player2.resetPos((windowHeight/2)- player2.getHeight()/2);
    }
    public static void saveSingletonInstance(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            System.out.println(getInstance().getP1Name());
            out.writeObject(singleTon);
            System.out.println("Game object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSingletonInstance(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"))) {
            singleTon = ((Game) in.readObject());
            System.out.println("Game object deserialized successfully.");
            System.out.println(getInstance().getP1Name());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
