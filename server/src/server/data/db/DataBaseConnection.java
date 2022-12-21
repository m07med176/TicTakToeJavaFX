package server.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;
import server.utils.Config;

public class DataBaseConnection {

    private static Connection con = null;
    
    private DataBaseConnection(){
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {            
                DriverManager.deregisterDriver(new ClientDriver());
                con = DriverManager.getConnection(Config.CONNECTION_STRING, Config.USER_NAME, Config.PASSWORD);
        }
        return con;
    }
    public static void closeConnection() throws SQLException{
        if(con!=null){
        
            con.close();
        }
        
    }

}
