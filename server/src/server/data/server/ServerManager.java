package server.data.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import server.utils.Config;

public class ServerManager extends Thread{
     public static Vector<SocketSession> sessionHolder = new Vector<SocketSession>(); // I dont know how
     private ServerSocket serverSocket;                 // Main server socket
     private Socket socket;                             // Socket

     static ServerManager mainServer;                  // Singltone

     private ServerManager() {
          System.out.println("Server is ON index:4");
          try {
               System.out.println("Server is ON index:5");
               serverSocket = new ServerSocket(Config.SOCKET_PORT);
          } catch (IOException ex) {
               ex.printStackTrace();
          }
     }

     public static ServerManager getInstance() {
          System.out.println("Server is ON index:2");
          if (mainServer == null) {
               System.out.println("Server is ON index:3");
                mainServer = new ServerManager();
          }
          return mainServer;
     }

     void closeSessions() {
          sessionHolder.forEach((session) -> {
               session.stop(); 
          });
     }

     
     @Override
     public void run() {
          System.out.println("Server is ON index:6");
          while (true) {
               try {
                    System.out.println("Server is ON index:7");
                    socket = serverSocket.accept(); // still lestining with freexzing
                    
                    System.out.println("Server is ON index:8");
                   // sessionHolder.add(new SocketSession(socket));
                SocketSession soc=new SocketSession(socket);
            //  soc.getId();
                   System.out.println("id Socket"+soc.getId());
                   sessionHolder.add(soc);

               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
     }

}
