package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;
import server.controller.ServerHomeController;
import server.utils.Config;
import server.utils.Navigator;


public class Server extends Application {
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream printStream;

    public static String CSS = "";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(Config.CSS).toExternalForm();
        Navigator.navigate(Navigator.HOME, stage);
        // TODO set fixed size in all pages 
        // TODO make size resizable
        
        
        try {
            serverSocket = new ServerSocket(5006);
            socket = serverSocket.accept(); // listen for connections and transfer incoming client to virtual port
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            String msg = dataInputStream.readLine();
            System.out.println("The Client Syas : "+msg);
            printStream.println("Server: I Can here you");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
                socket.close();
                dataInputStream.close();
                printStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
       try {
            launch(args);
            DriverManager.deregisterDriver(new ClientDriver());
           Connection con = DriverManager.getConnection( "jdbc:derby://localhost:1527/userdatabase","root" ,"root");
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
