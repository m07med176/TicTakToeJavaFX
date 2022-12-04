package server.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import server.view.ServerChartScreenBase;

public class ServerChartController extends ServerChartScreenBase{
    private Stage stage;

    public ServerChartController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void sHome(ActionEvent actionEvent) {
        System.out.println("sHome");
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
