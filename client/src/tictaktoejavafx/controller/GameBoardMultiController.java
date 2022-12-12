package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardMultiController extends GameBoardScreenBase{
    private Stage stage;
    ArrayList<String> diagonals=new ArrayList<>();
    public static char turn='X';

    public GameBoardMultiController(Stage stage) {
        this.stage = stage;
        label_player1.setText(Navigator.getPlayerOne());
        label_player2.setText(Navigator.getPlayerTwo());
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        gameTurns(btn_Game_one);
        
        
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
         gameTurns(btn_Game_four);
        
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        gameTurns(btn_Game_seven);
        
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        gameTurns(btn_Game_two);
       
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        gameTurns(btn_Game_three);
       
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
          gameTurns(btn_Game_five);
       
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        gameTurns(btn_Game_six);
        
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        gameTurns(btn_Game_eight);
        
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        gameTurns(btn_Game_nine);
        
        
    }
    public void gameTurns(Button button){
    
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
    
    }
    public void diagonalFiller(){
        diagonals.add(btn_Game_one.getText()+btn_Game_two.getText()+btn_Game_three.getText());
        diagonals.add(btn_Game_four.getText()+btn_Game_five.getText()+btn_Game_six.getText());
        diagonals.add(btn_Game_seven.getText()+btn_Game_eight.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText()+btn_Game_four.getText()+btn_Game_seven.getText());
        diagonals.add(btn_Game_two.getText()+btn_Game_five.getText()+btn_Game_eight.getText());
        diagonals.add(btn_Game_three.getText()+btn_Game_six.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_one.getText()+btn_Game_five.getText()+btn_Game_nine.getText());
        diagonals.add(btn_Game_three.getText()+btn_Game_five.getText()+btn_Game_seven.getText());
    
    }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.WELCOME, stage);
     }
    
}
