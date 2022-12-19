package tictaktoejavafx.data.model;

import java.util.ArrayList;

public class RecordModelData {
    private String dateGame;
    private String playerXName;
    private String playerOName;
    private String type;
   private ArrayList<String> record = new ArrayList<>();

    public RecordModelData() {
    }

    public RecordModelData(String dateGame, String playerXName, String playerOName, String type) {
        this.dateGame = dateGame;
        this.playerXName = playerXName;
        this.playerOName = playerOName;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    
}
