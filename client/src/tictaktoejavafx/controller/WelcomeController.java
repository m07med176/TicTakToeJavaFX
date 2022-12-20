package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.RecordModelData;
import tictaktoejavafx.data.model.SocketConfigModel;
import tictaktoejavafx.utils.AlertAction;
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
        PromptSocketAccessDialog.display(new AlertAction() {
            @Override
            public void sendOk() {
                SocketConfigModel data = new SocketConfigModel("127.0.0.1",5005);
                Navigator.navigate(Navigator.LOGIN, stage,data);
            }
            @Override
            public void sendCancel() {}
        });
        
        
    }

    protected void isRecorded(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.TABLE_RECORD, stage);
    }
    
    @Override
    protected void isHistoryMode(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.HISTORY, stage);
    }

}
