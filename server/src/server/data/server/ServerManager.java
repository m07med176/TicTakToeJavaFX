package server.data.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import javafx.application.Platform;
import server.utils.Config;
import server.utils.ExceptionCallBack;

public class ServerManager extends Thread {
     public NetworkAccessLayer networkOperations;
     public static Vector<SocketSession> sessionHolder;
     private final ServerSocket serverSocket;
     private Socket socket;
     private static ServerManager mainServer;
     private ExceptionCallBack exceptionCallBack;

     private ServerManager(ExceptionCallBack exceptionCallBack) throws IOException, SQLException {
          this.exceptionCallBack = exceptionCallBack;
          sessionHolder =  new Vector<SocketSession>();
          serverSocket = new ServerSocket(Config.SOCKET_PORT);
          networkOperations = new NetworkAccessLayer();
       
     }

     public static ServerManager getInstance(ExceptionCallBack exceptionCallBack) throws IOException, SQLException {
          if (mainServer == null) {
               mainServer = new ServerManager(exceptionCallBack);
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
                    sessionHolder.add(new SocketSession(socket,networkOperations,exceptionCallBack));
               } catch (IOException ex) {
                    exceptionCallBack.serverException(ex);
               }
          }
     }
}
