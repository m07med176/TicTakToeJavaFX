package tictaktoejavafx.utils;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PromptSocketAccessDialog {
   
        public static String display(AlertAction alertAction) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
         
        TextField text1 = new TextField();
        TextField text2 = new TextField();
         
        Button saveBtn = new Button("Save");
        Button cancelBtn = new Button("Cancel");
        saveBtn.setOnAction(e -> {
             text1.getText();
            text2.getText();
             stage.close();
             alertAction.sendOk();
        });
         cancelBtn.setOnAction(e -> {
             text1.getText();
             text2.getText();
             stage.close();
             alertAction.sendCancel();
        });
     
        Label label = new Label(" port and ip address ");
       
         
        GridPane layout = new GridPane();
         
        layout.setPadding(new Insets(10, 10, 10, 10)); 
        layout.setVgap(5); 
        layout.setHgap(5); 
         
        layout.add(text1, 1,1);
        layout.add(text2, 1,2);
        layout.add(saveBtn, 1,3);
        layout.add(cancelBtn,2,3);
        
   
         
        Scene scene = new Scene(layout, 250, 150);          
        stage.setTitle("Dialog");
        stage.setScene(scene);
        stage.showAndWait();
         
        return "#" ;
    }

}
