package tictaktoejavafx.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerConnection extends Thread {
     private Socket socket;
     private PrintStream printStream;
     private DataInputStream dataInputStream;
     private String UID;
     private ServerCall serverCall;
     
     public ServerConnection(InetAddress address, int port,ServerCall serverCall) throws IOException {
          this.serverCall = serverCall;
          socket = new Socket(address, port);
          printStream = new PrintStream(socket.getOutputStream());
          dataInputStream = new DataInputStream(socket.getInputStream());
          start();
     }

     @Override
     public void run() {
          while (true) {
               try {
                    String str = dataInputStream.readLine();
                    if (str != null && !str.isEmpty()) {
                         System.out.println(str);
                    }
               } catch (IOException e) {
                    e.printStackTrace();
               }
          }
     }

     
          private /*synchronized*/ void requestNavigator(String response) {
          if (response != null && !response.isEmpty()) {
               String[] data = response.split(",");
               switch (data[0]) {
                    case ServerCall.LOGIN_SEND:
                         UID = serverCall.login(data, printStream);
                         break;

                    case ServerCall.RREGISTER_SEND:
                         UID = serverCall.register(data, printStream);
                         break;

                    case ServerCall.PLAYER_LIST_SEND:
                         serverCall.onlinePlayers(data, printStream);
                         break;

                    case ServerCall.MOVEMENT_SEND:
                         serverCall.move(data, UID);
                         break;

                    case ServerCall.IVETATION_SEND:
                         serverCall.invetation(data, UID);
                         break;

                    case ServerCall.CONFIRMATION_SEND:
                         serverCall.confirm(data, UID);
                         break;

               }
          }
     }

}
