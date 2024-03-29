package pong.view;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import pong.controller.MenuListener;

public class MenuList extends MenuBar {
        Menu optionlist = new Menu("Options");

        MenuItem about = new MenuItem("about");
        MenuItem pause = new Menu("pause");
        MenuItem resetGame = new MenuItem("resetGame");
        MenuItem resume = new Menu("resume");
        MenuItem exitBtn = new MenuItem("Exit");
        MenuItem setWinCondition = new MenuItem("WinCondition");
        MenuItem changeNames = new MenuItem("ChangeName");

        MenuListener listen;

        public MenuList(MenuListener menuListener){
            super();
            optionlist.getItems().addAll(exitBtn,setWinCondition,about,changeNames,pause,resetGame,resume);
            this.getMenus().addAll(optionlist);
            this.listen = menuListener;
            about.setOnAction(e-> menuListener.setAbout());
            exitBtn.setOnAction(e -> menuListener.setExit());
            setWinCondition.setOnAction(event -> menuListener.setGameLimit());
            pause.setOnAction(event -> menuListener.pauseGame());
            resume.setOnAction(event -> menuListener.resumeGame());
            resetGame.setOnAction(event -> menuListener.resetGame());
        }
}
