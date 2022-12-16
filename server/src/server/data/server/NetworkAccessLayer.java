package server.data.server;

import java.io.PrintStream;
import java.sql.SQLException;
import server.data.db.DatabaseAccessLayer;

public class NetworkAccessLayer implements ServerCall {
     private final DatabaseAccessLayer db;
     public NetworkAccessLayer() throws SQLException {
          db = new DatabaseAccessLayer();
     }

     @Override
     public void invetation(String[] request, String currentID) {
          if (request.length == 2) {
               // TODO check and Test invetation message 
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                         session.printStream.println(ServerCall.IVETATION_RECEIVE + "," + currentID);
                    }
               }
          }
     }

     @Override
     public void confirm(String[] request, String currentID) {
          if (request.length == 2) {
               // TODO check and Test confirm message
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                         session.printStream.println(ServerCall.CONFIRMATION_RECEIVE + "," + currentID);
                    }
               }
          }
     }

     @Override
     public void move(String[] request, String currentID) {
          if (request.length == 2) {
               // TODO check and Test movement of palyer
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                         session.printStream.println(ServerCall.MOVEMENT_RECEIVE + "," +currentID);
                    }
               }
          }
     }

     
     @Override
     public void onlinePlayers(String[] request, PrintStream response) {
          if (request.length == 2) {
               // TODO send PLAYER_LIST_RECEIVE and arraylist json of online players from db [CHECK and TEST]
               response.println(ServerCall.PLAYER_LIST_RECEIVE+","+"Online players for Test purpose");
          }
     }

     @Override
     public String login(String[] request, PrintStream response) {
          String retVal = null;
          if (request.length == 3) {
               // TODO send LOGIN_RECEIVER and id from user if not nul [CHECK and TEST]
               retVal = db.isPlayer(request[1], request[2]);
               if(retVal!=null)
                    response.println( ServerCall.LOGIN_RECEIVER+","+ retVal);
          }
          return retVal;
     }

     @Override
     public String register(String[] request, PrintStream response) {
          String retVal = null;
          if (request.length == 2) {
               // TODO send RREGISTER_RECEIVE and send Register as json model [CHECK and TEST]
               response.println(ServerCall.RREGISTER_RECEIVE+","+"Register for Test purpose");
          }
          return retVal;
     }

}
