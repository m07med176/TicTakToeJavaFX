package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.TwoPlayerBase;

public class TwoPlayerController extends TwoPlayerBase{

     private Stage stage;
     public TwoPlayerController(Stage stage) {
          this.stage = stage;
     }
     

     @Override
     protected void isStartGame(ActionEvent actionEvent) {          
          String playerOne = player_One.getText().trim();
          String playerTwo = Player_two.getText().trim();
          if(playerOne.isEmpty()){
               player_One.requestFocus();
          }
          
          else if(playerTwo.isEmpty()){
               Player_two.requestFocus();
          }
          else{
               Navigator.setPlayerOne(playerOne);
               Navigator.setPlayerTwo(playerTwo);
               Navigator.setPlayerStage(Navigator.GAMEBOARD_MULTI);
               Navigator.navigate(Navigator.GAMEBOARD_MULTI, stage);
          }
     }
     
    protected void isBack(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.WELCOME);
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override

    protected void onBackClicked(ActionEvent actionEvent) {
        Navigator.setPlayerStage(Navigator.WELCOME);
        Navigator.navigate(Navigator.WELCOME, stage);
    }
     
}
