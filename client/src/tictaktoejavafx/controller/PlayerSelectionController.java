package tictaktoejavafx.controller;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.PlayerOnline;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.PlayerSelectionScreenBase;

public class PlayerSelectionController extends PlayerSelectionScreenBase{
    private Stage stage;
    
    private ArrayList<PlayerOnline> onlinePlayers = new ArrayList<PlayerOnline>();
    
    public PlayerSelectionController(Stage stage) {
        this.stage = stage;
        ObservableList<String> names = FXCollections.observableArrayList(
          "Julia" , "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
     this.list_view_user.setItems(names);

     this.list_view_user.setOnMouseClicked(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                  new UserMessage().display(Config.INVATE_MSG, new AlertAction(){
               @Override
               public void sendOk() {
                    Navigator.navigate(Navigator.GAMEBOARD, stage);
                    System.out.println("sdkljfl");
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          },Alert.AlertType.CONFIRMATION);
                 
             }
        });

        
    }
}
