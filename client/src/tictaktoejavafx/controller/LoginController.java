package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import tictaktoejavafx.view.LoginScreenBase;

public class LoginController extends LoginScreenBase{

    @Override
    protected void isLogin(ActionEvent actionEvent) {
        System.out.println("isLogin");
    }

    @Override
    protected void isPassword(ActionEvent actionEvent) {
        System.out.println("isPassword");
    }

    @Override
    protected void isUserName(ActionEvent actionEvent) {
        System.out.println("isUserName");
    }

    @Override
    protected void CreateAccount(ActionEvent actionEvent) {
        System.out.println("CreateAccount");
    }
    
}
