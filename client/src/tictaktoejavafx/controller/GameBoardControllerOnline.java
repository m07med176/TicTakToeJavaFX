package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardControllerOnline extends GameBoardScreenBase {

    private static Stage stage;
    public ArrayList<String> diagonals = new ArrayList<>();
    public static char turn = 'X';
    //ServerConnection connection;
    public static ArrayList<Button> arrlistButtons = new ArrayList();
    public static ArrayList<Button> arrlistButtons2 = new ArrayList();
    boolean start = true;
    public static Button button;

    public GameBoardControllerOnline(Stage stage) {
        this.stage = stage;
        addbuttonInList();
        addAllbuttonInList();
        label_player1.setText(Navigator.getPlayerOne());
        label_player2.setText(Navigator.getPlayerTwo());
        //connection=ServerConnection.getInstance(stage);
        if (!Navigator.isStartGame()) {

            Navigator.setSetX(false);

        }
        this.stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                ServerConnection.closeThread();
            } catch (IOException ex) {
                new UserMessage().display(ex.getMessage(), new AlertAction() {
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

        //button=btn_Game_one;
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        gameTurns(btn_Game_four);
        sendMove(4, btn_Game_four.getText());

        //button=btn_Game_four;
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        gameTurns(btn_Game_seven);
        sendMove(7, btn_Game_seven.getText());

        //button=btn_Game_seven;
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        gameTurns(btn_Game_two);
        sendMove(2, btn_Game_two.getText());

        //button=btn_Game_two;
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        gameTurns(btn_Game_three);
        sendMove(3, btn_Game_three.getText());

        //button=btn_Game_three;
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        gameTurns(btn_Game_five);
        sendMove(5, btn_Game_five.getText());

        //button=btn_Game_five;
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        gameTurns(btn_Game_six);
        sendMove(6, btn_Game_six.getText());

        // button=btn_Game_six;
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        gameTurns(btn_Game_eight);
        sendMove(8, btn_Game_eight.getText());

        //button=btn_Game_eight;
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        gameTurns(btn_Game_nine);
        sendMove(9, btn_Game_nine.getText());

        //button=btn_Game_nine;
    }

    public void gameTurns(Button button) {
        arrlistButtons.remove(button);
        if (Navigator.isSetX()) {

            button.setText("X");
            //turn='O';
            //Navigator.setSetX(false);
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

        } else {

            button.setText("O");
            //Navigator.setSetX(true);
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);

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

    public static void enableButton() {
        for (int i = 0; i < arrlistButtons.size(); i++) {

            button = (Button) arrlistButtons.get(i);
            if (button != null && !button.isDisable()) {

                button.setDisable(false);

            }

        }

    }

    public static void disableButton() {
        for (int i = 0; i < arrlistButtons.size(); i++) {

            button = (Button) arrlistButtons.get(i);
            if (button != null && !button.isDisable()) {

                button.setDisable(true);

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

    }

}
