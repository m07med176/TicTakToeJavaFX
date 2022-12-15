/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import tictaktoejavafx.data.model.PlayerModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.json.Json;
import javax.json.JsonReader;


public class HistoryController {

    public HistoryController() {
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
