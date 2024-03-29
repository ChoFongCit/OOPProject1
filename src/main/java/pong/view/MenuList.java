package pong.view;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import pong.controller.MenuListener;

/**
 * This class extends MenuBar and is used to store Menu and its MenuItems
 * Used to encapsulate the menu options from the gameplay rendering
 */
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
        MenuItem save = new MenuItem("save");
        MenuItem load = new MenuItem("load");

        MenuListener listen;
    /**
     * Constructs a MenuBar object with the Menu and MenuItem objects declared above
     *
     * @param menuListener listener class for menu items
     * @return an instance of MenuList
     */
        public MenuList(MenuListener menuListener){
            super();
            optionlist.getItems().addAll(about,pause,save,load,resetGame,resume,exitBtn );
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
            save.setOnAction(event -> menuListener.saveState());
            load.setOnAction(event -> menuListener.loadState());
        }
}
