package tictaktoejavafx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.SocketConfigModel;

public class PromptSocketAccessDialog {

     public static String display(CallBackPromptAction callBackPromptAction) {
          Stage stage = new Stage();
          stage.initModality(Modality.APPLICATION_MODAL);
          TextField ipView = new TextField();
          TextField portView = new TextField();

          ipView.setText("127.0.0.1");
          portView.setText("5005");

          Button saveBtn = new Button("Save");
          Button cancelBtn = new Button("Cancel");
          saveBtn.setOnAction(e -> {
               // Catch
               String ip = ipView.getText().trim();
               String port = portView.getText().trim();

               // validation
               if (Utils.isNumeric(port) && Utils.isValidIPAddress(ip)) {
                    callBackPromptAction.clickOk(new SocketConfigModel(ip, Integer.parseInt(port)));
               }
               stage.close();
          });
          cancelBtn.setOnAction(e -> {
               stage.close();
          });

          Label label = new Label(" port and ip address ");

          GridPane layout = new GridPane();

          layout.setPadding(new Insets(10, 10, 10, 10));
          layout.setVgap(5);
          layout.setHgap(5);

          layout.add(ipView, 1, 1);
          layout.add(portView, 1, 2);
          layout.add(saveBtn, 1, 3);
          layout.add(cancelBtn, 2, 3);

          Scene scene = new Scene(layout, 250, 150);
          stage.setTitle("Dialog");
          stage.setScene(scene);
          stage.showAndWait();

          return "#";
     }




}
