package server.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.data.model.Player;

public abstract class DatabaseAccessLayer implements DatabaseCRUD {

    static Connection con;
    Statement stmt = con.createStatement();
    static ResultSet rs;
    public static String tableName = "player";
    static Player player;
    static int rs2;
    PreparedStatement statement;
    

    public DatabaseAccessLayer() throws SQLException {
        con = DataBaseConnection.getConnection();
    }

    @Override
     public ArrayList<Player> getOnlinePlayers() {
         ArrayList<Player> players=new ArrayList();
         try {
             // TODO get online users from database
             statement=con.prepareStatement("select username from player where status=?");
             statement.setBoolean(1, true);
             rs=statement.executeQuery();
             while(rs.next()){
                 players.add(new Player(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getBoolean(5)));
         
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         return players;
     }


     @Override
     public int getCountPlayers() {
         int countPlayer=0;
         try {
             // TODO get numbers of users from database
             statement=con.prepareStatement("select COUNT(*) from player");
             rs=statement.executeQuery();
             countPlayer=rs.getInt(1);
         } catch (SQLException ex) {
             Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         return countPlayer;
     }
     @Override
     public String addPlayer(Player user) {
         String state=user.getUsername();
         try {
             // TODO add new row of player in database
             statement=con.prepareStatement("insert into player(id,email,username,password,status) values(?,?,?,?,?)");
             statement.setInt(1, user.getId());
             statement.setString(2, user.getEmail());
             statement.setString(3, user.getUsername());
             statement.setInt(4, user.getPassword());
             statement.setBoolean(5, user.isStatus());
             rs2=statement.executeUpdate();
             state=state+" data has been added";
             //return "";
         } catch (SQLException ex) {
             Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         return state;
     }


    @Override
    public boolean updatePlayerStatus(boolean status, int id) {
        
        String queryString = null;
        boolean result=true;
        try {
            
            queryString = new String("update into" + tableName + "set status=true where id=" + id);
            rs2 = stmt.executeUpdate(queryString);
            if (rs == null) {
                result = false;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    @Override
    public String isPlayer(String userName, String password) {
        String queryString = null;
        String result = "null";
        try {
            queryString = new String("select id from " + tableName + " where userName=" + userName + " and password=" + password);
            rs = stmt.executeQuery(queryString);
            if (rs == null) {
                result = "player Not Found";
            } else {
                result = "Player Found";
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    @Override
    public void clearAll() {
        String queryString = null;
        try {
            queryString = new String("delete * from " + tableName);
            int rs2 = stmt.executeUpdate(queryString);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Player getplayer() {
        try {
            player = new Player(rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("userName"),
                    rs.getInt("password"),
                    rs.getBoolean("status"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return player;
    }

}
