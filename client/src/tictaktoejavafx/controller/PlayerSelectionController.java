package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import tictaktoejavafx.utils.Config;
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
                try {
                    ServerConnection serverConnectionObj = ServerConnection.createInstance(stage);
                    serverConnectionObj.sendMessage(ServerCall.IVETATION_SEND + "," + "Hussin");
                    Platform.runLater(() -> {
                        serverConnectionObj.readThread();
                    });
                } catch (IOException ex) {
                    System.out.println("Server is Down");
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //-------------------------------------

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

            }
        });

    
            }
}
                
