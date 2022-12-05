package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.LoginScreenBase;

public class LoginController extends LoginScreenBase{
    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void isLogin(ActionEvent actionEvent) {
        // TODO login Validation in separated function retrurn boolean
        // Pass data in athentication function
        // If true navigate or send error message
        System.out.println("isLogin");
    }


    @Override
    protected void CreateAccount(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.REGISTER, stage);
    }
    
}
