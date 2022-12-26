package tictaktoejavafx.controller;

import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.HistoryDataModel;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class GameBoardMultiController extends GameBoardScreenBase {

     private final Stage stage;
     ArrayList<String> diagonals = new ArrayList<>();
     public char turn = 'X';
     HistoryDataModel model;
     private boolean isRecorded;
     private final RecordDataBasedSystem db;
     private LocalMultiPlayer localMultiPlayer;

     public GameBoardMultiController(Stage stage) {
          localMultiPlayer = new LocalMultiPlayer();
          localMultiPlayer.setGameEnded(false);
          db = RecordDataBasedSystem.getInstance();
          RecordDataBasedSystem.newGame = true;
          this.stage = stage;

          label_player1.setText(Navigator.getPlayerOne());
          label_player2.setText(Navigator.getPlayerTwo());
          if (turn == 'b') {
               turn = 'X';
          }
     }

     @Override
     protected void isGameOne(ActionEvent actionEvent) {
          gameTurns(btn_Game_one, 1);
     }

     @Override
     protected void isGameFour(ActionEvent actionEvent) {
          gameTurns(btn_Game_four, 4);
     }

     @Override
     protected void isGameSeven(ActionEvent actionEvent) {
          gameTurns(btn_Game_seven, 7);
     }

     @Override
     protected void isGameTwo(ActionEvent actionEvent) {
          gameTurns(btn_Game_two, 2);
     }

     @Override
     protected void isGameThree(ActionEvent actionEvent) {
          gameTurns(btn_Game_three, 3);
     }

     @Override
     protected void isGameFive(ActionEvent actionEvent) {
          gameTurns(btn_Game_five, 5);
     }

     @Override
     protected void isGameSix(ActionEvent actionEvent) {
          gameTurns(btn_Game_six, 6);
     }

     @Override
     protected void isGameEight(ActionEvent actionEvent) {
          gameTurns(btn_Game_eight, 8);
     }

     @Override
     protected void isGameNine(ActionEvent actionEvent) {
          gameTurns(btn_Game_nine, 9);
     }

     public void gameTurns(Button button, int degree) {

          if (turn == 'X') {

              try {
                  turn = 'O';
                  button.setText("X");
                  button.setDisable(true);
                  diagonalFiller();
                  localMultiPlayer.localMulti(diagonals, stage);
                  localMultiPlayer.drawChecker(stage);
                  changeColorAndPlayVideo();
              } catch (IOException ex) {
                  Logger.getLogger(GameBoardMultiController.class.getName()).log(Level.SEVERE, null, ex);
              }
          } else {
              try {
                  turn = 'X';
                  button.setText("O");
                  button.setStyle("-fx-text-fill: Red;");
                  button.setDisable(true);
                  diagonalFiller();
                  localMultiPlayer.localMulti(diagonals, stage);
                  localMultiPlayer.drawChecker(stage);
                  changeColorAndPlayVideo();
              } catch (IOException ex) {
                  Logger.getLogger(GameBoardMultiController.class.getName()).log(Level.SEVERE, null, ex);
              }

          }

          try {
               db.saveRecord(isRecorded, button, String.valueOf(degree));
          } catch (IOException ex) {
               UserMessage.showError(ex.getMessage());
          } catch (JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          }

     }

     void changeColorAndPlayVideo() {
          if (localMultiPlayer.getIndexDiagonal() > 0) {
               greenButtons(localMultiPlayer.getIndexDiagonal());
               Platform.runLater(() -> {
                    try {
                         Thread.sleep(2000);
                         Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
                    } catch (InterruptedException ex) {
                         UserMessage.showError(ex.getMessage());
                    }
               });
          }

     }

     public void diagonalFiller() {
          diagonals.clear();
          diagonals.add(btn_Game_one.getText() + btn_Game_two.getText() + btn_Game_three.getText());
          diagonals.add(btn_Game_four.getText() + btn_Game_five.getText() + btn_Game_six.getText());
          diagonals.add(btn_Game_seven.getText() + btn_Game_eight.getText() + btn_Game_nine.getText());
          diagonals.add(btn_Game_one.getText() + btn_Game_four.getText() + btn_Game_seven.getText());
          diagonals.add(btn_Game_two.getText() + btn_Game_five.getText() + btn_Game_eight.getText());
          diagonals.add(btn_Game_three.getText() + btn_Game_six.getText() + btn_Game_nine.getText());
          diagonals.add(btn_Game_one.getText() + btn_Game_five.getText() + btn_Game_nine.getText());
          diagonals.add(btn_Game_three.getText() + btn_Game_five.getText() + btn_Game_seven.getText());
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
          video_btn.setDisable(true);
          video_btn.setStyle("-fx-text-fill: Red");
          if (isRecorded) {
               db.saveRecordSession("Multi Player");
          }

     } 

     public void greenButtons(int indexLine) {
          switch (indexLine) {
               case 1:
                    btn_Game_one.setStyle("-fx-background-color: greenyellow");
                    btn_Game_two.setStyle("-fx-background-color: greenyellow");
                    btn_Game_three.setStyle("-fx-background-color: greenyellow");

                    break;
               case 2:
                    btn_Game_four.setStyle("-fx-background-color: greenyellow");
                    btn_Game_five.setStyle("-fx-background-color: greenyellow");
                    btn_Game_six.setStyle("-fx-background-color: greenyellow");
                    break;
               case 3:
                    btn_Game_seven.setStyle("-fx-background-color: greenyellow");
                    btn_Game_eight.setStyle("-fx-background-color: greenyellow");
                    btn_Game_nine.setStyle("-fx-background-color: greenyellow");
                    break;
               case 4:
                    btn_Game_one.setStyle("-fx-background-color: greenyellow");
                    btn_Game_four.setStyle("-fx-background-color: greenyellow");
                    btn_Game_seven.setStyle("-fx-background-color: greenyellow");
                    break;

               case 5:
                    btn_Game_two.setStyle("-fx-background-color: greenyellow");
                    btn_Game_five.setStyle("-fx-background-color: greenyellow");
                    btn_Game_eight.setStyle("-fx-background-color: greenyellow");
                    break;
               case 6:
                    btn_Game_three.setStyle("-fx-background-color: greenyellow");
                    btn_Game_six.setStyle("-fx-background-color: greenyellow");
                    btn_Game_nine.setStyle("-fx-background-color: greenyellow");
                    break;
               case 7:
                    btn_Game_one.setStyle("-fx-background-color: greenyellow");
                    btn_Game_five.setStyle("-fx-background-color: greenyellow");
                    btn_Game_nine.setStyle("-fx-background-color: greenyellow");
                    break;
               case 8:
                    btn_Game_three.setStyle("-fx-background-color: greenyellow");
                    btn_Game_five.setStyle("-fx-background-color: greenyellow");
                    btn_Game_seven.setStyle("-fx-background-color: greenyellow");
                    break;
               default:
                    break;

          }
     }

}
