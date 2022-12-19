package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.PlayerOnline;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.PlayerSelectionScreenBase;

public class PlayerSelectionController extends PlayerSelectionScreenBase {

    private Stage stage;

    private ArrayList<PlayerOnline> onlinePlayers = new ArrayList<PlayerOnline>();

    public PlayerSelectionController(Stage stage) {
        this.stage = stage;
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        this.list_view_user.setItems(names);

        this.list_view_user.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //------------------------------------
                Navigator.setPlayerTwo("Hussin"); //-------------------------------------
                Navigator.setStartGame(true);
                try {
                    //ServerConnection serverConnectionObj = ServerConnection.getInstance(stage);
                    //serverConnectionObj.sendMessage(ServerCall.IVETATION_SEND + "," + "Hussin");
                    //serverConnectionObj.readThread();
                    ServerConnection.sendMessage(ServerCall.IVETATION_SEND + ServerCall.DELIMETER  + "Hussin");
                } catch (IOException ex) {
                    Logger.getLogger(PlayerSelectionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("hiiiiiiiiiiiiiii");

            }
        });
            this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    ServerConnection.closeThread();
                } catch (IOException ex) {
                     new UserMessage().display(ex.getMessage(), new AlertAction(){
               @Override
               public void sendOk() {
                    Navigator.navigate(Navigator.WELCOME, stage);
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          },Alert.AlertType.ERROR);
                }
            }
        });  
    }
}


                /*    new UserMessage().display(Config.INVATE_MSG, new AlertAction() {
                @Override
                public void sendOk() {
                Navigator.navigate(Navigator.GAMEBOARD, stage);
                System.out.println("sdkljfl");
                }
                @Override
                public void sendCancel() {
                // Do Nothing
                }
                }, Alert.AlertType.CONFIRMATION);*/
                
