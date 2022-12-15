package tictaktoejavafx;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import tictaktoejavafx.utils.PathManager;
import javafx.application.Application;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class Client extends Application {
    public static String CSS ="";
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        CSS = this.getClass().getResource(Config.CSS).toExternalForm();
        PathManager.getPath();
        Navigator.navigate(Navigator.SPLACH, stage);
       // new HistoryJson(new PlayerModel());
        
        // TODO set fixed size in all pages 
        // TODO make size resizable
        
        
//        try {
//            socket = new Socket("127.0.0.1",5006);
//            dataInputStream = new DataInputStream(socket.getInputStream());
//            printStream = new PrintStream(socket.getOutputStream());
//            printStream.println("Client: Can here you");
//            String msg  = dataInputStream.readLine();
//            System.out.println(msg);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//
//            try {
//                socket.close();
//                printStream.close();
//                dataInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
