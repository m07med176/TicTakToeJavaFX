package tictaktoejavafx.utils;

import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.data.server.ServerConnection;

public class LocalMultiPlayer {

     int numberOfPresses = 0;
     boolean gameEnded = false;

     public boolean getGameEnded() {

          return gameEnded;
     }

     private int indexDiagonal = 0;
     private int indexDiagonalOnline = 0;

     public int getIndexDiagonalOnline() {
          return indexDiagonalOnline;
     }

     public void setIndexDiagonalOnline(int indexDiagonalOnline) {
          indexDiagonalOnline = indexDiagonalOnline;
     }

     public int getIndexDiagonal() {
          return indexDiagonal;
     }

     public void setIndexDiagonal(int indexDiagonal) {
          indexDiagonal = indexDiagonal;
     }

     public void localMulti(ArrayList<String> diagonalList, Stage stage) {
          for (int i = 0; i < diagonalList.size(); i++) {

               if (diagonalList.get(i).equals("XXX")) {
                    if (Navigator.isOnline) {
                         Navigator.setOnlineWinner(Navigator.getPlayerOne());
                    }
                    setIndexDiagonal(i + 1);
                  //  setIndexDiagonalOnline(i + 1);
                    saveSession(Navigator.getPlayerOne());
                    gameEnded = true;
                    numberOfPresses = 0;
                    GameBoardControllerOnline.arrlistButtons2 = null;
                    ServerConnection.diagonals = null;
                         Navigator.setWinnerPlayer(Navigator.getPlayerTwo());

                         Navigator.navigate(Navigator.WINNER_NOTIFY, stage);

               } else if (diagonalList.get(i).equals("OOO")) {

                    if (Navigator.isOnline) {
                         Navigator.setOnlineWinner(Navigator.getPlayerTwo());
                    }
                    setIndexDiagonal(i + 1);
                    saveSession(Navigator.getPlayerTwo());
                    gameEnded = true;
                    numberOfPresses = 0;
                    GameBoardControllerOnline.arrlistButtons2 = null;
                    ServerConnection.diagonals = null;
                    Navigator.setWinnerPlayer(Navigator.getPlayerTwo());

                    Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
               }

          }
          numberOfPresses++;
     }

     public void setGameEnded(boolean gameEnded) {
          gameEnded = gameEnded;
     }

     public void drawChecker(Stage stage) {
          if (numberOfPresses >= 9 && gameEnded == false) {
               if (Navigator.isOnline) {
                    Navigator.setOnlineWinner(Config.DRAW);
               }
               saveSession(Config.DRAW);
               gameEnded = true;
               numberOfPresses = 0;
               GameBoardControllerOnline.arrlistButtons2 = null;
               ServerConnection.diagonals = null;
               Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
          }
     }

     private void saveSession(String PLAYER) {
          WinnerName.setWinnerName(PLAYER);
          try {
               HistoryDataBasedSystem.saveFile(PLAYER);
          } catch (IOException | JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          }
     }
}
