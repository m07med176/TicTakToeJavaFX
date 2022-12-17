/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tictaktoejavafx.controller.HistoryController;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.utils.AlertAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TableController implements Initializable {
    private Stage stage;

    @FXML
    private Button back_button;
    @FXML
    private TableView<PlayerModel> table_history_data;
    @FXML
    private TableColumn<PlayerModel,String> colum_date;
    @FXML
    private TableColumn<PlayerModel, String> colum_Xname;
    @FXML
    private TableColumn<PlayerModel, String> colum_Oname;
    @FXML
    private TableColumn<PlayerModel, String> colum_winner;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void isBack(ActionEvent event) {
        
    new UserMessage().display(Config.EXIT_MSG, new AlertAction(){
               @Override
               public void sendOk() {
                    Navigator.navigate(Navigator.WELCOME,stage);
               }

               @Override
               public void sendCancel() {
                    // Do Nothing
               }
          },Alert.AlertType.CONFIRMATION);
    }

    @FXML
    private void isTableData(SortEvent<Cell> event) {
        
    }
    
}
