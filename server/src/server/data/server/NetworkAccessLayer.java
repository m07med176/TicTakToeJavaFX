package server.data.server;

import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;

public class NetworkAccessLayer implements ServerCall {

     private final DatabaseAccessLayer db;

     public NetworkAccessLayer() throws SQLException {
          db = new DatabaseAccessLayer();
     }

     @Override
     public void invetation(String[] request, String currentID) throws SQLException, IOException {
          if (request.length == 2) {
               String senderID = request[1];
               if (!currentID.equals(senderID)) {
                    for (SocketSession session : ServerManager.sessionHolder) {
                         if (session.UID.equals(senderID)) {
                              session.printStream.writeUTF(ServerCall.IVETATION_RECEIVE + ServerCall.DELIMETER + currentID);
                         }
                    }
               }
          }
     }

     @Override
     public void confirm(String[] request, String currentID) throws SQLException, IOException {
          if (request.length == 2) {
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                         session.printStream.writeUTF(ServerCall.CONFIRMATION_RECEIVE + ServerCall.DELIMETER + currentID);
                    }
               }
          }
     }

     @Override
     public void move(String[] request, String currentID) throws SQLException, IOException {
          if (request.length == 4) {
               String senderID = request[1];
               for (SocketSession session : ServerManager.sessionHolder) {
                    if (session.UID.equals(senderID)) {
                         session.printStream.writeUTF(ServerCall.MOVEMENT_RECEIVE + ServerCall.DELIMETER + currentID + ServerCall.DELIMETER + request[2] + ServerCall.DELIMETER + request[3]);
                    }
               }
          }
     }

     @Override
     public void onlinePlayers(String[] request, DataOutputStream response) throws SQLException, IOException {
          if (request.length == 2) {
               ArrayList<Player> onlinePlayers = db.getOnlinePlayers();
               if (!onlinePlayers.isEmpty()) {
                    response.writeUTF(ServerCall.PLAYER_LIST_RECEIVE + ServerCall.DELIMETER + "Online players for Test purpose");
               } else {
                    response.writeUTF(ServerCall.PLAYER_LIST_RECEIVE + ServerCall.DELIMETER + "0");
               }
          }
     }

     @Override
     public String login(String[] request, DataOutputStream response) throws SQLException, IOException {
          String retVal = request[1];
          if (request.length == 3) {
               ArrayList<Player> playerList = db.isPlayer(request[1], request[2]);
               Gson gson = new Gson();
               retVal = gson.toJson(playerList);
               if (!playerList.isEmpty()) {
                    response.writeUTF(ServerCall.LOGIN_RECEIVER + ServerCall.DELIMETER + retVal);
               } else {
                    response.writeUTF(ServerCall.LOGIN_RECEIVER + ServerCall.DELIMETER + "0");
               }
          }
          return retVal;
     }

     @Override
     public String register(String[] request, DataOutputStream response) throws SQLException, IOException {
          String retVal = request[1];
          if (request.length == 4) {
               ArrayList<Player> playerList = db.addPlayer(new Player(request[1], request[2], request[3]));
               Gson gson = new Gson();
               retVal = gson.toJson(playerList);
               if (!playerList.isEmpty()) {
                    response.writeUTF(ServerCall.RREGISTER_RECEIVE + ServerCall.DELIMETER + retVal);
               } else {
                    response.writeUTF(ServerCall.RREGISTER_RECEIVE + ServerCall.DELIMETER + "0");
               }
          }
          return retVal;
     }

}
