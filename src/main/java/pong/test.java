package pong;

import pong.controller.DatabaseManager;

import java.sql.SQLException;

import static javafx.application.Application.launch;

public class test {
    public static void main(String[] args){
        DatabaseManager dbManage = new DatabaseManager();
        try{
            System.out.println(dbManage.getGame("Australian Open"));

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        launch();
    }
}

