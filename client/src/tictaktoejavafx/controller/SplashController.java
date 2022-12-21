package tictaktoejavafx.controller;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;
import tictaktoejavafx.Client;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.SplashScreenBase;

public class SplashController extends SplashScreenBase {
   private Stage stage;
   public SplashController(Stage stage) {
        this.stage = stage; 
        Platform.runLater(() -> {
            try {
                sleep(2*1000);
                Navigator.navigate(Navigator.WELCOME, stage);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);                  
            }
        });
       }
   
}
