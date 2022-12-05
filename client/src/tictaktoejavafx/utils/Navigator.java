package tictaktoejavafx.utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictaktoejavafx.Client;
import tictaktoejavafx.controller.ChooseDiffucultyController;
import tictaktoejavafx.controller.GameBoardController;
import tictaktoejavafx.controller.LoginController;
import tictaktoejavafx.controller.PlayerListController;
import tictaktoejavafx.controller.PlayerSelectionController;
import tictaktoejavafx.controller.RegisterController;
import tictaktoejavafx.controller.WelcomeController;
import tictaktoejavafx.controller.WinnerAndLosserController;


public class Navigator {
    public static final int WELCOME = 0;
    public static final int CHOOSEDIFF = 1;
    public static final int GAMEBOARD = 2;
    public static final int LOGIN = 3;
    public static final int PLAYER_LIST = 4;
    public static final int PLAYER_SELECTION = 5;
    public static final int REGISTER = 6;
    public static final int WINNER_NOTIFY = 7;
   
    
    public static void navigate(final int destination,Stage stage){
        Parent parent = null;
        switch (destination) {
            case WELCOME:
              parent  = new WelcomeController(stage);
              break;
              
            case CHOOSEDIFF:
              parent  = new ChooseDiffucultyController(stage);
              break;
              
            case GAMEBOARD:
              parent  = new GameBoardController(stage);
              break;
            
            case LOGIN:
              parent  = new LoginController(stage);
              break;
              
            case PLAYER_LIST:
              parent  = new PlayerListController(stage);
              break;
              
            case PLAYER_SELECTION:
              parent  = new PlayerSelectionController(stage);
              break;
              
            case REGISTER:
              parent  = new RegisterController(stage);
              break;
              
            case WINNER_NOTIFY:
              parent  = new WinnerAndLosserController(stage);
              break;
            
            default:
                parent  = new WelcomeController(stage);
                             
          }
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Client.CSS);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
