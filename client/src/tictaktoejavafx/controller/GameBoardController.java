package tictaktoejavafx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.PlayerName;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardController extends GameBoardScreenBase {

    int count = 0;
    ArrayList arrlist = new ArrayList();
    ArrayList arrlistButtons = new ArrayList();

    private Stage stage;

    public GameBoardController(Stage stage) {
        this.stage = stage;
        addbuttonInList();
    }

    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        playerGame(btn_Game_one);

    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        playerGame(btn_Game_two);

    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
        playerGame(btn_Game_four);
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        playerGame(btn_Game_seven);
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        playerGame(btn_Game_three);
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        playerGame(btn_Game_five);
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        playerGame(btn_Game_six);
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        playerGame(btn_Game_eight);
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        playerGame(btn_Game_nine);
    }

    //-----------------------------------------
    void playerGame(Button button) {
        arrlistButtons.remove(button);
        count++;
        button.setDisable(true);
        if (count % 2 != 0) {
            button.setText("X");
            check();
            random();

        }
    }

    void check() {

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
                // result_label.setText("Player 1 is Winner");
                disableButton();
               PlayerName.setPlayerName("Player 1");

                saveData();
                playVideo();
            } else if (arrlist.get(i).equals("OOO")) {
                //  result_label.setText("Player 2 is Winner");
                disableButton();
                PlayerName.setPlayerName("Player 2");
                saveData();
                playVideo();
            }

        }
    }

    void saveData() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        HistoryController.saveFile(new PlayerModel(date.toString(), "Player 1", "PC", PlayerName.getPlayerName(), 1, 2));
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
                            check();
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
    //-----------------------------------------
}
