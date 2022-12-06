package server;

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
import server.utils.AssetsRepository;
import server.utils.Navigator;


public class Server extends Application {
    public static String CSS = "";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(AssetsRepository.CSS).toExternalForm();
        Navigator.navigate(Navigator.HOME, stage);
        // TODO set fixed size in all pages 
        // TODO make size resizable
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
