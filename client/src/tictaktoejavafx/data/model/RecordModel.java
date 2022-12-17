package tictaktoejavafx.data.model;

import java.util.ArrayList;

public class RecordModel {

    private int id;
    private int sessionsId;
    private int player;
    private int movement;
    private ArrayList<String> record = new ArrayList<>();

    public RecordModel() {
    }

    public RecordModel(int id, int sessionsId, int player, int movement) {
        this.id = id;
        this.sessionsId = sessionsId;
        this.player = player;
        this.movement = movement;
    }

    public void add(String val) {
        record.add(val);
    }

    public ArrayList getRecord() {
        return record;
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
