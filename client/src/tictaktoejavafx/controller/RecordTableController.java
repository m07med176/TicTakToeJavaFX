package tictaktoejavafx.controller;

import com.google.gson.JsonIOException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import tictaktoejavafx.data.db.RecordDataBasedSystem;
import tictaktoejavafx.data.model.RecordDataModel;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.RecordTableBase;

public class RecordTableController extends RecordTableBase {

     private Stage stage;
     private ArrayList<RecordDataModel> recordDataModelList;

     public RecordTableController(Stage stage) {
          this.stage = stage;
          try {
               recordDataModelList = RecordDataBasedSystem.getInstance().getData();
          } catch (IOException ex) {
               UserMessage.showError(ex.getMessage());
          } catch (JsonIOException ex) {
               UserMessage.showError(ex.getMessage());
          }

          this.date_colum.setCellValueFactory(new PropertyValueFactory<RecordDataModel, String>("dateGame"));
          this.x_name_colum.setCellValueFactory(new PropertyValueFactory<RecordDataModel, String>("playerXName"));
          this.o_name_colum.setCellValueFactory(new PropertyValueFactory<RecordDataModel, String>("playerOName"));
          this.type_colum.setCellValueFactory(new PropertyValueFactory<RecordDataModel, String>("type"));

          ObservableList<RecordDataModel> List = FXCollections.observableArrayList(recordDataModelList);
          table_record_id.setItems(List);

          table_record_id.setRowFactory(tv -> {
               TableRow<RecordDataModel> row = new TableRow<>();
               row.setOnMouseClicked(event -> {
                    if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                            && event.getClickCount() == 2) {

                         RecordDataModel clickedRow = row.getItem();
                         Navigator.navigate(Navigator.RECORD, stage, clickedRow);

                    }
               });
               return row;
          });

     }

     @Override
     protected void isBackbtn(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.WELCOME, stage);
     }
}
