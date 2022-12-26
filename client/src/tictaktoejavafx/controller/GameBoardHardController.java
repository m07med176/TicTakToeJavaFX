package tictaktoejavafx.controller;

import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.TicTacToeAIHard;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class GameBoardHardController extends GameBoardScreenBase {

     private boolean isRecorded;
     private Stage stage;
     private TicTacToeAIHard toeAIHard;
     private RecordDataBasedSystem db;

     public GameBoardHardController(Stage stage) {
          db = RecordDataBasedSystem.getInstance();
          toeAIHard = new TicTacToeAIHard();
          this.stage = stage;
          toeAIHard.NewGame();
     }

     private void ComputerMove(int player, int move) {
          if (move == 0) {
               move = toeAIHard.isGameOver() == 0 ? toeAIHard.GenerateMove(player) : 0;
          }
          String game = (player == -1) ? "O" : "X";

          switch (move) {
               case 1:
                    computerMoveActionButton(btn_Game_one, game);
                    btn_Game_one.setStyle("-fx-text-fill: Red;");

                    toeAIHard.Move(move, player);
                    break;
               case 2:
                    computerMoveActionButton(btn_Game_two, game);
                    btn_Game_two.setStyle("-fx-text-fill: Red;");

                    toeAIHard.Move(move, player);
                    break;
               case 3:
                    computerMoveActionButton(btn_Game_three, game);
                    btn_Game_three.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
               case 4:
                    computerMoveActionButton(btn_Game_four, game);
                    btn_Game_four.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
               case 5:
                    computerMoveActionButton(btn_Game_five, game);
                    btn_Game_five.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
               case 6:
                    computerMoveActionButton(btn_Game_six, game);
                    btn_Game_two.setStyle("-fx-text-fill: Red;");

                    toeAIHard.Move(move, player);
                    break;
               case 7:
                    computerMoveActionButton(btn_Game_seven, game);
                    btn_Game_seven.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
               case 8:
                    computerMoveActionButton(btn_Game_eight, game);
                    btn_Game_eight.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
               case 9:
                    computerMoveActionButton(btn_Game_nine, game);
                    btn_Game_nine.setStyle("-fx-text-fill: Red;");
                    toeAIHard.Move(move, player);
                    break;
          }

     }

     @Override
     protected void isGameOne(ActionEvent actionEvent) {
          playerGame(btn_Game_one, 1);
     }

     @Override
     protected void isGameTwo(ActionEvent actionEvent) {
          playerGame(btn_Game_two, 2);
     }

     @Override
     protected void isGameThree(ActionEvent actionEvent) {
          playerGame(btn_Game_three, 3);
     }

     @Override
     protected void isGameFour(ActionEvent actionEvent) {
          playerGame(btn_Game_four, 4);
     }

     @Override
     protected void isGameFive(ActionEvent actionEvent) {
          playerGame(btn_Game_five, 5);
     }

     @Override
     protected void isGameSix(ActionEvent actionEvent) {
          playerGame(btn_Game_six, 6);

     }

     @Override
     protected void isGameSeven(ActionEvent actionEvent) {
          playerGame(btn_Game_seven, 7);

     }

     @Override
     protected void isGameEight(ActionEvent actionEvent) {
          playerGame(btn_Game_eight, 8);
     }

     @Override
     protected void isGameNine(ActionEvent actionEvent) {

          playerGame(btn_Game_nine, 9);
     }

     //-----------------------------------------
     void playerGame(Button button, int count) {
          int GO = toeAIHard.isGameOver();
          System.out.println(GO);
          System.out.println(count);
          if (toeAIHard.Move(count, 1) && GO == 0) {
               System.out.println("YES");
               button.setDisable(true);
               button.setText("X");

               ComputerMove(-1, 0);

               if ((GO = toeAIHard.isGameOver()) != 0) {
                    if (GO == 1) {
                         saveSession(Config.PLAYER_X);
                         Navigator.setPlayerWinner(Navigator.getPlayerOne());
                         playVideo();

                    } else if (GO == -1) {
                         Navigator.setPlayerWinner(Navigator.getPlayerTwo());
                         saveSession(Config.PLAYER_O);
                         playVideo();

                    } else {
                         saveSession(Config.DRAW);
                         playVideo();

                    }
               }
          }

          try {
               db.saveRecord(isRecorded, button, String.valueOf(count));
          } catch (IOException ex) {
               UserMessage.showError(ex.getMessage());
          } catch (JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          }
     }

     void computerMoveActionButton(Button button, String text) {
          button.setDisable(true);
          button.setText(text);
     }

     void playVideo() {
          Navigator.setPlayerStage(Navigator.WINNER_NOTIFY);
          Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
     }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          new UserMessage().display(Config.EXIT_MSG, new CallBackAction() {
               @Override
               public void sendOk() {
                    Navigator.setPlayerStage(Navigator.WELCOME);
                    Navigator.navigate(Navigator.WELCOME, stage);
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          }, Alert.AlertType.CONFIRMATION);

     }

     @Override
     protected void isVideo(ActionEvent actionEvent) {
          isRecorded = !isRecorded;
          if (isRecorded) {
               db.saveRecordSession("Single Hard Player");
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
