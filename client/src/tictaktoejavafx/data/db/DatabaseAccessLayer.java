package tictaktoejavafx.data.db;

import java.util.ArrayList;
import tictaktoejavafx.data.model.Session;

public class DatabaseAccessLayer implements DatabaseCRUD{

     @Override
     public void clearDB() {
          // TODO Clear database file system
     }

     @Override
     public void startSession(String playerOne,String playerTwo) {
          // TODO record new Session (data,start, playerone,playertwo) in database file system
     }

     @Override
     public void endSession(int sessionId) {
          // TODO end session (end)
     }

     @Override
     public String forwardGame() {
          // NOt Yet
          return "";
     }

     @Override
     public String backwardGame() {
          // NOt Yet
          return "";
     }

     @Override
     public ArrayList<Session> getSessions() {
          // get all recorded sessions
          return new ArrayList();
     }
     
}
