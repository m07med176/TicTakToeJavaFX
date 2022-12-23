package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictaktoejavafx.utils.CallBackAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.ChooseDiffucultyScreenBase;

public class ChooseDiffucultyController extends ChooseDiffucultyScreenBase{
    private Stage stage;

    public ChooseDiffucultyController(Stage stage) {
        this.stage = stage;
    }
    
    
    @Override
    protected void isEasyMode(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.GAMEBOARD, stage);

    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
       
        Navigator.navigate(Navigator.GAMEBOARDHARD, stage);
    }

    @Override
    protected void isBack(ActionEvent actionEvent) {
         Navigator.navigate(Navigator.WELCOME, stage);
    }

    
}


    

