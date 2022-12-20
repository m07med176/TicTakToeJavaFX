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
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.HistoryModel;
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
public class RecordTableController extends RecordTableBase {
    
    private Stage stage;
    private ArrayList<RecordModelData> recordDataModelList;
    
    public RecordTableController(Stage stage) {
        this.stage = stage;
        recordDataModelList = RecordDataBasedSystem.getInstance().getData();

        //gameNumberCulme.setCellValueFactory(new PropertyValueFactory<Game,Integer>(i));
        this.date_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("dateGame"));
        this.x_name_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("playerXName"));
        this.o_name_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("playerOName"));
        this.type_colum.setCellValueFactory(new PropertyValueFactory<RecordModelData, String>("type"));

        ObservableList<RecordModelData> List = FXCollections.observableArrayList(recordDataModelList);
        table_record_id.setItems(List);

        table_record_id.setRowFactory(tv -> {
    TableRow<RecordModelData> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
             && event.getClickCount() == 2) {

            RecordModelData clickedRow = row.getItem();
            Navigator.navigate(Navigator.RECORD, stage,clickedRow);

        }
    });
    return row ;
});
    
    }
    protected void isBackbtn(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override
    protected void onBackClicked(ActionEvent actionEvent) {
   
    }
}


    

