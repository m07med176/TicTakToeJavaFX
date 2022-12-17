package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import static tictaktoejavafx.utils.Navigator.TableRecord;
import tictaktoejavafx.view.WelcomeScreenBase;

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
        Navigator.navigate(Navigator.TableRecord, stage);
    }
    
    @Override
    protected void isHistoryMode(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HISTORY, stage);
    }

}
