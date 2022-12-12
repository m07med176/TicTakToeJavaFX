package server.data.server;

import java.sql.SQLException;
import server.data.model.Player;

public class NetworkAccessLayer /*extends DatabaseAccessLayer*/ implements ServerCall{  

     public NetworkAccessLayer() throws SQLException {
     }

     @Override
     public void sendInvetation(String id) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public String receiveInvetation() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public String loign(String userName, String password) {
         //return super.isPlayer(userName, password);
         return "";
     }

     @Override
     public String register(Player player) {
//          return super.addPlayer(player);
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
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public int getMovement() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     
}
