package server.data.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.data.db.DatabaseAccessLayer;

public class NetworkAccessLayer implements ServerCall {
     private final DatabaseAccessLayer db;
     public NetworkAccessLayer() throws SQLException {
          db = new DatabaseAccessLayer();
     }

     @Override
     public void invetation(String[] request, String currentID) throws SQLException,IOException {
          if (request.length == 2) {
               String senderID = request[1];
             if(!currentID.equals(senderID)){
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                            session.printStream.writeUTF(ServerCall.IVETATION_RECEIVE + "," + currentID);                        
                    }
               }
             }
          }
     }

     @Override
     public void confirm(String[] request, String currentID) throws SQLException,IOException {
          if (request.length == 2) {
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                            System.out.println("confirm "+ServerCall.CONFIRMATION_RECEIVE + "," + currentID);
                            session.printStream.writeUTF(ServerCall.CONFIRMATION_RECEIVE + "," + currentID);                         
                    }
               }
          }
     }

     @Override
     public void move(String[] request, String currentID) throws SQLException,IOException{
          if (request.length == 4) {
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                            session.printStream.writeUTF(ServerCall.MOVEMENT_RECEIVE + "," +currentID+","+request[2]+","+request[3]);
                    }
               }
          }
     }
     
     @Override
     public void onlinePlayers(String[] request, DataOutputStream response) throws SQLException,IOException {
          if (request.length == 2) {
                  response.writeUTF(ServerCall.PLAYER_LIST_RECEIVE+","+"Online players for Test purpose");
          }
     }

     @Override
     public String login(String[] request, DataOutputStream response) throws SQLException,IOException{
          String retVal = null;
          if (request.length == 3) {
              try {
                  retVal = db.isPlayer(request[1], request[2]);
                  if(retVal!=null)
                      response.writeUTF(ServerCall.LOGIN_RECEIVER+","+ retVal);
              } catch (IOException ex) {
                  Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          return retVal;
     }

     @Override
     public String register(String[] request, DataOutputStream response) throws SQLException,IOException {
          String retVal = null;
          if (request.length == 2) {
                  response.writeUTF(ServerCall.RREGISTER_RECEIVE+","+"Register for Test purpose");
          }
          return retVal;
     }

}
