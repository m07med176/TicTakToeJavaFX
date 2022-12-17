package server.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;


public class SessionHandler extends Thread{

    DataInputStream dataInputStream;
    PrintStream printStream;
    public Socket socket;
    public static Vector<SessionHandler> chatList = new Vector<SessionHandler>();

    public SessionHandler(Socket socket) {
        this.socket = socket;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            
            SessionHandler.chatList.add(this); // every time add chat in handler
            start();
        } catch (IOException ex) {
            String d = "";
        }
        
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                    String str = dataInputStream.readLine();
                    if(str!=null)
                    {
                        if(!str.isEmpty()){                            
                            sendMessageToAll(str);
                        }
                    }
                }
            catch (IOException ex) {
                String a = "";
                    }        
            }
    }
    
    public void sendMessageToAll(String message){
        for(SessionHandler chat:chatList){
                System.out.println(message);
                chat.printStream.println(message);
        }

    }
    
}
