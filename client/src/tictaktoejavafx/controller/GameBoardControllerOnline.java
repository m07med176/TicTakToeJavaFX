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
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class GameBoardControllerOnline extends GameBoardScreenBase {

     private static Stage stage;
     public ArrayList<String> diagonals = new ArrayList<>();
     public static char turn = 'X';
     public static ArrayList<Button> arrlistButtons = new ArrayList();
     public static ArrayList<Button> arrlistButtons2 = new ArrayList();
     boolean start = true;
     public static Button button;
     private boolean isRecorded = false;

     public GameBoardControllerOnline(Stage stage) {

          Navigator.setIsOnline(true);
          LocalMultiPlayer.setGameEnded(false);
          this.stage = stage;
          addbuttonInList();
          addAllbuttonInList();
          label_player1.setText(Navigator.getPlayerOne());
          label_player2.setText(Navigator.getPlayerTwo());
          if (!Navigator.isStartGame()) {
               Navigator.setSetX(false);
               disableButton();
          }
          this.stage.setOnCloseRequest((WindowEvent event) -> {
               try {
                    ServerConnection.closeThread();
               } catch (IOException ex) {
                    new UserMessage().display(ex.getMessage(), new CallBackAction() {
                         @Override
                         public void sendOk() {
                              Navigator.navigate(Navigator.WELCOME, stage);
                         }

                         @Override
                         public void sendCancel() {
                              // Do Nothing
                         }
                    }, Alert.AlertType.ERROR);
               }
          });

     }

     @Override
     protected void isGameOne(ActionEvent actionEvent) {
          gameTurns(btn_Game_one);
          sendMove(1, btn_Game_one.getText());
          disableButton();
     }

     @Override
     protected void isGameFour(ActionEvent actionEvent) {
          gameTurns(btn_Game_four);
          sendMove(4, btn_Game_four.getText());
          disableButton();
     }

     @Override
     protected void isGameSeven(ActionEvent actionEvent) {
          gameTurns(btn_Game_seven);
          sendMove(7, btn_Game_seven.getText());
          disableButton();
     }

     @Override
     protected void isGameTwo(ActionEvent actionEvent) {
          gameTurns(btn_Game_two);
          sendMove(2, btn_Game_two.getText());
          disableButton();
     }

     @Override
     protected void isGameThree(ActionEvent actionEvent) {
          gameTurns(btn_Game_three);
          sendMove(3, btn_Game_three.getText());
          disableButton();
     }

     @Override
     protected void isGameFive(ActionEvent actionEvent) {
          gameTurns(btn_Game_five);
          sendMove(5, btn_Game_five.getText());
          disableButton();
     }

     @Override
     protected void isGameSix(ActionEvent actionEvent) {
          gameTurns(btn_Game_six);
          sendMove(6, btn_Game_six.getText());
          disableButton();
     }

     @Override
     protected void isGameEight(ActionEvent actionEvent) {
          gameTurns(btn_Game_eight);
          sendMove(8, btn_Game_eight.getText());
          disableButton();
     }

     @Override
     protected void isGameNine(ActionEvent actionEvent) {
          gameTurns(btn_Game_nine);
          sendMove(9, btn_Game_nine.getText());
          disableButton();
     }

     public void gameTurns(Button button) {
          if (Navigator.isSetX()) {
               button.setText("X");
               button.setDisable(true);
               diagonalFiller();
               LocalMultiPlayer.localMulti(diagonals, stage);
               LocalMultiPlayer.drawChecker(stage);
               changeColorAndPlayVideo();
          } else {
               button.setText("O");
               button.setDisable(true);
               diagonalFiller();
               LocalMultiPlayer.localMulti(diagonals, stage);
               LocalMultiPlayer.drawChecker(stage);
               changeColorAndPlayVideo();
          }

     }

     void changeColorAndPlayVideo() {
          if (LocalMultiPlayer.getIndexDiagonalOnline() > 0) {
               greenButtons(LocalMultiPlayer.getIndexDiagonalOnline());
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
                    Navigator.navigate(Navigator.WELCOME, stage);
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          }, Alert.AlertType.CONFIRMATION);

     }

     public static void disableButton() {
          for (int i = 0; i < arrlistButtons.size(); i++) {
               if (!arrlistButtons.get(i).isDisabled()) {
                    arrlistButtons.get(i).setDisable(true);
               }
          }
     }

     void addbuttonInList() {
          arrlistButtons.add(btn_Game_one);
          arrlistButtons.add(btn_Game_two);
          arrlistButtons.add(btn_Game_three);
          arrlistButtons.add(btn_Game_four);
          arrlistButtons.add(btn_Game_five);
          arrlistButtons.add(btn_Game_six);
          arrlistButtons.add(btn_Game_seven);
          arrlistButtons.add(btn_Game_eight);
          arrlistButtons.add(btn_Game_nine);
     }

     void addAllbuttonInList() {
          if (arrlistButtons2 == null) {
               arrlistButtons2 = new ArrayList();
          }
          arrlistButtons2.add(btn_Game_one);
          arrlistButtons2.add(btn_Game_two);
          arrlistButtons2.add(btn_Game_three);
          arrlistButtons2.add(btn_Game_four);
          arrlistButtons2.add(btn_Game_five);
          arrlistButtons2.add(btn_Game_six);

          arrlistButtons2.add(btn_Game_seven);
          arrlistButtons2.add(btn_Game_eight);
          arrlistButtons2.add(btn_Game_nine);
     }

     public void sendMove(int val, String move) {
          String msg;
          if (Navigator.isStartGame()) {
               msg = ServerCall.MOVEMENT_SEND + ServerCall.DELIMETER + Navigator.getPlayerTwo() + ServerCall.DELIMETER + Integer.toString(val) + ServerCall.DELIMETER + move;
               try {
                    ServerConnection.sendMessage(msg);
               } catch (IOException ex) {
                    Logger.getLogger(GameBoardControllerOnline.class.getName()).log(Level.SEVERE, null, ex);
               }
          } else {
               msg = ServerCall.MOVEMENT_SEND + ServerCall.DELIMETER + Navigator.getPlayerOne() + ServerCall.DELIMETER + Integer.toString(val) + ServerCall.DELIMETER + move;

               //disableButton();
               try {
                    ServerConnection.sendMessage(msg);
               } catch (IOException ex) {
                    Logger.getLogger(GameBoardControllerOnline.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
     }

     public void readMove() {

          if (Navigator.getBoardMove() != null && Navigator.getButtonNumber() != null) {
               switch (Integer.parseInt(Navigator.getButtonNumber())) {
                    case 1:
                         btn_Game_one.setText(Navigator.getBoardMove());
                         break;
                    case 2:
                         btn_Game_two.setText(Navigator.getBoardMove());
                         break;
                    case 3:
                         btn_Game_three.setText(Navigator.getBoardMove());
                         break;
                    case 4:
                         btn_Game_four.setText(Navigator.getBoardMove());
                         break;
                    case 5:
                         btn_Game_five.setText(Navigator.getBoardMove());
                         break;
                    case 6:
                         btn_Game_six.setText(Navigator.getBoardMove());
                         break;
                    case 7:
                         btn_Game_seven.setText(Navigator.getBoardMove());
                         break;
                    case 8:
                         btn_Game_eight.setText(Navigator.getBoardMove());
                         break;
                    case 9:
                         btn_Game_nine.setText(Navigator.getBoardMove());
                         break;

               }

          }

     }

     public static Stage getStage() {
          return stage;
     }

     @Override
     protected void isVideo(ActionEvent actionEvent) {
          isRecorded = !isRecorded;
          if (isRecorded) {
               RecordDataBasedSystem.getInstance().saveRecordSession("Online Player");
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
