package server;
import javafx.application.Application;
import javafx.stage.Stage;
import server.utils.Config;
import server.utils.Navigator;


public class Server extends Application {
    public static String CSS = "";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(Config.CSS).toExternalForm();
        Navigator.navigate(Navigator.HOME, stage);
        // TODO set fixed size in all pages 
        // TODO make size resizable
    }
    
    public static void main(String[] args) {
         launch(args);
    }
    
}
