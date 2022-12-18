package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardControllerOnline extends GameBoardScreenBase{
    private Stage stage;
    ArrayList<String> diagonals=new ArrayList<>();
    public static char turn='X';
    ServerConnection connection;
    ArrayList arrlistButtons=new ArrayList();
    boolean start=true;
    
    public GameBoardControllerOnline(Stage stage) {
        try {
            
            this.stage = stage;
            addbuttonInList();
            label_player1.setText(Navigator.getPlayerOne());
            label_player2.setText(Navigator.getPlayerTwo());
            connection=ServerConnection.createInstance(stage);
            
            if(!Navigator.isStartGame()){
            
                disableButton(true);
                
            }
            readMove();
        } catch (IOException ex) {
            Logger.getLogger(GameBoardControllerOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
        gameTurns(btn_Game_one);
        sendMove(1, btn_Game_one.getText());
        
        
        
        
    }

    @Override
    protected void isGameFour(ActionEvent actionEvent) {
         gameTurns(btn_Game_four);
         sendMove(4, btn_Game_four.getText());
         
        
    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        gameTurns(btn_Game_seven);
        sendMove(7, btn_Game_seven.getText());
        
    }

    @Override
    protected void isGameTwo(ActionEvent actionEvent) {
        gameTurns(btn_Game_two);
       sendMove(2, btn_Game_two.getText());
       
    }

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
        gameTurns(btn_Game_three);
       sendMove(3, btn_Game_three.getText());
       
    }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
          gameTurns(btn_Game_five);
       sendMove(5, btn_Game_five.getText());
       
    }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
        gameTurns(btn_Game_six);
        sendMove(6, btn_Game_six.getText());
        
    }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
        gameTurns(btn_Game_eight);
        sendMove(8, btn_Game_eight.getText());
        
    }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        gameTurns(btn_Game_nine);
        sendMove(9, btn_Game_nine.getText());
        
        
    }
    public void gameTurns(Button button){
        arrlistButtons.remove(button);
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
     void disableButton(boolean flag) {
        for(int i=0;i<arrlistButtons.size();i++){
        
            Button button = (Button) arrlistButtons.get(i);
            if (button != null && !button.isDisable()){
            
                button.setDisable(flag);
            
            }
        
        } 
        
    }
     void addbuttonInList() {
        arrlistButtons.add(btn_Game_one);
        arrlistButtons.add(btn_Game_two);
        arrlistButtons.add(btn_Game_three);
        arrlistButtons.add(btn_Game_four);
        arrlistButtons.add(btn_Game_five);
        arrlistButtons.add(btn_Game_six);

        arrlistButtons.add(btn_Game_seven);
        arrlistButtons.add(btn_Game_eight);
        arrlistButtons.add(btn_Game_nine);
    }
     public void sendMove(int val,String move){
         String msg="";
         if(Navigator.isStartGame()){
             msg=ServerCall.MOVEMENT_SEND+","+Navigator.getPlayerTwo()+","+Integer.toString(val)+","+move;
         }else{
             msg=ServerCall.MOVEMENT_SEND+","+Navigator.getPlayerOne()+","+Integer.toString(val)+","+move;
         }
         
         connection.sendMessage(msg);
         disableButton(true);
         readMove();
     
     }
     public void readMove(){
         connection.readThread();
         System.out.println("readinggggggggggggg");
         disableButton(false);
         System.out.println("readinggggggggggggg");
         /*while (!Navigator.isTurnEnded()) {
             
             
         }*/
         if(Navigator.getBoardMove()!=null&&Navigator.getButtonNumber()!=null){
         switch(Integer.parseInt(Navigator.getButtonNumber())){
             case 1:
                    btn_Game_one.setText(Navigator.getBoardMove());
                    break;
            case 2:
                    btn_Game_two.setText(Navigator.getBoardMove());
                    break;        
            case 3:
                    btn_Game_three.setText(Navigator.getBoardMove());
                    break;
            case 4:
                    btn_Game_four.setText(Navigator.getBoardMove());
                    break;
            case 5:
                    btn_Game_five.setText(Navigator.getBoardMove());
                    break;        
            case 6:
                    btn_Game_six.setText(Navigator.getBoardMove());
                    break;
            case 7:
                    btn_Game_seven.setText(Navigator.getBoardMove());
                    break;
            case 8:
                    btn_Game_eight.setText(Navigator.getBoardMove());
                    break;        
            case 9:
                    btn_Game_nine.setText(Navigator.getBoardMove());
                    break;        
         
         }

         }
             Navigator.setTurnEnded(false);
     }
     
    
}
