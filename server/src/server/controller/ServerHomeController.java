package server.controller;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.utils.Navigator;
import server.view.ServerHomeScreenBase;


public class ServerHomeController extends ServerHomeScreenBase{
    private Stage stage;

    public ServerHomeController(Stage stage) {
        this.stage = stage;
    }
    
    
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
        Navigator.navigate(Navigator.CHART, stage);
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
