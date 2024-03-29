package pong.view;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import pong.controller.MenuListener;

public class MenuList extends MenuBar {
        Menu optionlist = new Menu("Options");
        Menu gameSettings = new Menu("Game settings");
        MenuItem about = new MenuItem("about");
        MenuItem pause = new Menu("pause");
        MenuItem resetGame = new MenuItem("resetGame");
        MenuItem resume = new Menu("resume");
        MenuItem exitBtn = new MenuItem("Exit");
        MenuItem setWinCondition = new MenuItem("WinCondition");
        MenuItem changeNames = new MenuItem("ChangeName");
        MenuItem ballSpeed = new MenuItem("BallSpd");
        MenuItem ballBounce = new MenuItem("Bounce");
        MenuItem player1Name = new MenuItem("Player1 Name");
        MenuItem player2Name = new MenuItem("Player2 Name");

        MenuListener listen;

        public MenuList(MenuListener menuListener){
            super();
            optionlist.getItems().addAll(exitBtn,about,pause,resetGame,resume);
            gameSettings.getItems().addAll(setWinCondition,changeNames,ballSpeed,ballBounce,player1Name,player2Name);
            this.getMenus().addAll(optionlist,gameSettings);
            this.listen = menuListener;
            about.setOnAction(e-> menuListener.setAbout());
            exitBtn.setOnAction(e -> menuListener.setExit());
            setWinCondition.setOnAction(event -> menuListener.setGameLimit());
            pause.setOnAction(event -> menuListener.pauseGame());
            resume.setOnAction(event -> menuListener.resumeGame());
            resetGame.setOnAction(event -> menuListener.resetGame());
            ballBounce.setOnAction(event -> menuListener.setBallBounce());
            ballSpeed.setOnAction(event -> menuListener.setBallspd());
            player1Name.setOnAction(event -> menuListener.setp1Name());
            player2Name.setOnAction(event -> menuListener.setp2Name());
        }
}
