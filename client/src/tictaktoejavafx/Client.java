package tictaktoejavafx;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import tictaktoejavafx.utils.PathManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class Client extends Application {
    public static String CSS ="";
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;
    
    @Override
    public void start(Stage stage) throws Exception {
         stage.setTitle("Tic Tac Toe");
        stage.setResizable(false);
        CSS = this.getClass().getResource(Config.CSS).toExternalForm();
        PathManager.getPath();
        Navigator.navigate(Navigator.SPLACH, stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
