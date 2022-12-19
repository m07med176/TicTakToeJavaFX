package server.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;
import server.data.server.ServerManager;
import server.utils.AlertAction;
import server.utils.UserMessage;
import server.view.PlayerOnServerBase;

public class PlayerOnServerController extends PlayerOnServerBase {

    private Stage stage;
    private Boolean flag=false;
    private ArrayList<Player> arrayListPlayer = new ArrayList();

    public PlayerOnServerController(Stage stage) {
        this.stage = stage;
       
        try {
            arrayListPlayer=DatabaseAccessLayer.getPlayerData();
             displayPlayerInTable(arrayListPlayer);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerOnServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
  
    @Override
    protected void runServer(ActionEvent actionEvent) {
         try {
              ServerManager server = ServerManager.getInstance();
              flag=!flag;
              if(flag){   
                   btnOnOff.setText("ON");
                   server.start();
              }else{
                   btnOnOff.setText("OFF");
                   server.close();
                    
              }
         } catch (IOException ex) {
              new UserMessage().display("Problm Happend to Socket Server\n"+ex.getMessage(), null, Alert.AlertType.INFORMATION);
         } catch (SQLException ex) {
              new UserMessage().display("Problm Happend to Database Server\n"+ex.getMessage(), null, Alert.AlertType.INFORMATION);
         }
              
    }
    
  public  void displayPlayerInTable( ArrayList<Player> model){
     columName.setCellValueFactory(new PropertyValueFactory<Player,String>("username"));
     columEmail.setCellValueFactory(new PropertyValueFactory<Player,String>("email"));
     columActive.setCellValueFactory(new PropertyValueFactory<Player,Boolean>("status"));

     ObservableList<Player> observableList=FXCollections.observableArrayList(model);
     table.setItems(observableList);
  }

}
