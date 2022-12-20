package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AlertAction;
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
    protected void isMiddleMode(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.GAMEBOARDMIDDLE, stage);
      
    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
       
        Navigator.navigate(Navigator.GAMEBOARDHARD, stage);
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
    }


    

