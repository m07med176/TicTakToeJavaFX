package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.ChooseGameScreenBase;

public class GameScreenController extends ChooseGameScreenBase {

    private Stage stage;

    public GameScreenController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void isTicTacToe(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.WELCOME);
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override
    protected void isSnake(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.SNAKEGAME);
        Navigator.navigate(Navigator.SNAKEGAME, stage);

    }

}
