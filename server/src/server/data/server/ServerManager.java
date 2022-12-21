package server.data.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import server.utils.Config;

public class ServerManager extends Thread {
     public NetworkAccessLayer networkOperations;
     public static Vector<SocketSession> sessionHolder;
     private final ServerSocket serverSocket;
     private Socket socket;
     private static ServerManager mainServer;
     private ServerCallBack serverCallBack;

     private ServerManager(ServerCallBack serverCallBack) throws IOException, SQLException {
          this.serverCallBack = serverCallBack;
          sessionHolder =  new Vector<SocketSession>();
          serverSocket = new ServerSocket(Config.SOCKET_PORT);
          networkOperations = new NetworkAccessLayer();
       
     }

     public static ServerManager getInstance(ServerCallBack serverCallBack) throws IOException, SQLException {
          if (mainServer == null) {
               mainServer = new ServerManager(serverCallBack);
          }
          return mainServer;
     }

     public void close(){
          closeSessions();
          this.stop();
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
                    socket = serverSocket.accept();
                    sessionHolder.add(new SocketSession(socket,networkOperations,serverCallBack));
               } catch (IOException ex) {
                    serverCallBack.serverException(ex);
               }
          }
     }
}
