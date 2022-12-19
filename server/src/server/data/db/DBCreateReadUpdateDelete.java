package server.data.db;

import java.sql.SQLException;
import java.util.ArrayList;
import server.data.model.Player;

public interface DBCreateReadUpdateDelete {
     public ArrayList<Player> getOnlinePlayers() throws SQLException;
     public int getCountPlayers() throws SQLException;
     public String addPlayer(Player user) throws SQLException; 
     public boolean updatePlayerStatus(boolean status,int id) throws SQLException;
     public String isPlayer(String userName,String password) throws SQLException; // login funciton
}
