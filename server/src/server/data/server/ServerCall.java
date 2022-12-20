package server.data.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public interface ServerCall{
    
     public static final String DELIMETER = ",";
     
     public static final String RREGISTER_SEND = "RREGISTER_SEND";
     public static final String RREGISTER_RECEIVE = "RREGISTER_RECEIVE";
     
     public static final String LOGIN_RECEIVER = "LOGIN_RECEIVER";
     public static final String LOGIN_SEND = "LOGIN_SEND";
     
     public static final String IVETATION_SEND = "IVETATION_SEND";
     public static final String IVETATION_RECEIVE = "IVETATION_RECEIVE";
     
     public static final String CONFIRMATION_SEND = "CONF_SEND";
     public static final String CONFIRMATION_RECEIVE = "CONF_RECEIVE";
     
     public static final String MOVEMENT_SEND = "MOVEMENT_SEND";
     public static final String MOVEMENT_RECEIVE = "MOVEMENT_RECEIVE";
     
     public static final String PLAYER_LIST_SEND = "PLAYER_LIST_SEND";
     public static final String PLAYER_LIST_RECEIVE = "PLAYER_LIST_RECEIVE";
     
     public void invetation(String[] request,String currentID) throws SQLException,IOException;
     
     public void move(String[] request,String currentID) throws SQLException,IOException;
     
     public void confirm(String[] request,String currentID) throws SQLException,IOException;

     public void onlinePlayers(String[] request,DataOutputStream response) throws SQLException,IOException;
     
     public String login(String[] request,DataOutputStream response) throws SQLException,IOException;
     
     public String register(String[] request,DataOutputStream response) throws SQLException,IOException;
     
};
