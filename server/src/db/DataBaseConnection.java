package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
import server.utils.Configs;

public class DataBaseConnection {

    private static Connection con = null;

    public static Connection getConnection() throws SQLException {

        if (con == null) {

            
                DriverManager.deregisterDriver(new ClientDriver());
                con = DriverManager.getConnection(Configs.CONNECTION_STRING, Configs.USER_NAME, Configs.PASSWORD);
                
            

        }
        return con;
    }
    public static void closeConnection() throws SQLException{
        if(con!=null){
        
            con.close();
        }
        
    }

}
