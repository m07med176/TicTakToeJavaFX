package tictaktoejavafx.data.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import tictaktoejavafx.utils.Config;


public  class HistoryDataModel {
    private String dateGame = new SimpleDateFormat(Config.DATETIME).format(new Date());
    private String playerXName;
    private String playerOName;
    private String winner;


    public HistoryDataModel() {
    }

    public HistoryDataModel(String playerXName, String playerOName,String winner) {
        this.playerXName = playerXName;
        this.playerOName = playerOName;
        this.winner = winner;
     
    }

    public void setDateGame(String dateGame) {
        this.dateGame = dateGame;
    }

    public void setPlayerXName(String playerXName) {
        this.playerXName = playerXName;
    }

    public void setPlayerOName(String playerOName) {
        this.playerOName = playerOName;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


    public String getDateGame() {
        return dateGame;
    }

    public String getPlayerXName() {
        return playerXName;
    }

    public String getPlayerOName() {
        return playerOName;
    }

    public String getWinner() {
        return winner;
    }

}
