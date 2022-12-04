package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.view.ChooseDiffucultyScreenBase;

public class ChooseDiffucultyController extends ChooseDiffucultyScreenBase{
    private Stage stage;

    public ChooseDiffucultyController(Stage stage) {
        this.stage = stage;
    }
    
    
    @Override
    protected void isEasyMode(ActionEvent actionEvent) {
        System.out.println("isEasyMode");
    }

    @Override
    protected void isMiddleMode(ActionEvent actionEvent) {
        System.out.println("isMiddleMode");
    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
        System.out.println("isHardMode");
    }

    @Override
    protected void isStartGame(ActionEvent actionEvent) {
        System.out.println("isStartGame");
    }
    
}
