/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
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
import tictaktoejavafx.data.db.RecordData;
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
    private ArrayList<RecordModelData> recordDataModelList;
    
    public RecordController(Stage stage) {
        System.out.println("Record Constroutor");
        this.stage = stage;
        recordDataModelList = RecordData.getInstance().getData();

        //gameNumberCulme.setCellValueFactory(new PropertyValueFactory<Game,Integer>(i));
        this.date_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("dateGame"));
        this.x_name_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("playerXName"));
        this.o_name_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("playerOName"));
        this.type_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("type"));

        System.out.println("print byeeeeeeeee");
        ObservableList<RecordModelData> List = FXCollections.observableArrayList(recordDataModelList);
        table_record_id.setItems(List);
        System.out.println("i thik every thing is done");
        for(RecordModelData recordModelData:recordDataModelList){
            System.out.println("My Item:"+recordModelData.getPlayerOName());
        }
    }
    @Override
    protected void isBackbtn(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.WELCOME, stage);
    }
}

    

