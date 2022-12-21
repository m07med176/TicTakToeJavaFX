package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.SocketConfigModel;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.PromptSocketAccessDialog;
import tictaktoejavafx.view.WelcomeScreenBase;

public class WelcomeController extends WelcomeScreenBase {
    private Stage stage;
    public WelcomeController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void isSingle(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.PLAYER_NAME_ONE, stage);
    }

    @Override
    protected void isTwo(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.PLAYER_NAME_TWO, stage);
    }

    @Override
    protected void isOnlineMode(ActionEvent actionEvent) {
        PromptSocketAccessDialog.display((SocketConfigModel socketConfigModel) -> {
             Navigator.navigate(Navigator.LOGIN, stage,socketConfigModel);
        });
    }

    @Override
    protected void isRecorded(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.TABLE_RECORD, stage);
    }
    
    @Override
    protected void isHistoryMode(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HISTORY, stage);
    }
}
