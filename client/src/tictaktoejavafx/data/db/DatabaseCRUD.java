package tictaktoejavafx.data.db;

import java.util.ArrayList;
import tictaktoejavafx.data.model.Session;

public interface DatabaseCRUD {
     public void clearDB();
     
     public void startSession(String playerOne,String playerTwo);
     public void endSession(int sessionId);
     public String forwardGame();
     public String backwardGame();
     public ArrayList<Session> getSessions();
}
