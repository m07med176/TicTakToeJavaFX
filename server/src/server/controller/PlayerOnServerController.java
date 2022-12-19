package server.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;
import server.data.server.ServerManager;
import server.utils.AlertAction;
import server.utils.ExceptionCallBack;
import server.utils.UserMessage;
import server.view.PlayerOnServerBase;

public class PlayerOnServerController extends PlayerOnServerBase {

     private Boolean flag = false;
     private ArrayList<Player> arrayListPlayer = new ArrayList();

     public PlayerOnServerController() {
          try {
               arrayListPlayer = DatabaseAccessLayer.getPlayerData();
               displayPlayerInTable(arrayListPlayer);
          } catch (SQLException ex) {
               new UserMessage().alert(ex.getMessage(), null);
          }

     }

     @Override
     protected void runServer(ActionEvent actionEvent) {
          try {
               ServerManager server = ServerManager.getInstance(new ExceptionCallBack() {
                    @Override
                    public void serverException(IOException ex) {
                         callAlertMessage(ex.getMessage());
                    }

                    @Override
                    public void databaseException(SQLException ex) {
                         callAlertMessage(ex.getMessage());
                    }
               });

               if (flag == false) {
                    btnOnOff.setText("ON");
                    flag = true;
                    server.start();
               } else {
                    flag = false;
                    btnOnOff.setText("OFF");
                    server.close();

               }
          } catch (IOException | SQLException ex) {
               callAlertMessage(ex.getMessage());
          }
     }

     public void callAlertMessage(String ex) {
          new UserMessage().alert(ex, new AlertAction() {
               @Override
               public void sendOk() {
               }

               @Override
               public void sendCancel() {
               }
          });
     }

     public void displayPlayerInTable(ArrayList<Player> model) {
          columName.setCellValueFactory(new PropertyValueFactory<Player, String>("username"));
          columEmail.setCellValueFactory(new PropertyValueFactory<Player, String>("email"));
          columActive.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("status"));
          ObservableList<Player> observableList = FXCollections.observableArrayList(model);
          table.setItems(observableList);
     }

}
