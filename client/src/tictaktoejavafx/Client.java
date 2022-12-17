package tictaktoejavafx;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import tictaktoejavafx.utils.PathManager;
import javafx.application.Application;
import javafx.stage.Stage;
import tictaktoejavafx.data.server.ServerConnection;
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

//        new ServerConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
