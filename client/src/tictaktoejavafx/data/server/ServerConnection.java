package tictaktoejavafx.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServerConnection {

     public Socket socket;

     public ServerConnection() {
          try 
          {
               socket = new Socket("127.0.0.1", 5005);
          } 
          
          catch (IOException ex) 
          {
               System.out.println("Server Closed: "+ex);   
          }

          readThread();
     }

     public void sendMessage(String message) {
          PrintStream printStream = null;
          try {
               printStream = new PrintStream(socket.getOutputStream());
               printStream.println(message);
          } catch (IOException e) {
               System.out.println("Server cant send");
          }
     }

     public void readThread() {
          new Thread(new Runnable() {
               @Override
               public void run() {
                    while (true) {
                         DataInputStream dataInputStream;
                         try {
                              dataInputStream = new DataInputStream(socket.getInputStream());
                              String str = dataInputStream.readLine();
                              if(str!=null && !str.isEmpty()){
                                        System.out.println(str);
                              }        
                         } catch (IOException e) {
                              System.out.println("Server cant get"+e);
                         }
                    }
               }
          }).start();
     }

}

