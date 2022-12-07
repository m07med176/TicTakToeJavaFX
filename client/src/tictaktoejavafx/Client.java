package tictaktoejavafx;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictaktoejavafx.utils.PathManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AssetsRepository;
import tictaktoejavafx.utils.Navigator;

public class Client extends Application {
    public static String CSS ="";
    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        CSS = this.getClass().getResource(AssetsRepository.CSS).toExternalForm();
        PathManager.getPath();
        Navigator.navigate(Navigator.SPLACH, stage);
                
        
        // TODO set fixed size in all pages 
        // TODO make size resizable
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
