package server.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import server.utils.Navigator;
import server.view.ServerChartScreenBase;

public class ServerChartController extends ServerChartScreenBase{
    private Stage stage;

    public ServerChartController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void sHome(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HOME, stage);
    }

    @Override
    protected void sPlayers(ActionEvent actionEvent) {
        System.out.println("sPlayers");
    }

    @Override
    protected void sCharts(ActionEvent actionEvent) {
        System.out.println("sCharts");
    }
    
}
