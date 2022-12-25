package server.data.db;

import java.sql.SQLException;
import java.util.ArrayList;
import server.data.model.Player;
import server.data.model.ResponseModel;
import server.utils.Config;

public interface DBOperations {
     public ArrayList<Player> getOnlinePlayers() throws SQLException;
     public ArrayList<Player> getAllPlayers() throws SQLException;
     
     public int getCountPlayers() throws SQLException;
     public ResponseModel addPlayer(Player user) throws SQLException; 
     public ResponseModel isPlayer(String userName,String password) throws SQLException;
     
     public boolean updatePlayerStatus(boolean status,String userName) throws SQLException;
     public boolean updateAllPlayersStatus(boolean status) throws SQLException;
     
     public  boolean checkUsernameFound(String email) throws SQLException;
     

}
