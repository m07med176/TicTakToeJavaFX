package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.WelcomeScreenBase;

public class WelcomeController extends WelcomeScreenBase{
    private Stage stage;

    public WelcomeController(Stage stage) {
        this.stage = stage;
    }
    @Override
    protected void isSingle(ActionEvent actionEvent) {
        System.out.println("isSingle");
    }

    @Override
    protected void isTwo(ActionEvent actionEvent) {
        System.out.println("isTwo");
        Navigator.navigate(Navigator.GAMEBOARD_MULTI, stage);
    }

    @Override
    protected void isOnlineMode(ActionEvent actionEvent) {
        System.out.println("isOnlineMode");
    }
    
}
