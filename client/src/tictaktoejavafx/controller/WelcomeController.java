package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.WelcomeScreenBase;
import static tictaktoejavafx.utils.Navigator.TABLE_RECORD;

public class WelcomeController extends WelcomeScreenBase {

    private Stage stage;

    public WelcomeController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void isSingle(ActionEvent actionEvent) {
        // System.out.println("isSingle");
        Navigator.navigate(Navigator.PLAYER_NAME_ONE, stage);
        //  Navigator.navigate(Navigator.CHOOSEDIFF, stage);

    }

    @Override
    protected void isTwo(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.PLAYER_NAME_TWO, stage);
    }

    @Override
    protected void isOnlineMode(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.LOGIN, stage);
    }

    @Override
    protected void isRecorded(ActionEvent actionEvent) {
        System.out.println("Record Clicked");
        Navigator.navigate(Navigator.TABLE_RECORD, stage);
    }
    
    @Override
    protected void isHistoryMode(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HISTORY, stage);
    }

}
