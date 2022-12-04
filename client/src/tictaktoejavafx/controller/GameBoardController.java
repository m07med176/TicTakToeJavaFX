package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardController extends GameBoardScreenBase{
    private Stage stage;

    public GameBoardController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        System.out.println("isGameOne");
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
         System.out.println("isGameFour");
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        System.out.println("isGameSeven");
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        System.out.println("isGameTwo");
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        System.out.println("isGameThree");
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        System.out.println("isGameFive");
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        System.out.println("isGameSix");
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        System.out.println("isGameEight");
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        System.out.println("isGameNine");
    }
    
}
