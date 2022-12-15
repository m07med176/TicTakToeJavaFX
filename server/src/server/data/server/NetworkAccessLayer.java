package server.data.server;

import java.sql.SQLException;
import server.data.db.DatabaseAccessLayer;

public class NetworkAccessLayer implements ServerCall{  
     private final DatabaseAccessLayer databaseAccessLayer;
     public NetworkAccessLayer() throws SQLException {
          databaseAccessLayer = new DatabaseAccessLayer();
     }

     @Override
     public void sendInvetation(String id) {

     }

     @Override
     public String receiveInvetation() {
          return "";
     }


     @Override
     public String sendPlayers() {
//          ArrayList<Player> players = super.getOnlinePlayers();
//          System.out.print("Numbers of online players: "+String.valueOf(players.size()));
          return "";
     }

     @Override
     public void setMovement(int btnID, char type, int userId) {
               
     }

     @Override
     public int getMovement() {
              return 0;
     }
     
}
