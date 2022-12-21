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
import server.utils.UserMessage;
import server.view.PlayerOnServerBase;
import server.data.server.ServerCallBack;

public class PlayerOnServerController extends PlayerOnServerBase {

     private Boolean flag = false;
     private ArrayList<Player> arrayListPlayer = new ArrayList();

     public PlayerOnServerController() {
          displayPlayerInTable();
     }

     @Override
     protected void runServer(ActionEvent actionEvent) {
          try {
               ServerManager server = ServerManager.getInstance(new ServerCallBack() {
                    @Override
                    public void serverException(IOException ex) {
                         UserMessage.showError(ex.getMessage());
                    }

                    @Override
                    public void databaseException(SQLException ex) {
                         UserMessage.showError(ex.getMessage());
                    }

                    @Override
                    public void requestUpdateDatabase() {
                         displayPlayerInTable();
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
               UserMessage.showError(ex.getMessage());
          }
     }

     public void displayPlayerInTable() {
          try {
               arrayListPlayer = new DatabaseAccessLayer().getAllPlayers();
               columName.setCellValueFactory(new PropertyValueFactory<Player, String>("username"));
               columEmail.setCellValueFactory(new PropertyValueFactory<Player, String>("email"));
               columActive.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("status"));
               ObservableList<Player> observableList = FXCollections.observableArrayList(arrayListPlayer);
               table.setItems(observableList);
          } catch (SQLException ex) {
               UserMessage.showError(ex.getMessage());
          }

     }

}
