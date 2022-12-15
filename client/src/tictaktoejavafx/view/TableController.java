/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tictaktoejavafx.data.model.PlayerModel;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TableController implements Initializable {

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
        
            //gameNumberCulme.setCellValueFactory(new PropertyValueFactory<Game,Integer>(i));
            colum_date.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("dateGame"));
            colum_Xname.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerXName"));
            colum_Oname.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("playerOName"));
            colum_winner.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("winner"));
            
    }    

    @FXML
    private void isBack(ActionEvent event) {
    }

    @FXML
    private void isTableData(SortEvent<C> event) {
    }
    
}
