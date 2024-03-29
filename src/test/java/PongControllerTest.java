import org.junit.Before;
import org.junit.Test;
import pong.controller.PongController;
import pong.model.Ball;
import pong.model.Game;
import pong.model.Player;
import pong.view.View;

import static org.junit.jupiter.api.Assertions.*;

public class PongControllerTest {
    public double WIDTH = 800;
    public double HEIGHT = 600;
    Ball ball = new Ball(WIDTH / 2, HEIGHT / 2, 30, -1, 1);
    Player player1 = new Player(30,HEIGHT / 2 - 40, 20, 80, 10);
    Player player2 = new Player(WIDTH - 50, HEIGHT/ 2 - 40, 20, 80, 10);
    Game game = new Game(ball, player1, player2);
    View canvas = new View(WIDTH, HEIGHT,game, player1, player2);
    PongController controller = new PongController(game,canvas);

    @Before
    public void initialise(){
        game.setScorelimit(10);
    }
    @Test
    public void testEndofGame(){
        game.setP2Score(7);
        game.setP1Score(11);
        //Score is up 11-7
        assertTrue(game.checkEndGame()==1);
        game.setP1Score(7);
        //Score is 7-7
        assertFalse(game.checkEndGame()==1);
    }
    @Test
    public void testCollision(){
        game.getBall().setX(1);
        assertTrue(game.checkGoal()==2);
        game.getBall().setX(100);
        assertFalse(game.checkGoal()==2);
    }
}
