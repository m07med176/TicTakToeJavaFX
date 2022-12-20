
package tictaktoejavafx.utils;

import tictaktoejavafx.data.model.PlayerName;
import java.util.ArrayList;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.controller.GameBoardMultiController;
import tictaktoejavafx.data.server.ServerConnection;


public class LocalMultiPlayer {
    static int numberOfPresses=0;
    static boolean gameEnded=false;
     public static boolean getGameEnded(){
    
        return gameEnded;
    }


    public static void localMulti(ArrayList<String> d,Stage stage){
        for(int i=0;i<d.size();i++){
        
            if(d.get(i).equals("XXX")){

                PlayerName.setPlayerName(Navigator.getPlayerOne());
                PlayerName.setPlayerName("Player One");
                gameEnded=true;
                numberOfPresses=0;
                GameBoardControllerOnline.arrlistButtons2=null;
                ServerConnection.diagonals=null;
                Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
                //GameBoardMultiController.turn='b';
            
            }else if(d.get(i).equals("OOO")){
            
                PlayerName.setPlayerName(Navigator.getPlayerTwo());
                PlayerName.setPlayerName("Player Two");
                gameEnded=true;
                numberOfPresses=0;
                GameBoardControllerOnline.arrlistButtons2=null;
                ServerConnection.diagonals=null;
                Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
                //GameBoardMultiController.turn='b';
            }
        
        }
        numberOfPresses++;
    
    }

    public static void setGameEnded(boolean gameEnded) {
        LocalMultiPlayer.gameEnded = gameEnded;
    }
    public static void drawChecker(Stage stage){
    
        if(numberOfPresses>=9&&gameEnded==false){
            PlayerName.setPlayerName("DRAW");
            gameEnded=true;
            numberOfPresses=0;
            GameBoardControllerOnline.arrlistButtons2=null;
            ServerConnection.diagonals=null;
            Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
            //GameBoardMultiController.turn='b';
            
        
        }
    
    
    }
   
}
