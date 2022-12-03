package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import tictaktoejavafx.view.WelcomeScreenBase;

public class WelcomeController extends WelcomeScreenBase{

    @Override
    protected void isSingle(ActionEvent actionEvent) {
        System.out.println("isSingle");
    }

    @Override
    protected void isTwo(ActionEvent actionEvent) {
        System.out.println("isTwo");
    }

    @Override
    protected void isOnlineMode(ActionEvent actionEvent) {
        System.out.println("isOnlineMode");
    }
    
}
