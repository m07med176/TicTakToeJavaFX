package tictaktoejavafx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.SocketConfigModel;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.ExceptionCallBack;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.utils.Utils;
import tictaktoejavafx.view.RegisterScreenBase;

public class RegisterController extends RegisterScreenBase {

     private Stage stage;
     private SocketConfigModel socketModel;

     public RegisterController(Stage stage, Object object) {
          socketModel = (SocketConfigModel) object;
          System.out.println("Choose Register Socket Config " + socketModel.getIp() + "  " + socketModel.getIp());
          this.stage = stage;
     }

     @Override
     protected void register(ActionEvent actionEvent) {
          // fetch data
          String userName = user_name_register.getText().trim();
          String password = password_register.getText().trim();
          String email = email_register.getText().trim();
          String repeatPassword = repeat_password_register.getText().trim();

          // check Validation
          if (validateRegister(userName, password, email, repeatPassword)) {
               // Navigator.navigate(Navigator.GAMEBOARD, stage);

               String registerData = ServerCall.RREGISTER_SEND + ServerCall.DELIMETER + userName + ServerCall.DELIMETER + email + ServerCall.DELIMETER + password;
               System.out.println("Register Data " + registerData);
               try {
                    ServerConnection.getInstance(stage, socketModel.getIp(), socketModel.getPort(), new ExceptionCallBack() {
                         @Override
                         public void serverException(IOException ex) {
                              ex.printStackTrace();
                         }
                    });

                    System.out.println(registerData);
                    ServerConnection.sendMessage(registerData);
                    ServerConnection.readThread();

               } catch (IOException ex) {
                    ex.printStackTrace();
               }

          }
     }

     @Override
     protected void haveAccount(ActionEvent actionEvent) {
         Navigator.setPlayerStage(Navigator.LOGIN);
          Navigator.navigate(Navigator.LOGIN, stage, socketModel);
     }

     private boolean validateRegister(String userName, String password, String email, String repeatPassword) {
          boolean retVal = true;
          if (userName.isEmpty()) {
               UserMessage.showError("Username is Empty");
               user_name_register.requestFocus();
               retVal = false;
          }
          if (!Utils.isNumeric(password)) {
               UserMessage.showError("Password is not Numbers");
               password_register.requestFocus();
               retVal = false;
          }
          if(password.isEmpty()){
              password_register.requestFocus();
              UserMessage.showError("password is Empty");
              retVal=false;
          
          }
          if (email.isEmpty()) {
               email_register.requestFocus();
               UserMessage.showError("Email is Empty");
               retVal = false;
          }
          if (repeatPassword.isEmpty()) {
               repeat_password_register.requestFocus();
               UserMessage.showError("Password is Empty");
               retVal = false;
          }

          if (!password.equals(repeatPassword)) {
               repeat_password_register.requestFocus();
               UserMessage.showError("Password is Not Equale");
               retVal = false;
               
          }
          
          if (!Utils.isValidEmail(email)) {
               UserMessage.showError("Email is Not Valid");
               repeat_password_register.requestFocus();
               retVal = false;
          }
          if(userName.contains("&")){
              
              UserMessage.showError("using & is not valid");
              user_name_register.requestFocus();
              retVal=false;
          
          }
          if(email.contains("&")){
              email_register.requestFocus();
              UserMessage.showError("using & is not valid");
              retVal=false;
          }
          if(password.contains("&")){
              password_register.requestFocus();
              UserMessage.showError("using & is not valid");
              retVal=false;
          }

          return retVal;

     }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          Navigator.setPlayerStage(Navigator.WELCOME);
          Navigator.navigate(Navigator.WELCOME, stage);

     }

}
