package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.HistoryDataModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class GameBoardMultiController extends GameBoardScreenBase {
    private Stage stage;
    ArrayList<String> diagonals = new ArrayList<>();
    public char turn = 'X';
    Gson gson = new Gson();

    HistoryDataModel model;
    private boolean isRecorded;
    private RecordDataBasedSystem db;

    public GameBoardMultiController(Stage stage) {
        LocalMultiPlayer.setGameEnded(false);
        db = RecordDataBasedSystem.getInstance();
        RecordDataBasedSystem.newGame = true;
        this.stage = stage;

        label_player1.setText(Navigator.getPlayerOne());
        label_player2.setText(Navigator.getPlayerTwo());
        if(turn=='b'){
            turn='X';
        }
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        gameTurns(btn_Game_one,1);
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        gameTurns(btn_Game_four,4);
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        gameTurns(btn_Game_seven,7);
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        gameTurns(btn_Game_two,2);
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        gameTurns(btn_Game_three,3);
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        gameTurns(btn_Game_five,5);
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        gameTurns(btn_Game_six,6);
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        gameTurns(btn_Game_eight,8);
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        gameTurns(btn_Game_nine,9);
    }

    public void gameTurns(Button button,int degree) {

        if (turn == 'X') {

            button.setText("X");
          Navigator.setPlayerWinner(Navigator.getPlayerOne());
            turn = 'O';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

        } else {

            button.setText("O");
            Navigator.setPlayerWinner(Navigator.getPlayerTwo());
            button.setStyle("-fx-text-fill: Red;");
            turn = 'X';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

        }
        
         try {
              db.saveRecord(isRecorded, button, String.valueOf(degree));
         } catch (IOException ex) {
              UserMessage.showError(ex.getMessage());
         } catch (JsonIOException ex) {
              UserMessage.showError(ex.getMessage());
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

    @Override
    protected void isVideo(ActionEvent actionEvent) {
        isRecorded = !isRecorded;
        if(isRecorded){
        db.saveRecordSession("Multi Player");
        }

    }

}
