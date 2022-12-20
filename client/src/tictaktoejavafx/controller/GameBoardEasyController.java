package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.data.model.PlayerName;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardEasyController extends GameBoardScreenBase {

    
    int count = 0;
    ArrayList arrlist = new ArrayList();
    ArrayList arrlistButtons = new ArrayList();
    private Stage stage;
    private boolean isRecorded = false;
    private RecordDataBasedSystem db;

    public GameBoardEasyController(Stage stage) {
        RecordDataBasedSystem.newGame = true;
        this.stage = stage;
        db =  RecordDataBasedSystem.getInstance();
        label_player1.setText(Navigator.getPlayerOne());
        label_player2.setText(Navigator.getPlayerTwo());
        addbuttonInList();
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        playerGame(btn_Game_one);
        db.saveRecord(isRecorded, btn_Game_one, "1");

    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        playerGame(btn_Game_two);
        db.saveRecord(isRecorded, btn_Game_two, "2");
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        playerGame(btn_Game_four);
        db.saveRecord(isRecorded, btn_Game_four, "4");
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        playerGame(btn_Game_seven);
        db.saveRecord(isRecorded, btn_Game_seven, "7");
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        playerGame(btn_Game_three);
        db.saveRecord(isRecorded, btn_Game_three, "3");
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        playerGame(btn_Game_five);
        db.saveRecord(isRecorded, btn_Game_five, "5");
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        playerGame(btn_Game_six);
        db.saveRecord(isRecorded, btn_Game_six, "6");
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        playerGame(btn_Game_eight);
        db.saveRecord(isRecorded, btn_Game_eight, "8");
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        playerGame(btn_Game_nine);
        db.saveRecord(isRecorded, btn_Game_nine, "9");

    }

    //-----------------------------------------
    void playerGame(Button button) {

        arrlistButtons.remove(button);
        count++;
        button.setDisable(true);
        if (count % 2 != 0) {
            button.setText("X");
             try {
                  check();
             } catch (IOException ex) {
                  Logger.getLogger(GameBoardEasyController.class.getName()).log(Level.SEVERE, null, ex);
             }
            random();

        }
    }

    void check() throws IOException {

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
        /*     [X][ ][ ]
            [ ][X][ ]
            [ ][ ][X]*/
        arrlist.add(btn_Game_one.getText() + btn_Game_five.getText() + btn_Game_nine.getText());
        /*     [ ][ ][X]
            [ ][X][ ]
            [X][ ][ ]*/
        arrlist.add(btn_Game_three.getText() + btn_Game_five.getText() + btn_Game_seven.getText());

        for (int i = 0; i < arrlist.size(); i++) {
            if (arrlist.get(i).equals("XXX")) {
                disableButton();
                PlayerName.setPlayerName("Player 1");
                HistoryDataBasedSystem.saveFile("Player 1");
                playVideo();
            } else if (arrlist.get(i).equals("OOO")) {
                disableButton();
                PlayerName.setPlayerName("Player 2");
                HistoryDataBasedSystem.saveFile("Player 2");
                playVideo();
            }

        }
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
        Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
    }

    void random() {
        Random random_method = new Random();
        try {
            if (arrlistButtons.size() > 0) {
                int index = random_method.nextInt(arrlistButtons.size());
                System.out.println(index);

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
                                  Logger.getLogger(GameBoardEasyController.class.getName()).log(Level.SEVERE, null, ex);
                             }

                           button.setStyle("-fx-text-fill: Red;");

                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
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
        new UserMessage().display(Config.EXIT_MSG, new AlertAction() {
            @Override
            public void sendOk() {
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
        if(isRecorded){
            RecordDataBasedSystem.getInstance().saveRecordSession("Single Easy Player");
        }

    }
}
