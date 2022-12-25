package tictaktoejavafx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.SocketConfigModel;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.LoginScreenBase;
import tictaktoejavafx.utils.CallBackAction;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Utils;

public class LoginController extends LoginScreenBase {

     private Stage stage;
     private final SocketConfigModel socketModel;

     public LoginController(Stage stage, Object object) {
          socketModel = (SocketConfigModel) object;
          this.stage = stage;
     }

     @Override
     protected void isLogin(ActionEvent actionEvent) {
          // 1- fetch data
          String userName = this.user_name.getText().trim();
          String passwordUser = this.password.getText().trim();

          if (loginValidation(userName, passwordUser)) {
               try {
                    Navigator.setPlayerOne(userName);
                    ServerConnection.UID = userName;
                    ServerConnection.getInstance(stage, socketModel.getIp(), socketModel.getPort(), (IOException ex) -> {
                         new UserMessage().display("There was a problem in the server\n" + ex.getMessage(), new CallBackAction() {
                              @Override
                              public void sendOk() {
                                   Navigator.navigate(Navigator.WELCOME, stage);
                              }

                              @Override
                              public void sendCancel() {
                                   // Do Nothing
                              }
                         }, Alert.AlertType.ERROR);
                    });
                    ServerConnection.sendMessage(ServerCall.LOGIN_SEND + ServerCall.DELIMETER + userName + ServerCall.DELIMETER + passwordUser);
                    ServerConnection.readThread();
                    this.stage.setOnCloseRequest((WindowEvent event) -> {
                         try {
                              ServerConnection.closeThread();
                         } catch (IOException ex) {
                              new UserMessage().display(ex.getMessage(), new CallBackAction() {
                                   @Override
                                   public void sendOk() {
                                        Navigator.navigate(Navigator.WELCOME, stage);
                                   }

                                   @Override
                                   public void sendCancel() {
                                        // Do Nothing
                                   }
                              }, Alert.AlertType.ERROR);
                         }
                    });
               } catch (IOException ex) {
                    UserMessage.showError("Sorry Server is Down");
                    ex.printStackTrace();
               }

          }
     }

     private boolean loginValidation(String userName, String passwordUser) {
          boolean retVal = true;
          // 2- validate data
          if (passwordUser.isEmpty()) {
               //TODO here we must put dialog Alert or set error     
               password.requestFocus();
               UserMessage.showError("Password is Empty");
               retVal = false;
          }

          if (userName.length() >= 50) {
               user_name.requestFocus();
               retVal = false;
               UserMessage.showError("Length of username is more than 50 character");
          }
          
        if(!Utils.isNumeric(passwordUser)){
            password.requestFocus();
            System.out.println("");
            retVal = false;
            UserMessage.showError("you must enter password as numbers");
        
        }

          if (userName.isEmpty()) {
               //TODO here dialog Alert meesage
               user_name.requestFocus();
               retVal = false;
               UserMessage.showError("you must enter username");
          }
          if(userName.contains("&")){
              user_name.requestFocus();
              retVal=false;
              UserMessage.showError("using & is not allowed");
          }
          return retVal;
     }

     @Override
     protected void CreateAccount(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.REGISTER, stage, socketModel);
     }

     protected void isBack(ActionEvent actionEvent) {
          Navigator.navigate(Navigator.WELCOME, stage);
     }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
}
