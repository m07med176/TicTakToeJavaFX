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
import org.apache.derby.jdbc.ClientDriver;


public class Server extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new ServerHomeController(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
