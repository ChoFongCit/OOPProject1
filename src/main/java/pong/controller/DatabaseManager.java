package pong.controller;

import pong.Builder.GameBuilder;
import pong.controller.DatabaseConnector;
import pong.model.Game;

import java.sql.*;

public class DatabaseManager {
    public static Game getGame(String name) throws ClassNotFoundException, SQLException{
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM game ORDER BY id DESC LIMIT 1";
        System.out.println(sql);

        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString("player1Name"));
            System.out.println(rs.getString("player2Name"));
                    GameBuilder builder = new GameBuilder().
                            withPlayer1Score(rs.getInt("player1Score")).
                            withPlayer1Name(rs.getString("player1Name")).
                            withPlayer2Name(rs.getString("player2Name")).
                            withPlayer2Score(rs.getInt("player2Score")).
                            withTarget(rs.getInt("target"));
                    Game game = builder.build();
                    Game.loadGame(builder.build());
                    return game;
        }
        return null;
    }
    public static void saveGame() throws SQLException, ClassNotFoundException {
        Game game = Game.getInstance();
        Connection connection = DatabaseConnector.getConnection();
        String sql = "INSERT INTO game (player1Name, player2Name, player1Score, player2Score, target, name) VALUES (?, ?, ?,?,?,?)";
        PreparedStatement ppstm = connection.prepareStatement(sql);
        ppstm.setString(1,game.getP1Name());
        ppstm.setString(2,game.getP2Name());
        ppstm.setInt(3,game.getP1Score());
        ppstm.setInt(4,game.getP2Score());
        ppstm.setInt(5,game.getScorelimit());
        ppstm.setString(6, game.getName());

        ppstm.executeUpdate();
        System.out.println("Data saved");
    }
}
