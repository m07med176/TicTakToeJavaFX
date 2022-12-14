package tictaktoejavafx.controller;

import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class GameBoardEasyController extends GameBoardScreenBase {

     int count = 0;
     private ArrayList<String> arrlist;
     private ArrayList<Button> arrlistButtons;
     private Stage stage;
     private boolean isRecorded = false;
     private RecordDataBasedSystem db;

     public GameBoardEasyController(Stage stage) {
          this.stage = stage;
          db = RecordDataBasedSystem.getInstance();
          arrlist = new ArrayList();
          arrlistButtons = new ArrayList();
          label_player1.setText(Navigator.getPlayerOne());
          label_player2.setText(Navigator.getPlayerTwo());
          addbuttonInList();
     }

     @Override
     protected void isGameOne(ActionEvent actionEvent) {
          playerGame(this.btn_Game_one, "1");
     }

     @Override
     protected void isGameTwo(ActionEvent actionEvent) {
          playerGame(this.btn_Game_two, "2");
     }

     @Override
     protected void isGameThree(ActionEvent actionEvent) {
          playerGame(this.btn_Game_three, "3");
     }

     @Override
     protected void isGameFour(ActionEvent actionEvent) {
          playerGame(this.btn_Game_four, "4");
     }

     @Override
     protected void isGameFive(ActionEvent actionEvent) {
          playerGame(this.btn_Game_five, "5");
     }

     @Override
     protected void isGameSix(ActionEvent actionEvent) {
          playerGame(this.btn_Game_six, "6");
     }

     @Override
     protected void isGameSeven(ActionEvent actionEvent) {
          playerGame(this.btn_Game_seven, "7");
     }

     @Override
     protected void isGameEight(ActionEvent actionEvent) {
          playerGame(this.btn_Game_eight, "8");
     }

     @Override
     protected void isGameNine(ActionEvent actionEvent) {
          playerGame(this.btn_Game_nine, "9");
     }

     void playerGame(Button button, String degree) {
          button.setDisable(true);
          arrlistButtons.remove(button);
          System.out.println("Button Click is: " + degree);
          count++;
          if (count % 2 != 0) {
               button.setText("X");

               try {
                    check();
               } catch (IOException ex) {
                    UserMessage.showError(ex.getMessage());
               }
               random();
          }

          try {
               db.saveRecord(isRecorded, button, degree);

          } catch (JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          } catch (IOException ex) {
               Logger.getLogger(GameBoardEasyController.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     void addbuttonsInList() {
          arrlist.clear();
          //-------------rows----------------------------
          /*     [X][X][X]
            [ ][ ][ ]
            [ ][ ][ ]  */
          arrlist.add(btn_Game_one.getText() + btn_Game_two.getText() + btn_Game_three.getText());
          /*     [ ][ ][ ]
            [X][X][X]
            [ ][ ][ ]  */
          arrlist.add(btn_Game_four.getText() + btn_Game_five.getText() + btn_Game_six.getText());

          /*   [ ][ ][ ]
            [ ][ ][ ]
            [X][X][X]*/
          arrlist.add(btn_Game_seven.getText() + btn_Game_eight.getText() + btn_Game_nine.getText());

          //-------------Colums----------------------------
          /*  [X][ ][ ]
            [X][ ][ ]
            [X][ ][ ]*/
          arrlist.add(btn_Game_one.getText() + btn_Game_four.getText() + btn_Game_seven.getText());
          /*      [ ][X][ ]
            [ ][X][ ]
            [ ][X][ ]*/
          arrlist.add(btn_Game_two.getText() + btn_Game_five.getText() + btn_Game_eight.getText());
          /*     [ ][ ][X]
            [ ][ ][X]
            [ ][ ][X]*/
          arrlist.add(btn_Game_three.getText() + btn_Game_six.getText() + btn_Game_nine.getText());

          //-------------cross----------------------------
          /*  [X][ ][ ]
            [ ][X][ ]
            [ ][ ][X]*/
          arrlist.add(btn_Game_one.getText() + btn_Game_five.getText() + btn_Game_nine.getText());
          /*  [ ][ ][X]
            [ ][X][ ]
            [X][ ][ ]*/
          arrlist.add(btn_Game_three.getText() + btn_Game_five.getText() + btn_Game_seven.getText());
     }

     void check() throws IOException {
          addbuttonsInList();
          for (int i = 0; i < arrlist.size(); i++) {
               if (arrlist.get(i).equals("XXX")) {
                   // greenButtons(i + 1);
                    disableButton();
                    saveSession(Navigator.getPlayerOne());
                    arrlist.clear();
                 //   sleepScreenAndPlayVideo();
                      playVideo();


               } else if (arrlist.get(i).equals("OOO")) {
                   // greenButtons(i + 1);
                    disableButton();
                    saveSession(Navigator.getPlayerTwo());
                    arrlist.clear();
                    sleepScreenAndPlayVideo();
               } else if (arrlistButtons.isEmpty()) {
                    saveSession(Config.DRAW);
                    arrlist.clear();
                 //   sleepScreenAndPlayVideo();
                    playVideo();

               }

          }
     }

     void sleepScreenAndPlayVideo() {
          Platform.runLater(() -> {
               try {
                    Thread.sleep(2000);
                    playVideo();
               } catch (InterruptedException ex) {
                    UserMessage.showError(ex.getMessage());
               }
          });
     }

     void disableButton() {
          btn_Game_one.setDisable(true);
          btn_Game_two.setDisable(true);
          btn_Game_three.setDisable(true);
          btn_Game_four.setDisable(true);
          btn_Game_five.setDisable(true);
          btn_Game_six.setDisable(true);
          btn_Game_seven.setDisable(true);
          btn_Game_eight.setDisable(true);
          btn_Game_nine.setDisable(true);
     }

     void playVideo() {
          Navigator.setPlayerStage(Navigator.WINNER_NOTIFY);
          Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
     }

     void random() {
          Random random_method = new Random();
          try {
               if (arrlistButtons.size() > 0) {
                    int index = random_method.nextInt(arrlistButtons.size());
                    if (index < arrlistButtons.size()) {
                         Button button = (Button) arrlistButtons.get(index);
                         if (button != null && !button.isDisable()) {
                              count++;
                              button.setDisable(true);
                              arrlistButtons.remove(button);
                              if (count % 2 == 0) {
                                   button.setText("O");
                                   try {
                                        check();
                                   } catch (IOException ex) {
                                        UserMessage.showError(ex.getMessage());
                                   }
                                   button.setStyle("-fx-text-fill: Red;");
                              }
                         }
                    }
               }
          } catch (IndexOutOfBoundsException e) {
               UserMessage.showError(e.getMessage());
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
          }, AlertType.CONFIRMATION);

     }

     @Override
     protected void isVideo(ActionEvent actionEvent) {
          isRecorded = !isRecorded;
          video_btn.setDisable(true);
          video_btn.setStyle("-fx-text-fill: Red");
          if (isRecorded) {
               db.saveRecordSession("Single Easy Player");
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

     private void saveSession(String PLAYER) {
          WinnerName.setWinnerName(PLAYER);
          try {
               HistoryDataBasedSystem.saveFile(PLAYER);
          } catch (IOException | JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          }
     }
}
