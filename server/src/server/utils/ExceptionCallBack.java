package server.utils;

import java.io.IOException;
import java.sql.SQLException;

public interface ExceptionCallBack {
     public void serverException(IOException ex);
     public void databaseException(SQLException ex);
}
