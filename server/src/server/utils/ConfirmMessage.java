package server.utils;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public class ConfirmMessage extends Alert {
    public ConfirmMessage() {
        super(AlertType.CONFIRMATION);
        
    }

    public void display(String message,AlertAction action) {
        setContentText(message);
        showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
               this.close();
               action.sendOk();
            }
            if(response == ButtonType.CANCEL){
                
                action.sendCancel();
            }
        });

    }
}
