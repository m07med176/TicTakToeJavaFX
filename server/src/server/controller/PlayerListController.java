package server.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import server.utils.Navigator;
import server.view.PlayerListScreenBase;

public class PlayerListController extends PlayerListScreenBase {
    private Stage stage;

    public PlayerListController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void isHome(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HOME, stage);
    }

    @Override
    protected void isPlayers(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.PLAYERS_LIST, stage);
    }

    @Override
    protected void isCharts(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.CHART, stage);
    }
    
}
