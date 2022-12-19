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
import server.utils.Config;

public class DatabaseAccessLayer implements DBCreateReadUpdateDelete {

    private static Connection con;
    private Statement stmt;
    private static ResultSet resultSet;
    private static int resultStatement;
    private PreparedStatement statement;

    public DatabaseAccessLayer() throws SQLException {
        con = DataBaseConnection.getConnection();
        stmt = con.createStatement();
    }

    @Override
    public ArrayList<Player> getOnlinePlayers() {
        ArrayList<Player> players = new ArrayList();
        try {
            statement = con.prepareStatement("SELECT username FROM "+Config.TABLE_NAME+" WHERE status=?");
            statement.setBoolean(1, true);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                players.add(new Player(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getBoolean(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }

    @Override
    public int getCountPlayers() throws SQLException{
        int countPlayer = 0;
          statement = con.prepareStatement("SELECT COUNT(*) FROM "+Config.TABLE_NAME);
          resultSet = statement.executeQuery();
          countPlayer = resultSet.getInt(1);
          return countPlayer;
    }

    @Override
    public String addPlayer(Player user) throws SQLException{
        String state = user.getUsername();
            statement = con.prepareStatement("INSERT INTO " +Config.TABLE_NAME+ " (id,email,username,password,status) VALUES(?,?,?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5, user.isStatus());
            resultStatement = statement.executeUpdate();
            state = state + " data has been added";
        return state;
    }

    @Override
    public boolean updatePlayerStatus(boolean status, int id) throws SQLException{
        boolean result = true;
          resultStatement = stmt.executeUpdate("UPDATE INTO" + Config.TABLE_NAME + "SET status=" + status + "WHERE id=" + id);
          if (resultSet == null) {
              result = false;
          }
        return result;

    }

    @Override
    public String isPlayer(String userName, String password) throws SQLException{
        String result;
            resultSet = stmt.executeQuery("SELECT id FROM " + Config.TABLE_NAME + " WHERE userName=" + userName + " AND password=" + password);
            if (resultSet == null) {
                result = "player Not Found";
            } else {
                result = "Player Found";
            }
        return result;
    }
    
    public static ArrayList<Player> getPlayerData() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Player> arrayListPlayer = new ArrayList();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "+Config.TABLE_NAME, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery();
            connection.commit();
            while(resultSet.next()) {
                arrayListPlayer.add(new Player(resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getString(4),resultSet.getBoolean(5)));
            } 
           
        return arrayListPlayer;
    }

}
