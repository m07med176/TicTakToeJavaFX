package tictaktoejavafx.utils;

import java.util.Vector;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictaktoejavafx.Client;
import tictaktoejavafx.controller.ChooseDiffucultyController;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.controller.GameBoardEasyController;
import tictaktoejavafx.controller.GameBoardHardController;
import tictaktoejavafx.controller.GameBoardMiddleController;
import tictaktoejavafx.controller.LoginController;
import tictaktoejavafx.controller.PlayerSelectionController;
import tictaktoejavafx.controller.RegisterController;
import tictaktoejavafx.controller.WelcomeController;
import tictaktoejavafx.controller.WinnerAndLosserController;
import tictaktoejavafx.controller.GameBoardMultiController;
import tictaktoejavafx.controller.GameBoardRecordController;
import tictaktoejavafx.controller.HistoryController;
import tictaktoejavafx.controller.OnePlayerController;
import tictaktoejavafx.controller.RecordTableController;
import tictaktoejavafx.controller.SnakeGameController;
import tictaktoejavafx.controller.SplashController;
import tictaktoejavafx.controller.TwoPlayerController;

public class Navigator {

    public static final int WELCOME = 0;
    public static final int CHOOSEDIFF = 1;
    public static final int GAMEBOARD = 2;
    public static final int LOGIN = 3;
    public static final int PLAYER_SELECTION = 5;
    public static final int REGISTER = 6;
    public static final int WINNER_NOTIFY = 7;
    public static final int GAMEBOARD_MULTI = 8;
    public static final int SPLACH = 9;
    public static final int PLAYER_NAME_ONE = 10;
    public static final int PLAYER_NAME_TWO = 11;
    public static final int GAMEBOARDMIDDLE = 12;
    public static final int GAMEBOARDHARD = 13;
    public static final int GAMEBOARDONLINE = 14;
    public static final int RECORD = 18;
    public static final int TABLE_RECORD = 15;
    public static final int HISTORY = 16;
    public static final int SNAKEGAME = 17;
    public static final int CHOSE_GAME=19;
    
    public static String playerOne;
    public static String playerTwo;
    public static String buttonNumber;
    public static String boardMove;
    public static boolean startGame;
    public static boolean setX = true;

    public static boolean isSetX() {
        return setX;
    }

    public static void setSetX(boolean setX) {
        Navigator.setX = setX;
    }

    public static String getButtonNumber() {
        return buttonNumber;
    }

    public static void setButtonNumber(String buttonNumber) {
        Navigator.buttonNumber = buttonNumber;
    }

    public static String getBoardMove() {
        return boardMove;
    }

    public static void setBoardMove(String boardMove) {
        Navigator.boardMove = boardMove;
    }

    public static boolean isStartGame() {
        return startGame;
    }

    public static void setStartGame(boolean startGame) {
        Navigator.startGame = startGame;
    }

    public static Vector<Scene> pages = new Vector();
    public static int pageIndex = 0;

    public static void next(Stage stage) {
        if (pageIndex < pages.size()) {
            pageIndex++;
            stage.setScene(pages.get(pageIndex));
            stage.show();
        }
    }

    public static void back(Stage stage) {
        if (pageIndex > 0) {
            pageIndex--;
            stage.setScene(pages.get(pageIndex));
            stage.show();
        }
    }

    public static void navigate(final int destination, Stage stage, Object model) {
        Parent parent = null;
        switch (destination) {
            case LOGIN:
                parent = new LoginController(stage,model);
                break;
            case REGISTER:
                System.out.println("Choose Register");
                parent = new RegisterController(stage,model);
                break;  
            case RECORD:
                parent = new GameBoardRecordController(stage, model);
                break;
            default:
                parent = new WelcomeController(stage);
        }
        System.out.println(destination);
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Client.CSS);

        if (destination != WELCOME) {
            pages.add(scene);
            pageIndex++;
        } else {
            pages.clear();
            pageIndex = 0;
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void navigate(final int destination, Stage stage) {
        Parent parent = null;
        switch (destination) {
            case WELCOME:
                parent = new WelcomeController(stage);
                break;

            case CHOOSEDIFF:
                parent = new ChooseDiffucultyController(stage);
                break;

            case GAMEBOARD:
                parent = new GameBoardEasyController(stage);
                break;

            case PLAYER_SELECTION:
                parent = new PlayerSelectionController(stage);
                break;

            case WINNER_NOTIFY:
                parent = new WinnerAndLosserController(stage);
                break;

            case GAMEBOARD_MULTI:
                parent = new GameBoardMultiController(stage);
                break;

            case SPLACH:
                parent = new SplashController(stage);
                break;

            case PLAYER_NAME_ONE:
                parent = new OnePlayerController(stage);
                break;
            case PLAYER_NAME_TWO:
                parent = new TwoPlayerController(stage);
                break;
            case GAMEBOARDMIDDLE:
                parent = new GameBoardMiddleController(stage);
                break;
            case GAMEBOARDHARD:
                parent = new GameBoardHardController(stage);
                break;

            case TABLE_RECORD:
                parent = new RecordTableController(stage);
                break;
            case GAMEBOARDONLINE:
                parent = new GameBoardControllerOnline(stage);
                break;

            case HISTORY:
                parent = new HistoryController(stage);
                break;

            case SNAKEGAME:
                parent = new SnakeGameController(stage);
                break;
            default:
                parent = new WelcomeController(stage);

        }
        System.out.println(destination);
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Client.CSS);

        if (destination != WELCOME) {
            pages.add(scene);
            pageIndex++;
        } else {
            pages.clear();
            pageIndex = 0;
        }

        stage.setScene(scene);
        stage.show();
    }

    public static String getPlayerOne() {
        return playerOne;
    }

    public static void setPlayerOne(String playerOne) {
        Navigator.playerOne = playerOne;
    }

    public static String getPlayerTwo() {
        return playerTwo;
    }

    public static void setPlayerTwo(String playerTwo) {
        Navigator.playerTwo = playerTwo;
    }

}
