
package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.PlayerName;
import tictaktoejavafx.view.GameBoardScreenBase;

/**
 *
 * @author Ahmed
 */
public class GameBoardControllerMiddle extends GameBoardScreenBase {

    int count = 0;
    ArrayList arrlist = new ArrayList();
    private Stage stage;

    public GameBoardControllerMiddle(Stage stage) {
        this.stage = stage;
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
}