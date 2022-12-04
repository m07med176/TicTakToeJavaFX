/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.utils;

/**
 *
 * @author Sonic
 */
public class PlayerName {
    private static String playerName="";

    public static String getPlayerString() {
        return playerName;
    }

    public static void setPlayerString(String playerString) {
        PlayerName.playerName = playerString;
    }
    
    
    
}
