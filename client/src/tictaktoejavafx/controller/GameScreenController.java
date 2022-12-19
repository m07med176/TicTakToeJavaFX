/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.ChooseGameScreenBase;
import static tictaktoejavafx.utils.Navigator.SNAKEGAME;

/**
 *
 * @author hp
 */
public class GameScreenController extends ChooseGameScreenBase {

    private Stage stage;

    public GameScreenController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void isTicTacToe(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.WELCOME, stage);

    }

    @Override
    protected void isSnake(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.SNAKEGAME, stage);

    }

}
