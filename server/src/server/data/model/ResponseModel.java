package server.data.model;

import java.util.ArrayList;

public class ResponseModel {

     private String username;
     private int id;
     private ArrayList<Player> playerList;

     public ResponseModel() {
          id = -1;
          username = "";
          playerList = new ArrayList<>();
     }

     public ResponseModel(String username, int id, ArrayList<Player> playerList) {
          this.username = username;
          this.id = id;
          this.playerList = playerList;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public ArrayList<Player> getPlayerList() {
          return playerList;
     }

     public void setPlayerList(ArrayList<Player> playerList) {
          this.playerList = playerList;
     }

}
