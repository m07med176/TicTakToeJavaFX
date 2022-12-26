package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.Player;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.PlayerSelectionScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class PlayerSelectionController extends PlayerSelectionScreenBase {
     private Stage stage;
     private ArrayList<Player> onlinePlayers;

     public PlayerSelectionController(Stage stage,Object o) {
          onlinePlayers = (ArrayList<Player>) Navigator.getSetPlayerData();
          this.stage = stage;
          displayPlayerInTable(onlinePlayers);
          handleExitEvent();
          
          
     }
     public static void updatePlayer(ArrayList<Player> player){
         
     }

     public void displayPlayerInTable(ArrayList<Player> model) {
          columName.setCellValueFactory(new PropertyValueFactory<Player, String>("username"));
          columEmail.setCellValueFactory(new PropertyValueFactory<Player, String>("email"));
          columActive.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("status"));
          ObservableList<Player> observableList = FXCollections.observableArrayList(model);
          table_player_selection.setItems(observableList);

          table_player_selection.setRowFactory(tv -> {
               TableRow<Player> row = new TableRow<>();
               row.setOnMouseClicked(event -> {
                    if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                         Player player = row.getItem();
                         Navigator.setPlayerTwo(player.getUsername());
                         Navigator.setStartGame(true);
                         try {
                             
                              ServerConnection.sendMessage(ServerCall.IVETATION_SEND + ServerCall.DELIMETER + player.getUsername());
                         } catch (IOException ex) {
                              UserMessage.showError(ex.getMessage());
                         }
                    }
               });
               return row;
          });
     }

     private void handleExitEvent() {
          stage.setOnCloseRequest((WindowEvent event) -> {
               try {
                    ServerConnection.closeThread();
               } catch (IOException ex) {
                    new UserMessage().display(ex.getMessage(), new CallBackAction() {
                         @Override
                         public void sendOk() {
                              Navigator.setPlayerStage(Navigator.WELCOME);
                              Navigator.navigate(Navigator.WELCOME, stage);
                         }

                         @Override
                         public void sendCancel() {
                              // Do Nothing
                         }
                    }, Alert.AlertType.ERROR);
               }
          });
          stage.setOnCloseRequest((WindowEvent event) -> {
              try {
                  ServerConnection.closeThread();
              } catch (IOException ex) {
                  Logger.getLogger(PlayerSelectionController.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
     }
}
