package server.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;
import server.data.server.ServerManager;
import server.view.PlayerOnServerBase;

public class PlayerOnServerController extends PlayerOnServerBase {

    private Stage stage;
        ArrayList<Player> arrayListPlayer = new ArrayList();

    public PlayerOnServerController(Stage stage) {
        this.stage = stage;
       
        try {
            arrayListPlayer=DatabaseAccessLayer.getPlayerData();
             displayPlayerInTable(arrayListPlayer);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerOnServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 Boolean flag=false; 
    @Override
    protected void runServer(ActionEvent actionEvent) {
              ServerManager server = ServerManager.getInstance();
              flag=!flag;
              
              if(flag){
                   System.out.println("Server is OFF index:1");
                   btnOnOff.setText("OFF");
                   server.start();   
              }else{
                   btnOnOff.setText("ON");
                   server.stop();
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
