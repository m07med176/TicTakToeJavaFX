package server.data.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import javafx.application.Platform;

public class SocketSession extends Thread {

     private final DataInputStream dataInputStream;
     public DataOutputStream printStream;
     public String UID;
     String playerO;
     String ownerSocket;

     private final NetworkAccessLayer networkOperations;
     private ServerCallBack serverCallBack;
     
     public SocketSession(Socket socket, NetworkAccessLayer networkOperations,ServerCallBack serverCallBack) throws IOException {
          this.serverCallBack = serverCallBack;
          this.networkOperations = networkOperations;
          dataInputStream = new DataInputStream(socket.getInputStream());
          printStream = new DataOutputStream(socket.getOutputStream());
          start();
          
     }

     @Override
     public void run() {
         boolean flag=true;
          while (flag) {
               try {
                    String response = dataInputStream.readUTF();
                    System.out.println("Index  " + response);
                    requestNavigator(response);
               } catch (IOException ex) {
                   flag=false;
                    Platform.runLater(() -> {
                        serverCallBack.serverException(ex);
                        
                    });
               } catch (SQLException ex) {
                    serverCallBack.databaseException(ex);
               }
          }
     }

     private /*synchronized*/ void requestNavigator(String response) throws SQLException, IOException {
          if (response != null && !response.isEmpty()) {
              System.out.println(response);
               String[] data = response.split(ServerCall.DELIMETER);
               switch (data[0]) {
                    case ServerCall.LOGIN_SEND:
                         UID  = networkOperations.login(data, printStream);
                         serverCallBack.requestUpdateDatabase();
                         break;

                    case ServerCall.RREGISTER_SEND:
                         UID = networkOperations.register(data, printStream); 
                         serverCallBack.requestUpdateDatabase();
                         break;

                    case ServerCall.PLAYER_LIST_SEND:
                         networkOperations.onlinePlayers(data, printStream);
                         break;

                    case ServerCall.MOVEMENT_SEND:
                         networkOperations.move(data, UID);
                         break;
                         
                    case ServerCall.IVETATION_SEND:
                         networkOperations.invetation(data, UID);
                         break;

                    case ServerCall.CONFIRMATION_SEND:
                         networkOperations.confirm(data, UID);
                         break;
               }
          }
     }
}