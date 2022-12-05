package server.utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.Server;
import server.controller.PlayerListController;
import server.controller.ServerChartController;
import server.controller.ServerHomeController;
import server.view.PlayerListScreenBase;


public class Navigator {
    public static final int HOME = 0;
    public static final int CHART = 1;
    public static final int PLAYERS_LIST = 2;

    public static void navigate(final int destination,Stage stage){
        Parent parent = null;
        switch (destination) {
            case HOME:
              parent  = new ServerHomeController(stage);
              break;
              
            case CHART:
              parent  = new ServerChartController(stage);
              break;
            
              
            case PLAYERS_LIST:
              parent  = new PlayerListController(stage);
              break;

            default:
                parent  = new ServerHomeController(stage);
          }
        
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        scene.getStylesheets().add(Server.CSS);
        stage.show();
    }
    
    
}
