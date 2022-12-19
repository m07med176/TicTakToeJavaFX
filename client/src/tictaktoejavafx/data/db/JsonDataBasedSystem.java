package tictaktoejavafx.data.db;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class JsonDataBasedSystem {        

     public static ArrayList<PlayerModel> getPlayerModleList() {
        ArrayList<PlayerModel> data = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)))) {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<PlayerModel>>() {
            }.getType();
             data = gson.fromJson(bufferedReader, listType);
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static void saveFile(String winnerName) {
        PlayerModel playerModel = getHistorySessionData(winnerName);
        
        
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)))) {
            Gson gson = new Gson();
            List<PlayerModel> player;
            java.lang.reflect.Type listType = new TypeToken<ArrayList<PlayerModel>>() {
            }.getType();
            try {
                player = gson.fromJson(bufferedReader, listType);
            } catch (Exception ex) {
                player = new ArrayList();
            }
            
            player.add(playerModel);
            FileWriter fileWriter = new FileWriter(new File(Config.HIST_FILE));
            new Gson().toJson(player, fileWriter);
            fileWriter.close();
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    private static PlayerModel getHistorySessionData(String winnerName) {
        PlayerModel playerModel = new PlayerModel();
        SimpleDateFormat formatter = new SimpleDateFormat(Config.DATETIME);
        Date date = new Date();
        playerModel.setDateGame(date.toString());
        playerModel.setPlayerXName(Navigator.getPlayerOne());
        playerModel.setPlayerOName(Navigator.getPlayerTwo());
        playerModel.setWinner(winnerName);
        return playerModel;
        
    }
 
}
