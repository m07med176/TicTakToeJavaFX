package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.PlayerName;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.TicTacToeAIHard;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardHardController extends GameBoardScreenBase {

     public static String PLAYER1 = "Player 1";
     public static String PLAYER2 = "Player 2";
     private boolean isRecorded;
     private Stage stage;
     private TicTacToeAIHard toeAIHard;
     private RecordDataBasedSystem db;

     public GameBoardHardController(Stage stage) {
          db = RecordDataBasedSystem.getInstance();
          toeAIHard = new TicTacToeAIHard();
          RecordDataBasedSystem.newGame = true;
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
          db.saveRecord(isRecorded, btn_Game_one, "1");
          playerGame(btn_Game_one, 1);
     }

     @Override
     protected void isGameTwo(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_two, "2");
          playerGame(btn_Game_two, 2);
     }

     @Override
     protected void isGameThree(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_three, "3");
          playerGame(btn_Game_three, 3);
     }

     @Override
     protected void isGameFour(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_four, "4");
          playerGame(btn_Game_four, 4);
     }

     @Override
     protected void isGameFive(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_five, "5");
          playerGame(btn_Game_five, 5);
     }

     @Override
     protected void isGameSix(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_six, "6");
          playerGame(btn_Game_six, 6);

     }

     @Override
     protected void isGameSeven(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_seven, "7");
          playerGame(btn_Game_seven, 7);

     }

     @Override
     protected void isGameEight(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_eight, "8");
          playerGame(btn_Game_eight, 8);
     }

     @Override
     protected void isGameNine(ActionEvent actionEvent) {
          db.saveRecord(isRecorded, btn_Game_nine, "9");
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
                         PlayerName.setPlayerName(PLAYER1);
                         System.out.println("Player 1 win");
                         playVideo();

                    } else if (GO == -1) {
                         PlayerName.setPlayerName(PLAYER2);
                         System.out.println("Player 2 win");
                         playVideo();

                    } else {
                         System.out.println(GO);
                         playVideo();

                    }
               }
          }
     }

     void computerMoveActionButton(Button button, String text) {
          button.setDisable(true);
          button.setText(text);
     }

     void playVideo() {
          Navigator.navigate(Navigator.WINNER_NOTIFY, stage);

     }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          new UserMessage().display(Config.EXIT_MSG, new AlertAction() {
               @Override
               public void sendOk() {
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

}
