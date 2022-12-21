package server.data.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

public class SocketSession extends Thread {

     private final DataInputStream dataInputStream;
     public DataOutputStream dataOutputStream;
     public String UID;
     String playerO;
     String ownerSocket;

     private final NetworkAccessLayer networkOperations;
     private ServerCallBack serverCallBack;

     public SocketSession(Socket socket, NetworkAccessLayer networkOperations, ServerCallBack serverCallBack) throws IOException {
          this.serverCallBack = serverCallBack;
          this.networkOperations = networkOperations;
          dataInputStream = new DataInputStream(socket.getInputStream());
          dataOutputStream = new DataOutputStream(socket.getOutputStream());
          start();

     }

     @Override
     public void run() {
          boolean flag = true;
          while (flag) {
               try {
                    String response = dataInputStream.readUTF();
                    System.out.println("Index  " + response);
                    requestNavigator(response);
               } catch (IOException ex) {
                    flag = false;
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
                         UID = networkOperations.login(data, dataOutputStream);
                         serverCallBack.requestUpdateDatabase();
                         break;

                    case ServerCall.RREGISTER_SEND:
                         UID = networkOperations.register(data, dataOutputStream);
                         serverCallBack.requestUpdateDatabase();
                         break;

                    case ServerCall.PLAYER_LIST_SEND:
                         networkOperations.onlinePlayers(data, dataOutputStream);
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

                    case ServerCall.CLOSE_SEND:

                         try {
                              networkOperations.updateState(data);
                              dataInputStream.close();
                              dataOutputStream.close();
                              stop();
                              ServerManager.sessionHolder.remove(this);
                              sleep(5000);
                              serverCallBack.requestUpdateDatabase();
                         } catch (InterruptedException ex) {
                              Logger.getLogger(SocketSession.class.getName()).log(Level.SEVERE, null, ex);
                         }

                         break;
               }
          }
     }
}
