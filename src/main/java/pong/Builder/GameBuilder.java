package pong.Builder;

import pong.model.Game;
import pong.model.Player;

public class GameBuilder {
    private String player1Name;
    private String player2Name;
    private int p1Score;
    private int p2Score;
    private int target;

    public Game build(){
        Game game = new Game();
        game.setP1Name(player1Name);
        game.setP2Name(player2Name);
        game.setP1Score(p1Score);
        game.setP2Score(p2Score);
        game.setScorelimit(target);
        return game;
    }
    public GameBuilder withPlayer1Name(String player1Name){
        this.player1Name = player1Name;
        return this;
    }
    public GameBuilder withPlayer2Name(String player2Name){
        this.player2Name = player2Name;
        return this;
    }
    public GameBuilder withPlayer1Score(int score){
        this.p1Score = score;
        return this;
    }
    public GameBuilder withPlayer2Score(int score){
        this.p2Score = score;
        return this;
    }
    public GameBuilder withTarget(int i){
        this.target = i;
        return this;
    }
}
