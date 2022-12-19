package server.data.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import server.utils.Config;

public class ServerManager extends Thread {

     public NetworkAccessLayer networkOperations;
     public static Vector<SocketSession> sessionHolder = new Vector<SocketSession>();
     private final ServerSocket serverSocket;
     private Socket socket;
     private static ServerManager mainServer;

     private ServerManager() throws IOException, SQLException {
          serverSocket = new ServerSocket(Config.SOCKET_PORT);
          networkOperations = new NetworkAccessLayer();
     }

     public static ServerManager getInstance() throws IOException, SQLException {
          if (mainServer == null) {
               mainServer = new ServerManager();
          }
          return mainServer;
     }

     public void close(){
          closeSessions();
          stop();
     
     }
     public void closeSessions() {
          sessionHolder.forEach((session) -> {
               session.stop();
          });
     }

     @Override
     public void run() {
          while (true) {
               try {
                    socket = serverSocket.accept(); // still lesting
                    sessionHolder.add(new SocketSession(socket,networkOperations));
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
     }

}
