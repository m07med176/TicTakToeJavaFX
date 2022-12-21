package tictaktoejavafx.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.data.model.SocketConfigModel;
import tictaktoejavafx.data.server.ServerCall;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.ExceptionCallBack;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.RegisterScreenBase;

public class RegisterController extends RegisterScreenBase {
    private Stage stage;
    private SocketConfigModel socketModel;
    public RegisterController(Stage stage,Object object) {
        socketModel = (SocketConfigModel) object;
        System.out.println("Choose Register Socket Config "+socketModel.getIp()+"  "+socketModel.getIp());
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

            String registerData = ServerCall.RREGISTER_SEND+ServerCall.DELIMETER + userName + ServerCall.DELIMETER + email + ServerCall.DELIMETER + password;
            System.out.println("Register Data "+registerData);
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
        Navigator.navigate(Navigator.LOGIN, stage,socketModel);
    }

    private boolean validateRegister(String userName, String password, String email, String repeatPassword) {
        boolean retVal = true;
        if (userName.isEmpty()) {
            // TODO here we must put dialog Alert
            user_name_register.requestFocus();
            return retVal = false;
        }
        if (password.isEmpty()) {
            //TODO here we must put dialog Alert
            password_register.requestFocus();
            return retVal = false;
        }
        if (email.isEmpty()) {
            //TODO here we must put dialog Alert
            email_register.requestFocus();
            return retVal = false;
        }
        if (repeatPassword.isEmpty()) {
            //TODO here we must put dialog Alert
            repeat_password_register.requestFocus();
            return retVal = false;
        }

        if (!password.equals(repeatPassword)) {
            repeat_password_register.requestFocus();
            return retVal = false;
        }

        return retVal;

    }

    @Override
    protected void onBackClicked(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.WELCOME, stage);

    }

}
