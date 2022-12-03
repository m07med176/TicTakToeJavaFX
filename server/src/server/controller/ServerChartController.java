package server.controller;

import javafx.event.ActionEvent;
import server.view.ServerChartScreenBase;

public class ServerChartController extends ServerChartScreenBase{

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
