package tictaktoejavafx.controller;

import java.io.IOException;
import tictaktoejavafx.data.model.HistoryDataModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.HistoryDataBasedSystem;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.HistoryScreenBase;

public class HistoryController extends HistoryScreenBase {

    private Stage stage;
    private ArrayList<HistoryDataModel> playersList;

    public HistoryController(Stage stage) {
        this.stage = stage;
         try {
               playersList = HistoryDataBasedSystem.getPlayerModleList();
               colum_date.setCellValueFactory(new PropertyValueFactory<HistoryDataModel, String>("dateGame"));
               colum_Xname.setCellValueFactory(new PropertyValueFactory<HistoryDataModel, String>("playerXName"));
               colum_Oname.setCellValueFactory(new PropertyValueFactory<HistoryDataModel, String>("playerOName"));
               colum_winner.setCellValueFactory(new PropertyValueFactory<HistoryDataModel, String>("winner"));
               ObservableList<HistoryDataModel> observableList = FXCollections.observableArrayList(playersList);
               table_history_data.setItems(observableList);
         } catch (IOException ex) {
              Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
         }


    }

    @Override
    protected void isBack(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.WELCOME, stage);
    }

}