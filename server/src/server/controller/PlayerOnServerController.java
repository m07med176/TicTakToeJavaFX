/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import server.data.server.ServerConnection;
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
         
              Thread thread = null;
              if(flag){
                   btnOnOff.setText("OFF");
                   if(thread != null && thread.isAlive()){
                        try {
                             thread.join();
                        } catch (InterruptedException ex) {
                             ex.printStackTrace();
                        }
                   }
              }else{
                   btnOnOff.setText("ON");
                   thread = ServerConnection.serverInitializer();
              }
              flag=!flag;
              ServerConnection.isServerRunning = flag;
              
          try {
              DatabaseAccessLayer db = new DatabaseAccessLayer();
              //db.addPlayer(new Player(3, "saad", "mail.com", "sd6fs",false));
              //System.out.println("Server Button");
         } catch (SQLException ex) {
              Logger.getLogger(PlayerOnServerController.class.getName()).log(Level.SEVERE, null, ex);
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