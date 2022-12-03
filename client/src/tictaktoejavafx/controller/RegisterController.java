package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import tictaktoejavafx.view.RegisterScreenBase;

public class RegisterController extends RegisterScreenBase{

    @Override
    protected void registerUserName(ActionEvent actionEvent) {
        System.out.println("registerUserName");
    }

    @Override
    protected void registerEmail(ActionEvent actionEvent) {
        System.out.println("registerEmail");
    }

    @Override
    protected void registerPassword(ActionEvent actionEvent) {
        System.out.println("registerPassword");
    }

    @Override
    protected void registerRepeatPassword(ActionEvent actionEvent) {
        System.out.println("registerRepeatPassword");
    }

    @Override
    protected void register(ActionEvent actionEvent) {
        System.out.println("register");
    }

    @Override
    protected void haveAccount(ActionEvent actionEvent) {
        System.out.println("haveAccount");
    }
    
}
