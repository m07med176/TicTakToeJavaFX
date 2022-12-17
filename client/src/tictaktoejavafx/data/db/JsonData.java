package tictaktoejavafx.data.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tictaktoejavafx.data.model.PlayerModel;


public class JsonData {
        

     public static ArrayList<PlayerModel> getPlayerModleList() {
        ArrayList<PlayerModel> data = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/tictaktoejavafx/data/db/History.json")))) {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<PlayerModel>>() {
            }.getType();
            try {
                data = gson.fromJson(bufferedReader, listType);
            } catch (Exception ex) {
                data = new ArrayList();
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static void saveFile(PlayerModel model) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/tictaktoejavafx/data/db/History.json")))) {
            Gson gson = new Gson();
            List<PlayerModel> player;
            java.lang.reflect.Type listType = new TypeToken<ArrayList<PlayerModel>>() {
            }.getType();
            try {
                player = gson.fromJson(bufferedReader, listType);
            } catch (Exception ex) {
                player = new ArrayList();
            }
            player.add(model);
            FileWriter fileWriter = new FileWriter(new File("src/tictaktoejavafx/data/db/History.json"));
            new Gson().toJson(player, fileWriter);
            fileWriter.close();
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
 
}
