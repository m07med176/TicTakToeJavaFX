package server.utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.controller.ServerChartController;
import server.controller.ServerHomeController;


public class Navigator {
    public static final int HOME = 0;
    public static final int CHART = 1;

    

    public static void navigate(final int destination,Stage stage){
        Parent parent = null;
        switch (destination) {
            case HOME:
              parent  = new ServerHomeController(stage);
              break;
              
            case CHART:
              parent  = new ServerChartController(stage);
              break;
              
            default:
                parent  = new ServerHomeController(stage);
                
          }
        stage.setScene(new Scene(parent));
        stage.show();
    }
    
    
}
