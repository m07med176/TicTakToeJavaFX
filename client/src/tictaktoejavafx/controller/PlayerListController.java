package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.view.PlayerListScreenBase;

public class PlayerListController extends PlayerListScreenBase {
    private Stage stage;

    public PlayerListController(Stage stage) {
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
        System.out.println("isCharts");
    }
    
}
