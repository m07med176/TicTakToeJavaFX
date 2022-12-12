package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardRecordController extends GameBoardScreenBase{
    private Stage stage;
    //ArrayList<String> diagonals=new ArrayList<>();
    //public static char turn='X';

    public GameBoardRecordController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        //gameTurns(btn_Game_one);
        
        
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
         //gameTurns(btn_Game_four);
        
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        //gameTurns(btn_Game_seven);
        
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        //gameTurns(btn_Game_two);
       
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        //gameTurns(btn_Game_three);
       
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
          //gameTurns(btn_Game_five);
       
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        //gameTurns(btn_Game_six);
        
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        //gameTurns(btn_Game_eight);
        
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        //gameTurns(btn_Game_nine);
        
        
    }
    /*public void gameTurns(Button button){
    
        if(turn=='X'){
        
            button.setText("X");
            turn='O';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
                    
        }else{
        
            button.setText("O");
            turn='X';
            button.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    
    }*/
    /*public void diagonalFiller(){
        diagonals.add(btn_Game_one.getText()+btn_Game_two.getText()+btn_Game_three.getText());
        diagonals.add(btn_Game_four.getText()+btn_Game_five.getText()+btn_Game_six.getText());
        diagonals.add(btn_Game_seven.getText()+btn_Game_eight.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText()+btn_Game_four.getText()+btn_Game_seven.getText());
        diagonals.add(btn_Game_two.getText()+btn_Game_five.getText()+btn_Game_eight.getText());
        diagonals.add(btn_Game_three.getText()+btn_Game_six.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText()+btn_Game_five.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_three.getText()+btn_Game_five.getText()+btn_Game_seven.getText());
    
    }*/

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          new UserMessage().display(Config.EXIT_MSG, new AlertAction(){
               @Override
               public void sendOk() {
                    Navigator.navigate(Navigator.WELCOME, stage);
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          },Alert.AlertType.CONFIRMATION);
          
     }
   
    
}