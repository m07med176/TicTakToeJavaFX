package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardController_MULTI extends GameBoardScreenBase{
    private Stage stage;
    ArrayList<String> diagonals=new ArrayList<>();
    public static char turn='X';

    public GameBoardController_MULTI(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        System.out.println("isGameOne");
        if(turn=='X'){
        
            btn_Game_one.setText("X");
            turn='O';
            btn_Game_one.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_one.setText("O");
            turn='X';
            btn_Game_one.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
        
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
         System.out.println("isGameFour");
         if(turn=='X'){
        
            btn_Game_four.setText("X");
            turn='O';
            btn_Game_four.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_four.setText("O");
            turn='X';
            btn_Game_four.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        System.out.println("isGameSeven");
        if(turn=='X'){
        
            btn_Game_seven.setText("X");
            turn='O';
            btn_Game_seven.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_seven.setText("O");
            turn='X';
            btn_Game_seven.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        System.out.println("isGameTwo");
         if(turn=='X'){
        
            btn_Game_two.setText("X");
            turn='O';
            btn_Game_two.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_two.setText("O");
            turn='X';
            btn_Game_two.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        System.out.println("isGameThree");
         if(turn=='X'){
        
            btn_Game_three.setText("X");
            turn='O';
            btn_Game_three.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_three.setText("O");
            turn='X';
            btn_Game_three.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
        System.out.println("isGameFive");
        if(turn=='X'){
        
            btn_Game_five.setText("X");
            turn='O';
            btn_Game_five.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_five.setText("O");
            turn='X';
            btn_Game_five.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        System.out.println("isGameSix");
        if(turn=='X'){
        
            btn_Game_six.setText("X");
            turn='O';
            btn_Game_six.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_six.setText("O");
            turn='X';
            btn_Game_six.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        System.out.println("isGameEight");
        if(turn=='X'){
        
            btn_Game_eight.setText("X");
            turn='O';
            btn_Game_eight.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_eight.setText("O");
            turn='X';
            btn_Game_eight.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
            
        }
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        System.out.println("isGameNine");
        if(turn=='X'){
        
            btn_Game_nine.setText("X");
            turn='O';
            btn_Game_nine.setDisable(true);
            diagonalFiller();
            LocalMultiPlayer.localMulti(diagonals, stage);
            LocalMultiPlayer.drawChecker(stage);
        
        }else{
        
            btn_Game_nine.setText("O");
            turn='X';
            btn_Game_nine.setDisable(true);
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
    
}
