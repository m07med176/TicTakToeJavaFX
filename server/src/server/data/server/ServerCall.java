package server.data.server;

public interface ServerCall{

   /**
     * @param id of second Player
     */
     public void sendInvetation(String id);
     
     /**
      * 
      * @return String id of Player
      */
     
     public String receiveInvetation(); 
     
     public String sendPlayers();
     
     public void setMovement(int btnID,char type,int userId);
     public int getMovement();
};
