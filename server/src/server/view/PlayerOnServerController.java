/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import server.data.db.DatabaseAccessLayer;
import server.data.model.Player;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
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
        if(flag == false){
              btnOnOff.setText("ON");
               flag =true;
        }else{
             flag=false;
             btnOnOff.setText("OFF");
        }
      
        System.out.println("Server Button");
    }
  public  void displayPlayerInTable( ArrayList<Player> model){

   columName.setCellValueFactory(new PropertyValueFactory<Player,String>("username"));
   columEmail.setCellValueFactory(new PropertyValueFactory<Player,String>("email"));
   columActive.setCellValueFactory(new PropertyValueFactory<Player,Boolean>("status"));

   ObservableList<Player> observableList=FXCollections.observableArrayList(model);
   table.setItems(observableList);
    }

}
