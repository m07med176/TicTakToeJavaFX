package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.RegisterScreenBase;

public class RegisterController extends RegisterScreenBase{
    private Stage stage;

    public RegisterController(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    protected void register(ActionEvent actionEvent) {
//    register  r= new register (, , 
//    if(!user_name_register.getText().trim().isEmpty() &&!email_register.grtText().trim()&& )
//       

        // fetch data
        String userName = user_name_register.getText().trim();
        String password= password_register.getText().trim();
        String email= email_register.getText().trim();
        String repeatPassword= repeat_password_register.getText().trim();
        
        // check Validation
        if(validateRegister(userName,password,email,repeatPassword)){
            Navigator.navigate(Navigator.GAMEBOARD, stage);
            
            /*
            if (registration(userName,password,email,repeatPassword))
            {
             // TODO send regestration data in User Model
             // TODO send User Model in registration function in dataAccess layer
            // Sned Success Message if true then navigate or send Error Message
            
            }
            */
        }
          
        
      
        
       
        System.out.println("register");
    }

    
    @Override
    protected void haveAccount(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.LOGIN, stage);
    }

    private boolean validateRegister(String userName, String password, String email, String repeatPassword) {
        boolean retVal = true;
        if(userName.isEmpty())
        {
            //TODO here we must put dialog Alert
            user_name_register.requestFocus();
            return retVal= false;
        }
        if( password.isEmpty())
        {
            //TODO here we must put dialog Alert
            password_register.requestFocus();
            return retVal= false;
        }
        if(email.isEmpty())
        {
            //TODO here we must put dialog Alert
            email_register.requestFocus();
            return retVal= false;
        }
        if(repeatPassword.isEmpty())
        {
            //TODO here we must put dialog Alert
            repeat_password_register.requestFocus();
            return retVal= false;
        }
        
        
    
        return retVal;
        
    }

     @Override
     protected void onBackClicked(ActionEvent actionEvent) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
    
}
