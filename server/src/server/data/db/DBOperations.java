package server.data.db;

import java.sql.SQLException;
import java.util.ArrayList;
import server.data.model.Player;

public interface DBOperations {
     public ArrayList<Player> getOnlinePlayers() throws SQLException;
     public ArrayList<Player> getAllPlayers() throws SQLException;
     
     public int getCountPlayers() throws SQLException;
     public ArrayList<Player> addPlayer(Player user) throws SQLException; 
     public ArrayList<Player> isPlayer(String userName,String password) throws SQLException;
     
     public boolean updatePlayerStatus(boolean status,String userName) throws SQLException;
     public boolean updateAllPlayersStatus(boolean status) throws SQLException;
}
