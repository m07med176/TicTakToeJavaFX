package server;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.text.View;
import server.controller.PlayerOnServerController;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;
import server.utils.Config;

public class Server extends Application {
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;

    public static String CSS = "";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(Config.CSS).toExternalForm();
        PlayerOnServerController root = new PlayerOnServerController(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        // TODO set fixed size in all pages 
        // TODO make size resizable
    }
    
    public static void main(String[] args) {
         launch(args);
         
    }
    
}
