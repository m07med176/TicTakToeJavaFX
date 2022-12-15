package server.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;


public class SocketSession extends Thread {

    public static final String RREGISTER ="REGISTER";
    public static final String IVETATION = "IVETATION";
    public static final String LOGIN = "LOGIN"; 
    /*
    lOGIN,mohamem,,sdlgklsdf;gkdf;sgk
    */
    
    public DataInputStream dataInputStream;
    public PrintStream printStream;
    public Socket socket;

    public SocketSession(Socket socket) {
        System.out.println("Server is ON index:9");
        this.socket = socket;
        try {
             System.out.println("Server is ON index:10");
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            start();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
   
    
    @Override
    public void run() {
         System.out.println("Server is ON index:11");
        while(true){
            try {
                 System.out.println("Server is ON index:12");
                 String str = dataInputStream.readLine();
                 
                 System.out.println(str);
               if(str!=null)
               {
                   if(!str.isEmpty()){
                        String[] data = str.split(",");
                         switch (data[0]){
                              case LOGIN:
                                   // call funciton of db
                                   break;
                              case IVETATION:
                                   break;
                         }
                       sendMessageToAll(str);
                   }
               }
                }
            catch (IOException ex) {
               ex.printStackTrace();                    
            }        
            
        }
    }
    
    public void sendMessageToAll(String message){
        for(SocketSession session:ServerManager.sessionHolder){
                System.out.println(message);
                session.printStream.println(message);
        }
    }
    
}
