package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordData;
import tictaktoejavafx.data.model.PlayerName;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardMiddleController extends GameBoardScreenBase {

    int count = 0;
    ArrayList arrlist = new ArrayList();
    private Stage stage;
    private boolean isRecorded;

    public GameBoardMiddleController(Stage stage) {
        RecordData.newGame = true;
        this.stage = stage;
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        playerGame(btn_Game_one);
        RecordData.getInstance().saveRecord(isRecorded, btn_Game_one, "4");

    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        playerGame(btn_Game_two);
        RecordData.getInstance().saveRecord(isRecorded, btn_Game_two, "4");

    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        playerGame(btn_Game_four);

        RecordData.getInstance().saveRecord(isRecorded, btn_Game_four, "4");

    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        playerGame(btn_Game_seven);

        RecordData.getInstance().saveRecord(isRecorded, btn_Game_seven, "7");

    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        playerGame(btn_Game_three);

        RecordData.getInstance().saveRecord(isRecorded, btn_Game_three, "3");

    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        playerGame(btn_Game_five);
        RecordData.getInstance().saveRecord(isRecorded, btn_Game_five, "5");

    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        playerGame(btn_Game_six);

        RecordData.getInstance().saveRecord(isRecorded, btn_Game_six, "6");

    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        playerGame(btn_Game_eight);
        RecordData.getInstance().saveRecord(isRecorded, btn_Game_eight, "8");

    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        playerGame(btn_Game_nine);

        RecordData.getInstance().saveRecord(isRecorded, btn_Game_nine, "9");

    }

    //-----------------------------------------
    void playerGame(Button button) {

        count++;
        button.setDisable(true);
        if (count % 2 != 0) {
            button.setText("X");
            check();

        }
    }

    void check() {

        //-------------rows----------------------------
        arrlist.add(btn_Game_one.getText() + btn_Game_two.getText() + btn_Game_three.getText());
        arrlist.add(btn_Game_four.getText() + btn_Game_five.getText() + btn_Game_six.getText());
        arrlist.add(btn_Game_seven.getText() + btn_Game_eight.getText() + btn_Game_nine.getText());

        //-------------Colums----------------------------
        arrlist.add(btn_Game_one.getText() + btn_Game_four.getText() + btn_Game_seven.getText());
        arrlist.add(btn_Game_two.getText() + btn_Game_five.getText() + btn_Game_eight.getText());
        arrlist.add(btn_Game_three.getText() + btn_Game_six.getText() + btn_Game_nine.getText());

        //-------------cross----------------------------
        arrlist.add(btn_Game_one.getText() + btn_Game_five.getText() + btn_Game_nine.getText());
        arrlist.add(btn_Game_three.getText() + btn_Game_five.getText() + btn_Game_seven.getText());

        for (int i = 0; i < arrlist.size(); i++) {
            if (arrlist.get(i).equals("XXX")) {
                // result_label.setText("Player 1 is Winner");
                disableButton();
                PlayerName.setPlayerName("Player 1");
                playVideo();
            } else if (arrlist.get(i).equals("OOO")) {
                //  result_label.setText("Player 2 is Winner");
                disableButton();
                PlayerName.setPlayerName("Player 2");

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

    //-----------------------------------------
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
        if(isRecorded){
        RecordData.getInstance().saveRecordSession("Single Middle Player");
        }

    }
}
