package server.utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public class UserMessage extends Alert {
    public UserMessage() {
        super(AlertType.CONFIRMATION);
    }

    public void display(String message,AlertAction action,AlertType type) {
        setAlertType(type);
        setContentText(message);
        showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK || response == ButtonType.APPLY || response == ButtonType.NEXT || response == ButtonType.NEXT) {
               action.sendOk();
            }
            if(response == ButtonType.CANCEL || response == ButtonType.CLOSE  || response == ButtonType.NO || response == ButtonType.PREVIOUS || response == ButtonType.FINISH){
                action.sendCancel();
            }
        });
    }
    
    public void alert(String alertMessage,AlertAction action) {
        setAlertType(AlertType.ERROR);
        setContentText("We Are In Trouble "+"\n"+alertMessage);
        showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK || response == ButtonType.APPLY || response == ButtonType.NEXT || response == ButtonType.NEXT) {
               action.sendOk();
            }
            if(response == ButtonType.CANCEL || response == ButtonType.CLOSE  || response == ButtonType.NO || response == ButtonType.PREVIOUS || response == ButtonType.FINISH){
                action.sendCancel();
            }
        });
    }
    
}
