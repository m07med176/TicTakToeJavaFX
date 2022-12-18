package server.data.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
     public void invetation(String[] request, String currentID) {
          if (request.length == 2) {
               // TODO check and Test invetation message 
               String senderID = request[1];
             if(!currentID.equals(senderID)){
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                        try {
                            session.printStream.writeUTF(ServerCall.IVETATION_RECEIVE + "," + currentID);
                        } catch (IOException ex) {
                            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
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
                        try {
                            System.out.println("confirm "+ServerCall.CONFIRMATION_RECEIVE + "," + currentID);
                            session.printStream.writeUTF(ServerCall.CONFIRMATION_RECEIVE + "," + currentID);
                        } catch (IOException ex) {
                            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                    }
               }
          }
     }

     @Override
     public void move(String[] request, String currentID) {
          if (request.length == 4) {
               // TODO check and Test movement of palyer
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                        try {
                            System.out.println("I sent to him");
                            session.printStream.writeUTF(ServerCall.MOVEMENT_RECEIVE + "," +currentID+","+request[2]+","+request[3]);
                        } catch (IOException ex) {
                            Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
               }
          }
     }

     
     @Override
     public void onlinePlayers(String[] request, DataOutputStream response) {
          if (request.length == 2) {
              try {
                  // TODO send PLAYER_LIST_RECEIVE and arraylist json of online players from db [CHECK and TEST]
                  response.writeUTF(ServerCall.PLAYER_LIST_RECEIVE+","+"Online players for Test purpose");
              } catch (IOException ex) {
                  Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
     }

     @Override
     public String login(String[] request, DataOutputStream response) {
          String retVal = null;
          if (request.length == 3) {
              try {
                  // TODO send LOGIN_RECEIVER and id from user if not nul [CHECK and TEST]
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
     public String register(String[] request, DataOutputStream response) {
          String retVal = null;
          if (request.length == 2) {
              try {
                  // TODO send RREGISTER_RECEIVE and send Register as json model [CHECK and TEST]
                  response.writeUTF(ServerCall.RREGISTER_RECEIVE+","+"Register for Test purpose");
              } catch (IOException ex) {
                  Logger.getLogger(NetworkAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          return retVal;
     }

}
