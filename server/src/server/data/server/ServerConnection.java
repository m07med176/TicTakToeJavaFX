package server.data.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerConnection {
    public static ServerSocket serverSocket;
    public static Socket socket;
    public static boolean isServerRunning = false;
    
    
    public ServerConnection() {serverInitializer();}


    
    public static Thread serverInitializer(){
    
         System.out.println("Intiailized");
         
         Thread thread = null;
         try {
            serverSocket = new ServerSocket(5005);
            thread = new Thread(() -> {
                while (true) {
                    try {
                        if(isServerRunning){
                             socket = serverSocket.accept();
                             new  SessionHandler(socket);  
                             System.out.println("Runnig");
                        }else{
                              socket.close();
                              System.out.println("Stopped");
                              break;
                        }
                    } catch (IOException ex) {
                         ex.printStackTrace();
                    }
                }  
               
            });
            thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
         return thread;
    }
}
