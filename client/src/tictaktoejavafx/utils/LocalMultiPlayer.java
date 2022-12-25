package tictaktoejavafx.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import static tictaktoejavafx.data.server.ServerConnection.UID;
import static tictaktoejavafx.data.server.ServerConnection.sendMessage;

public class LocalMultiPlayer {

     static int numberOfPresses = 0;
     static boolean gameEnded = false;

     public static boolean getGameEnded() {

          return gameEnded;
     }

     public static void localMulti(ArrayList<String> d, Stage stage) {
          for (int i = 0; i < d.size(); i++) {

               if (d.get(i).equals("XXX")) {
                    if (Navigator.isOnline) {
                         Navigator.setOnlineWinner(Navigator.getPlayerOne());
                         if(Navigator.isStartGame()){
                             try {
                                 ServerConnection.sendMessage(ServerCall.GAME_ENDED+ServerCall.DELIMETER+Navigator.getPlayerOne());
                             } catch (IOException ex) {
                                 Logger.getLogger(LocalMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }else{
                             try {
                                 ServerConnection.sendMessage(ServerCall.GAME_ENDED+ServerCall.DELIMETER+Navigator.getPlayerTwo());
                             } catch (IOException ex) {
                                 Logger.getLogger(LocalMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                    }
                    WinnerName.setWinnerName(Navigator.getPlayerOne());
                    WinnerName.setWinnerName(Config.PLAYER_X);
                    gameEnded = true;
                    numberOfPresses = 0;
                    GameBoardControllerOnline.arrlistButtons2 = null;
                    ServerConnection.diagonals = null;
                    Navigator.setPlayerStage(Navigator.WINNER_NOTIFY);
                    Navigator.navigate(Navigator.WINNER_NOTIFY, stage);

               } else if (d.get(i).equals("OOO")) {

                    if (Navigator.isOnline) {
                         Navigator.setOnlineWinner(Navigator.getPlayerTwo());
                          if(Navigator.isStartGame()){
                             try {
                                 ServerConnection.sendMessage(ServerCall.GAME_ENDED+ServerCall.DELIMETER+Navigator.getPlayerOne());
                             } catch (IOException ex) {
                                 Logger.getLogger(LocalMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }else{
                             try {
                                 ServerConnection.sendMessage(ServerCall.GAME_ENDED+ServerCall.DELIMETER+Navigator.getPlayerTwo());
                             } catch (IOException ex) {
                                 Logger.getLogger(LocalMultiPlayer.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                    }
                    WinnerName.setWinnerName(Navigator.getPlayerTwo());
                    WinnerName.setWinnerName(Config.PLAYER_O);

                    gameEnded = true;
                    numberOfPresses = 0;
                    GameBoardControllerOnline.arrlistButtons2 = null;
                    ServerConnection.diagonals = null;
                    //Navigator.setWinnerPlayer(Navigator.getPlayerTwo());
                    Navigator.setPlayerStage(Navigator.WINNER_NOTIFY);
                    Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
               }

          }
          numberOfPresses++;
     }

     public static void setGameEnded(boolean gameEnded) {
          LocalMultiPlayer.gameEnded = gameEnded;
     }

     public static void drawChecker(Stage stage) {
          if (numberOfPresses >= 9 && gameEnded == false) {
               if (Navigator.isOnline) {
                    Navigator.setOnlineWinner("DRAW");
               }
               WinnerName.setWinnerName("DRAW");
               gameEnded = true;
               numberOfPresses = 0;
               GameBoardControllerOnline.arrlistButtons2 = null;
               ServerConnection.diagonals = null;
               Navigator.setPlayerStage(Navigator.WINNER_NOTIFY);
               Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
          }
     }
}
