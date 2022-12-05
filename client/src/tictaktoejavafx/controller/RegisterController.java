package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.RegisterScreenBase;

public class RegisterController extends RegisterScreenBase{
    private Stage stage;

    public RegisterController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void register(ActionEvent actionEvent) {
        // TODO validation of input of registeration in seprated function
        // TODO send regestration data in User Model
        // TODO send User Model in registration function in dataAccess layer
        // Sned Success Message if true then navigate or send Error Message
        System.out.println("register");
    }

    @Override
    protected void haveAccount(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.LOGIN, stage);
    }
    
}
