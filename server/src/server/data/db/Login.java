/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.data.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import static org.apache.derby.iapi.reference.ClassName.ResultSet;

/**
 *
 * @author COMPUMARTS
 */
public class Login {
    public static boolean Signin(Users user) {

        try {
            PreparedStatement stmt = Connection.prepareStatement("Select * FROM USERS WHERE username=? and password=?");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());

            ResultSet resultSet   = stmt.executeQuery();
            if (resultSet.next()) {
                stmt.close();
                return true;

            } else {

                stmt.close();
                return false;
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
}
