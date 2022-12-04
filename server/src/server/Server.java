package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.controller.ServerHomeController;
import server.utils.AssetsRepository;
import server.utils.Navigator;

public class Server extends Application {
    public static String CSS = "";
    @Override
    public void start(Stage stage) throws Exception {
        CSS = this.getClass().getResource(AssetsRepository.CSS).toExternalForm();
        Navigator.navigate(Navigator.HOME, stage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
