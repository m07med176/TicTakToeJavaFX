/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.data.model;



/**
 *
 * @author hp
 */
public class History {
    
    private int id;
    private int sessionsId;
    private int player;
    private int movement;
    
    public History() {
    }

    public History(int id, int sessionsId, int player, int movement) {
        this.id = id;
        this.sessionsId = sessionsId;
        this.player = player;
        this.movement = movement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(int sessionsId) {
        this.sessionsId = sessionsId;
    }

    

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    

    
    
}
