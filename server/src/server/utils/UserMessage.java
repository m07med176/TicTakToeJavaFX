package server.utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public class UserMessage extends Alert {
    public UserMessage() {
        super(AlertType.CONFIRMATION);
    }

    public void display(String message,CallBackAction action,AlertType type) {
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
    
    public static void showError(String error){
         new UserMessage().display(Config.ERROR_MSG+"\n"+error, new CallBackAction() {
            @Override
            public void sendOk() {
            }

            @Override
            public void sendCancel() {
            }
        }, AlertType.ERROR);
    
    }
    
}
