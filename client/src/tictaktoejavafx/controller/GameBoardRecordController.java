package tictaktoejavafx.controller;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.data.model.RecordModelData;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardRecordScreenBase;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardRecordController extends GameBoardRecordScreenBase {

    private Stage stage;
    private RecordModelData model;
    Gson gson = new Gson();
    ArrayList<String> recordData;
    Thread th = null;

    public GameBoardRecordController(Stage stage,Object object) {
        this.stage = stage;
        this.model = (RecordModelData) object;
        recordData = model.getRecord();
        
        label_player1.setText(model.getPlayerOName());
        label_player2.setText(model.getPlayerXName());
        date_id.setText(model.getDateGame());
        type_id.setText(model.getType());
        
        th = new Thread(() -> {
            String temp = "";
            int index = 0;
            for (int i = 0; i < recordData.size(); i++) {
                try {
                    System.out.println("arraylist "+recordData.size());
                    temp = recordData.get(i);
                    index = Character.getNumericValue(temp.charAt(0));
                    final int lIndex = Character.getNumericValue(temp.charAt(0));
                    final char val = temp.charAt(1);
                    Platform.runLater(() -> buttonAssin(lIndex, val));
                    th.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoardRecordController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //th.sleep(2000);
            Platform.runLater(() -> {
                Navigator.navigate(Navigator.WELCOME, stage);
            });
        });
        th.start();
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {

    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {

    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
    }

    public void buttonAssin(int index, char val) {
        switch (index) {
            case 1:
                if (val == 'X') {
                    btn_Game_one.setText("X");
                } else {

                    btn_Game_one.setText("O");
                }
                btn_Game_one.setDisable(true);
                break;
            case 2:

                if (val == 'X') {
                    btn_Game_two.setText("X");
                } else {

                    btn_Game_two.setText("O");
                }
                btn_Game_two.setDisable(true);
                break;
            case 3:
                if (val == 'X') {
                    btn_Game_three.setText("X");
                } else {

                    btn_Game_three.setText("O");
                }
                btn_Game_three.setDisable(true);
                break;
            case 4:
                if (val == 'X') {
                    btn_Game_four.setText("X");
                } else {

                    btn_Game_four.setText("O");
                }
                btn_Game_four.setDisable(true);
                break;
            case 5:
                if (val == 'X') {
                    btn_Game_five.setText("X");
                } else {

                    btn_Game_five.setText("O");
                }
                btn_Game_five.setDisable(true);
                break;
            case 6:
                if (val == 'X') {
                    btn_Game_six.setText("X");
                } else {

                    btn_Game_six.setText("O");
                }
                btn_Game_six.setDisable(true);
                break;
            case 7:
                if (val == 'X') {
                    btn_Game_seven.setText("X");
                } else {

                    btn_Game_seven.setText("O");
                }
                btn_Game_seven.setDisable(true);
                break;
            case 8:
                if (val == 'X') {
                    btn_Game_eight.setText("X");
                } else {

                    btn_Game_eight.setText("O");
                }
                btn_Game_eight.setDisable(true);
                break;
            case 9:
                if (val == 'X') {
                    btn_Game_nine.setText("X");
                } else {

                    btn_Game_nine.setText("O");
                }
                btn_Game_nine.setDisable(true);
                break;
        }

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

}
