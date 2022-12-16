/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import tictaktoejavafx.data.model.PlayerModel;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.JsonData;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.HistoryScreenBase;

public class HistoryController extends HistoryScreenBase {

    private Stage stage;
    private ArrayList<PlayerModel> playersList;

    public HistoryController(Stage stage) {
        this.stage = stage;
        playersList = JsonData.getPlayerModleList();

        //gameNumberCulme.setCellValueFactory(new PropertyValueFactory<Game,Integer>(i));
        colum_date.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("dateGame"));
        colum_Xname.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerXName"));
        colum_Oname.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerOName"));
        colum_winner.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("winner"));

        ObservableList<PlayerModel> observableList = FXCollections.observableArrayList(playersList);
        table_history_data.setItems(observableList);
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
