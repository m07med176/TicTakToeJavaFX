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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author COMPUMARTS
 */
public class RegisterScreenController implements Initializable {

    @FXML
    private TextField user_name_register;
    @FXML
    private TextField email_register;
    @FXML
    private PasswordField password_register;
    @FXML
    private PasswordField repeat_password_register;
    @FXML
    private Button btn_register;
    @FXML
    private Hyperlink have_accout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register(ActionEvent event) {
    }

    @FXML
    private void haveAccount(ActionEvent event) {
    }

    @FXML
    private void onBackClicked(ActionEvent event) {
    }
    
}
