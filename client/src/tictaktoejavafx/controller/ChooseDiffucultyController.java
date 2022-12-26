package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.ChooseDiffucultyScreenBase;

public class ChooseDiffucultyController extends ChooseDiffucultyScreenBase{
    private Stage stage;

    public ChooseDiffucultyController(Stage stage) {
        this.stage = stage;
    }
    
    
    @Override
    protected void isEasyMode(ActionEvent actionEvent) {
       Navigator.setPlayerStage(Navigator.GAMEBOARD);
       Navigator.navigate(Navigator.GAMEBOARD, stage);

    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.GAMEBOARDHARD);
        Navigator.navigate(Navigator.GAMEBOARDHARD, stage);
    }

    @Override
    protected void isBack(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.WELCOME); 
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    
}


    

