/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.data.model;

/**
 *
 * @author Ahmed
 */
public  class PlayerModel {
    private String dateGame;
    private String playerXName;
    private String playerOName;
    private String winner;


    public PlayerModel() {
    }

    public PlayerModel(String dateGame, String playerXName, String playerOName) {
        this.dateGame = dateGame;
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
