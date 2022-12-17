/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.data.model;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class RecordModelData {
    private String dateGame;
    private String playerXName;
    private String playerOName;
    
    private ArrayList<String> record = new ArrayList<>();

    public RecordModelData() {
    }

    public RecordModelData(String dateGame, String playerXName, String playerOName) {
        this.dateGame = dateGame;
        this.playerXName = playerXName;
        this.playerOName = playerOName;
    }
    
    
    public void add(String val){
        record.add(val);
        
    }
    public ArrayList getRecord(){
        return record;
    }
    
    public String getDateGame() {
        return dateGame;
    }

    public void setDateGame(String dateGame) {
        this.dateGame = dateGame;
    }

    public String getPlayerXName() {
        return playerXName;
    }

    public void setPlayerXName(String playerXName) {
        this.playerXName = playerXName;
    }

    public String getPlayerOName() {
        return playerOName;
    }

    public void setPlayerOName(String playerOName) {
        this.playerOName = playerOName;
    }

    

    
}
