
package tictaktoejavafx.utils;

import tictaktoejavafx.data.model.PlayerName;
import java.util.ArrayList;
import javafx.stage.Stage;


public class LocalMultiPlayer {
    static int numberOfPresses=0;
    static boolean gameEnded=false;
    public static void localMulti(ArrayList<String> d,Stage stage){
        for(int i=0;i<d.size();i++){
        
            if(d.get(i).equals("XXX")){
            
                PlayerName.setPlayerName("Player One");
                Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
                gameEnded=true;
            
            }else if(d.get(i).equals("OOO")){
            
                PlayerName.setPlayerName("Player Two");
                Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
                gameEnded=true;
            }
        
        }
        numberOfPresses++;
    
    }
    public static void drawChecker(Stage stage){
    
        if(numberOfPresses>=9&&gameEnded==false){
            PlayerName.setPlayerName("DRAW");
            Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
            
        
        }
    
    }
}
