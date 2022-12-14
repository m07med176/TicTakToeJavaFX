package tictaktoejavafx.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.RecordClass;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardRecordController extends GameBoardScreenBase{
    private Stage stage;
    Gson gson=new Gson();
    RecordClass rec=new RecordClass();
    ArrayList<String> rec2;
    Thread th=null;
    public GameBoardRecordController(Stage stage) {
        this.stage = stage;
        Read();
        rec2=rec.getRecord();
        
        th=new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    String temp="";
                    int index=0;
                    for(int i=0;i<rec2.size();i++){
                        System.out.println("I'm Running");
                        try {
                            temp=rec2.get(i);
                            index=Character.getNumericValue(temp.charAt(0));
                            //buttonAssin(index,temp.charAt(1));
                            final int lIndex=Character.getNumericValue(temp.charAt(0));
                            final char val=temp.charAt(1);
                            Platform.runLater(()->buttonAssin(lIndex,val));
                            th.sleep(1500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GameBoardRecordController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    th.sleep(2000);
                    Platform.runLater(() -> {
                        Navigator.navigate(Navigator.WELCOME, stage);
                    });
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameBoardRecordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        th.start();
        //Platform.runLater(th);
        
        
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
    public void Read(){
        try {
            Reader reader=Files.newBufferedReader(Paths.get("src/tictaktoejavafx/data/db/rec.json"));
            rec=gson.fromJson(reader, RecordClass.class);
        } catch (IOException ex) {
            Logger.getLogger(GameBoardRecordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void buttonAssin(int index,char val){
        
        switch(index){
            case 1: 
                    if(val=='X'){
                        btn_Game_one.setText("X");
                    }else{
                    
                        btn_Game_one.setText("O");
                    }
                    
                    btn_Game_one.setDisable(true);
                    break;
            case 2: 
                       if(val=='X'){
                        btn_Game_two.setText("X");
                    }else{
                    
                        btn_Game_two.setText("O");
                    }
                    btn_Game_two.setDisable(true);
                    break;
            case 3: 
                       if(val=='X'){
                        btn_Game_three.setText("X");
                    }else{
                    
                        btn_Game_three.setText("O");
                    }
                    btn_Game_three.setDisable(true);
                    break;
            case 4: 
                       if(val=='X'){
                        btn_Game_four.setText("X");
                    }else{
                    
                        btn_Game_four.setText("O");
                    }
                    btn_Game_four.setDisable(true);
                    break;
            case 5:
                       if(val=='X'){
                        btn_Game_five.setText("X");
                    }else{
                    
                        btn_Game_five.setText("O");
                    }
                    btn_Game_five.setDisable(true);
                    break;
            case 6:
                       if(val=='X'){
                        btn_Game_six.setText("X");
                    }else{
                    
                        btn_Game_six.setText("O");
                    }
                    btn_Game_six.setDisable(true);
                    break;
            case 7:
                       if(val=='X'){
                        btn_Game_seven.setText("X");
                    }else{
                    
                        btn_Game_seven.setText("O");
                    }
                    btn_Game_seven.setDisable(true);
                    break;
            case 8:
                       if(val=='X'){
                        btn_Game_eight.setText("X");
                    }else{
                    
                        btn_Game_eight.setText("O");
                    }
                    btn_Game_eight.setDisable(true);
                    break;
            case 9:
                       if(val=='X'){
                        btn_Game_nine.setText("X");
                    }else{
                    
                        btn_Game_nine.setText("O");
                    }
                    btn_Game_nine.setDisable(true);
                    break;
        }
    
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
   
    
}

  