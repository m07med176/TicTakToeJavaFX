package tictaktoejavafx.data.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;

public class ServerConnection {

    public static Socket socket;
    private static ServerConnection serverConnection = null;
    Thread thread = null;
    DataInputStream dataInputStream;
    private static Stage stage;

    private ServerConnection() throws IOException {

        startSocket();
    }

    public static ServerConnection createInstance(Stage s) throws IOException {
        if (serverConnection == null) {
            serverConnection = new ServerConnection();
        }
        stage = s;
        return serverConnection;
    }

    private static void startSocket() throws IOException {
        socket = new Socket("127.0.0.1", 5005);
        

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

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        dataInputStream = new DataInputStream(socket.getInputStream());
                        String str = dataInputStream.readLine();
                        if (str != null && !str.isEmpty()) {
                            System.out.println(str);
                            getMessage(str);
                        }
                    } catch (IOException e) {
                        System.out.println("Server cant get" + e);
                    }
                }
            }
        });
        thread.start();
    }

    public void getMessage(String msg) {
        if (!msg.isEmpty()) {
            switch (msg) {
                case "ACCEPT":
                    System.out.println("Your Friend Accepted Invetation");
                    Navigator.navigate(Navigator.GAMEBOARD, stage);
                    break;
                case "CANCLE":
                    System.out.println("Your Friend Cancled Invetation");
                    break;
                default:
                    System.out.println("Invalide Choice");
                    break;

            }
        }
    }

    public void closeThread() throws IOException {
        dataInputStream.close();
        socket.close();
        thread.stop();
     serverConnection = null;   
 
    }
}
