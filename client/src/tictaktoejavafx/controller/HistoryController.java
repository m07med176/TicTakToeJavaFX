/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import java.io.IOException;
import tictaktoejavafx.data.model.HistoryModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.HistoryScreenBase;

public class HistoryController extends HistoryScreenBase {

    private Stage stage;
    private ArrayList<HistoryModel> playersList;

    public HistoryController(Stage stage) {
        this.stage = stage;
         try {
               playersList = HistoryDataBasedSystem.getPlayerModleList();
               colum_date.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("dateGame"));
               colum_Xname.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("playerXName"));
               colum_Oname.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("playerOName"));
               colum_winner.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("winner"));
               ObservableList<HistoryModel> observableList = FXCollections.observableArrayList(playersList);
               table_history_data.setItems(observableList);
         } catch (IOException ex) {
              Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
         }


    }

    @Override
    protected void isBack(ActionEvent actionEvent) {
        new UserMessage().display(Config.EXIT_MSG, new AlertAction() {
            @Override
            public void sendOk() {
                Navigator.navigate(Navigator.WELCOME, stage);
            }

            @Override
            public void sendCancel() {
                // Do Nothing
            }
        }, Alert.AlertType.CONFIRMATION);
    }

}
