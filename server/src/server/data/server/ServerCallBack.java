package server.data.server;

import java.io.IOException;
import java.sql.SQLException;

public interface ServerCallBack {
     public void serverException(IOException ex);
     public void databaseException(SQLException ex);
     public void requestUpdateDatabase();
}
