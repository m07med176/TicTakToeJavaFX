/*

import static sun.audio.AudioPlayer.player;
import tictaktoejavafx.Client;


public class RequestCreator {
    
     public static String login(String userName, String password) {
        JSONObject data = new JSONObject();
        data.put("username", userName);
        data.put("password", password);
        JSONObject request = new JSONObject();
        request.put("request", "login");
        request.put("data", data);
        return JSONValue.toJSONString(request);
    }
       public static String register(String userName, String password) {
        JSONObject data = new JSONObject();
        data.put("username", userName);
        data.put("password", password);
        JSONObject request = new JSONObject();
        request.put("request", "register");
        request.put("data", data);
        return JSONValue.toJSONString(request);
    }
         public static String invitePlayer(String invitedPlayerName) {
        JSONObject data = new JSONObject();
        data.put("invitationSender", player.getUserName());
        data.put("invitationReciever", invitedPlayerName);
        JSONObject request = new JSONObject();
        request.put("request", "game invitation");
        request.put("data", data);
        return JSONValue.toJSONString(request);
    }
           public static String xChoosen() {
        JSONObject data = new JSONObject();
        data.put("invitationSender", player.getUserName());
        data.put("invitationReciever", Client.opponnentName);
        data.put("choise", "X");
        JSONObject request = new JSONObject();
        request.put("request", "XorOChoise");
        request.put("data", data);
        return JSONValue.toJSONString(request);
    }
    
}

 */
