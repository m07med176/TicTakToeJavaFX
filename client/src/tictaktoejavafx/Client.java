package tictaktoejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictaktoejavafx.controller.WelcomeController;
import tictaktoejavafx.utils.Navigator;

public class Client extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Navigator.navigate(Navigator.WELCOME, stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
