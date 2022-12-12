package tictaktoejavafx.data.server;

import tictaktoejavafx.data.model.PlayerOnline;

public interface Authentication {
     
     /**
      * @param userName
      * @param password
      * @return String userId Or Null
      **/
     public String loign(String userName,String password);
     
     /**
      * @param player
      * @return String userId Or Null
      **/
     public String register(PlayerOnline player);

     
     
}
