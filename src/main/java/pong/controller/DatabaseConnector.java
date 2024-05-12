package pong.controller;
import javafx.scene.control.Alert;

import java.nio.channels.ClosedSelectorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection conn =  null;
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn == null || conn.isClosed()){
            createConnection();
        }
        return conn;
    }
    private static void createConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/assignment";
        String username = "root";
        String password = "root";
        conn =DriverManager.getConnection(url, username, password);
    }

}
