package tictaktoejavafx;

import tictaktoejavafx.utils.PathManager;
import javafx.application.Application;
import javafx.stage.Stage;
import tictaktoejavafx.utils.AssetsRepository;
import tictaktoejavafx.utils.Navigator;

public class Client extends Application {
    public static String CSS ="";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(AssetsRepository.CSS).toExternalForm();
        PathManager.getPath();
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
