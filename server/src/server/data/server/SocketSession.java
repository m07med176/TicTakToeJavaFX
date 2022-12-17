package server.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class SocketSession extends Thread {

     private final DataInputStream dataInputStream;
     public PrintStream printStream;
     public String UID;

     private final NetworkAccessLayer networkOperations;

     public SocketSession(Socket socket, NetworkAccessLayer networkOperations) throws IOException {
          this.networkOperations = networkOperations;
          dataInputStream = new DataInputStream(socket.getInputStream());
          printStream = new PrintStream(socket.getOutputStream());
          start();
     }

     @Override
     public void run() {
          while (true) {
               try {
                    System.out.println("Indecx lkajsd");
                    String response = dataInputStream.readLine();
                    System.out.println("Index  "+response);
                    requestNavigator(response);
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
     }

     private /*synchronized*/ void requestNavigator(String response) {
          if (response != null && !response.isEmpty()) {
               String[] data = response.split(",");
               switch (data[0]) {
                    case ServerCall.LOGIN_SEND:
                         //UID = networkOperations.login(data, printStream);
                        UID=data[1];
                         break;

                    case ServerCall.RREGISTER_SEND:
                         UID = networkOperations.register(data, printStream);
                         break;

                    case ServerCall.PLAYER_LIST_SEND:
                         System.out.println("Indecx palyers send");
                         networkOperations.onlinePlayers(data, printStream);
                         break;

                    case ServerCall.MOVEMENT_SEND:
                         networkOperations.move(data, UID);
                         break;
// send from ahmed to Hussin 
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
