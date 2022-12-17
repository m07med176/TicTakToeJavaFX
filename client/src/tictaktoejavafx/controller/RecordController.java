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
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.data.model.RecordModelData;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.RecordTableBase;

/**
 *
 * @author hp
 */
public class RecordController extends RecordTableBase {
    
    private Stage stage;
    private ArrayList<RecordModelData> recordData;
    
    public RecordController(Stage stage) {
        this.stage = stage;
        recordData = getPlayerModleList();

        //gameNumberCulme.setCellValueFactory(new PropertyValueFactory<Game,Integer>(i));
        Date_colum.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("dateGame"));
        Xname_colum.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerXName"));
        Oname_colum.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerOName"));

        ObservableList<RecordModelData> observableList = FXCollections.observableArrayList(recordData);
        table_id.setItems(observableList);
    }
    @Override
    protected void isBackbtn(ActionEvent actionEvent) {
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
     public static ArrayList<RecordModelData> getPlayerModleList() {
        ArrayList<RecordModelData> data = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)))) {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordModelData>>() {
            }.getType();
            try {
                data = gson.fromJson(bufferedReader, listType);
            } catch (Exception ex) {
                data = new ArrayList();
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    

    

}

    

