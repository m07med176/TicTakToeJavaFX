package server.controller;

import javafx.event.ActionEvent;
import server.view.ServerHomeScreenBase;

public class ServerHomeController extends ServerHomeScreenBase{

    @Override
    protected void isHome(ActionEvent actionEvent) {
        System.out.println("isHome");
    }

    @Override
    protected void isPlayers(ActionEvent actionEvent) {
        System.out.println("isPlayers");
    }

    @Override
    protected void isCharts(ActionEvent actionEvent) {
        System.out.println("isCharts");
    }

    @Override
    protected void isOn(ActionEvent actionEvent) {
        System.out.println("isOn");
    }

    @Override
    protected void isOff(ActionEvent actionEvent) {
       System.out.println("isOff");
    }
    
}
