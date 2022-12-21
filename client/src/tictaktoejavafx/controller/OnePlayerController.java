package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.OnePlayerBase;

public class OnePlayerController extends OnePlayerBase{
     private Stage stage;

     public OnePlayerController(Stage stage) {
          this.stage = stage;
     }
     

     protected void isStartGame(ActionEvent actionEvent) {
          // TODO Validation 
          
          // fetch data 
          String name = player_name.getText().trim();
          if(name.isEmpty()){
               player_name.requestFocus();
          }
          else{
              Navigator.setPlayerOne(name);
              Navigator.setPlayerTwo("PC");
              Navigator.navigate(Navigator.CHOOSEDIFF, stage);

          }
          
     }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.WELCOME, stage);
     }

    @Override
    protected void isSingle(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.GAMEBOARD, stage);
    }
     
}
