package server.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import server.data.model.Player;
import server.utils.Config;

public class DatabaseAccessLayer implements DBOperations {
     private final Connection con;
     private final Statement stmt;
     private ResultSet resultSet;
     private PreparedStatement statement;

     public DatabaseAccessLayer() throws SQLException {
          con = DataBaseConnection.getConnection();
          stmt = con.createStatement();
     }

     @Override
     public int getCountPlayers() throws SQLException {
          int countPlayer = 0;
          statement = con.prepareStatement("SELECT COUNT(*) FROM " + Config.TABLE_NAME);
          resultSet = statement.executeQuery();
          if(resultSet.first()){
               countPlayer = resultSet.getInt(1);
          }
          return countPlayer;
     }

     @Override
     public String addPlayer(Player user) throws SQLException {
          String state = user.getUsername();
          statement = con.prepareStatement("INSERT INTO " + Config.TABLE_NAME + " (id,email,username,password,status) VALUES(?,?,?,?,?)");
          statement.setInt(1, getCurrentId());
          statement.setString(2, user.getEmail());
          statement.setString(3, user.getUsername());
          statement.setString(4, user.getPassword());
          statement.setBoolean(5, true);
          statement.executeUpdate();
          return state;
     }

     @Override
     public boolean updatePlayerStatus(boolean status, String userName) throws SQLException {
          boolean result = true;
          stmt.executeUpdate("UPDATE " + Config.TABLE_NAME + " SET status='"+status+"' WHERE userName='"+userName+"'");
          con.commit();
          if (resultSet == null) 
               result = false;
          return result;
     }

     @Override
     public boolean updateAllPlayersStatus(boolean status) throws SQLException {
          boolean result = true;
          stmt.executeUpdate("UPDATE " + Config.TABLE_NAME + " SET status='"+status+"'");
          statement.setBoolean(1, status);
          if (resultSet == null) 
               result = false;
          return result;
     }
     
     @Override
     public String isPlayer(String userName, String password) throws SQLException {
          String result = null;
          statement = con.prepareStatement("SELECT * FROM " + Config.TABLE_NAME + " WHERE userName=? AND password=?");
          statement.setString(1, userName);
          statement.setString(2, password);
          
          resultSet = statement.executeQuery();
          if (resultSet.next()) {
               result = resultSet.getString(2);
               updatePlayerStatus(true,userName);
          }
          return result;
     }

     @Override
     public ArrayList<Player> getOnlinePlayers() throws SQLException {
          statement = con.prepareStatement("SELECT * FROM " + Config.TABLE_NAME + " WHERE status=?");
          statement.setBoolean(1, true);
          resultSet = statement.executeQuery();
          con.commit();
          return collectionOfPalyers(resultSet);
     }

     @Override
     public ArrayList<Player> getAllPlayers() throws SQLException {
          statement = con.prepareStatement("SELECT * FROM " + Config.TABLE_NAME, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
          resultSet = statement.executeQuery();
          con.commit();
          return collectionOfPalyers(resultSet);
     }

     private int getCurrentId() throws SQLException {
          int id = 0;
          PreparedStatement statement = con.prepareStatement("SELECT * FROM " + Config.TABLE_NAME, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
          resultSet = statement.executeQuery();
          con.commit();
          if (resultSet.last()) {
               id = resultSet.getInt(1)+1;
          }
          return id;
     }

     private ArrayList<Player> collectionOfPalyers(ResultSet resultSet) throws SQLException {
          ArrayList<Player> arrayListPlayer = new ArrayList();
          while (resultSet.next()) {
               arrayListPlayer.add(new Player(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5)));
          }
          return arrayListPlayer;
     }

}
