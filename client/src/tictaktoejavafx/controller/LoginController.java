package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class LoginController extends LoginScreenBase {
    private Stage stage;
    private final SocketConfigModel socketModel;
    public LoginController(Stage stage,Object object) {
        socketModel = (SocketConfigModel) object;
        this.stage = stage;
    }

    @Override
    protected void isLogin(ActionEvent actionEvent) {
        // 1- fetch data
        String userName = this.user_name.getText().trim();
        String passwordUser = this.password.getText().trim();
        
        if(loginValidation(userName,passwordUser)){
             try {
                Navigator.setPlayerOne(userName);
                ServerConnection.getInstance(stage,socketModel.getIp(),socketModel.getPort(), (IOException ex) -> {
                    new UserMessage().display("There was a problem in the server\n"+ex.getMessage(), new CallBackAction(){
                        @Override
                        public void sendOk() {
                            Navigator.navigate(Navigator.WELCOME, stage);
                        }
                        
                        @Override
                        public void sendCancel() {
                            // Do Nothing
                        }
                    },Alert.AlertType.ERROR);
                });
                ServerConnection.sendMessage(ServerCall.LOGIN_SEND+ServerCall.DELIMETER+userName+ServerCall.DELIMETER+passwordUser);
                ServerConnection.readThread();
                this.stage.setOnCloseRequest((WindowEvent event) -> {
                    try {
                        ServerConnection.closeThread();
                    } catch (IOException ex) {
                        new UserMessage().display(ex.getMessage(), new CallBackAction(){
                            @Override
                            public void sendOk() {
                                Navigator.navigate(Navigator.WELCOME, stage);
                            }
                            
                            @Override
                            public void sendCancel() {
                                // Do Nothing
                            }
                        },Alert.AlertType.ERROR);
                    }
                });
                //serverConnectionObj.readThread();
            } catch (IOException ex) {
                System.out.println("Server is Down");
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private boolean loginValidation(String userName,String passwordUser) {
        boolean retVal = true;
        // 2- validate data
        if (passwordUser.isEmpty()) {
            //TODO here we must put dialog Alert or set error     
            password.requestFocus();
            System.out.println("you must enter password");
            retVal = false;
        }
        
        if (userName.isEmpty()) {
            //TODO here dialog Alert meesage
            user_name.requestFocus();
            System.out.println("you must enter username");
            retVal = false;
        }
        return retVal;
    }
    

    @Override
    protected void CreateAccount(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.REGISTER, stage,socketModel);
    }
      @Override
    protected void isBack(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.WELCOME, stage);
    }

}
