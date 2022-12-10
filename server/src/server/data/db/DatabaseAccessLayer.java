package server.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.data.model.Player;

public abstract class DatabaseAccessLayer implements DatabaseCRUD {

    Connection con;
    Statement stmt = con.createStatement();
    ResultSet rs;
    public static String tableName = "player";
    static Player player;

    public DatabaseAccessLayer() throws SQLException {
        con = DataBaseConnection.getConnection();
    }

    @Override
    public ArrayList<Player> getOnlinePlayers() {
        // TODO get online users from database

        return new ArrayList();
    }

    @Override
    public int getCountPlayers() {
        // TODO get numbers of users from database
        return 0;
    }

    @Override
    public String addPlayer(Player user) {
        // TODO add new row of Player in database
        return "";
    }
    @Override
    public boolean updatePlayerStatus(boolean status,String id) {
        try {
            // TODO update status of Player in database
            String queryString = null;
            queryString=new String("update into" + tableName +"set status=true where id" + id);
            int rs = stmt.executeUpdate(queryString);
            
            status=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    @Override
    public String isPlayer(String userName, String password) {
        String queryString = null;
        try {
            queryString = new String("select id from " + tableName + " where userName=" + userName + " and password=" + password);
            rs = stmt.executeQuery(queryString);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return queryString;

    }

    @Override
    public void clearAll() {
        String queryString = null;
        try {
            queryString = new String("delete * from " + tableName);
            int rs = stmt.executeUpdate(queryString);
            

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*private static Player getplayer() {
        try {
            player=new Player(rs.getInt("id"),rs.getString("email"),rs.getString("userName"),
                    rs.getString("password"),rs.getBoolean("status"));
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return player;
    }
*/
}
