package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.LoginScreenBase;

public class LoginController extends LoginScreenBase {

    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void isLogin(ActionEvent actionEvent) {
        // 1- fetch data
        String userName = this.user_name.getText().trim();
        String passwordUser = this.password.getText().trim();
        
        
        if(loginValidation(userName,passwordUser)){
            Navigator.navigate(Navigator.GAMEBOARD, stage);
            // TODO Pass data in athentication function
            /*
                if (authenticated(userName,passwordUser)){
                    // If true navigate or send error message
                }
            */
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
//    private boolean validate(){
//        StringBuilder errorText=new StringBuilder();
//        if(user_name.getText().isEmpty()){
//            errorText.append("User Name is required");
//            user_name.setBackground();
//        }
//        if(password.getText().isEmpty()){
////            errorText.append("Password is required");
////            password.setBackground();
//                RequiredFieldValidator re = new RequiredFieldValidator();
//        }
//        return errorText.length()==0;
//        
//    }

    @Override
    protected void CreateAccount(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.REGISTER, stage);
    }

}
