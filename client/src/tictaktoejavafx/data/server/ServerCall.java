package tictaktoejavafx.data.server;

import java.util.ArrayList;
import tictaktoejavafx.data.model.Player;

public interface ServerCall {
     /**
     * @param id of second Player
     */
     public void sendInvetation(String id);
     
     /**
      * 
      * @return String id of Player
      */
     public String receiveInvetation();
     
     public ArrayList<Player> getOnlinePlayers();
     public int getCountPlayers();
     public boolean updatePlayerStatus(boolean status);
     
     public void setMovement(int btnID,char type,int userId);
     public int getMovement();
}
