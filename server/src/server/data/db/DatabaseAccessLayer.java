package server.data.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import server.data.model.Player;

public abstract class DatabaseAccessLayer implements DatabaseCRUD{

     Connection con;
     public DatabaseAccessLayer() throws SQLException {
          con = DataBaseConnection.getConnection();
     }

     @Override
     public ArrayList<Player> getOnlinePlayers() {
          // TODO get online users from database
          
          return new ArrayList();
     }

     @Override
     public int getCountPlayers() {
          // TODO get numbers of users from database
          return 0;
     }

     @Override
     public String addPlayer(Player user) {
          // TODO add new row of player in database
          return "";
     }

     @Override
     public boolean updatePlayerStatus(boolean status) {
          // TODO update status of player in database
          return false;
     }

     @Override
     public String isPlayer(String userName,String password) {
         
          // TODO query of player and get its id or null
          return null;
     }

     @Override
     public void clearAll() {
          // TODO delete database
     }
     
}
