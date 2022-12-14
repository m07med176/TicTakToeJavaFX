/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import tictaktoejavafx.data.model.PlayerModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class HistoryController {

    public HistoryController() {
    }

    public static void saveFile(PlayerModel model) {
        /*  String dateGame=(String)data.get("");
    String playerXName;
     String playerOName;
    String winner;*/

 /*try {//PrintWriter out = new PrintWriter(new FileWriter("History.json"))) {
             
            Gson json = new Gson();
            String jString = json.toJson(model);
           ArrayList<String> player=new ArrayList<>();
            FileWriter file=new FileWriter("History.json");
            //for(int i=0;i<player.size()-1;i++){
            /*player.add(model.getDateGame());
            player.add(model.getPlayerXName());
            player.add(model.getPlayerOName());
            player.add(model.getWinner());
                file.write(model);
            file.close();*/
        try {

            List<PlayerModel> player = Arrays.asList(model);
            Writer writer = new FileWriter("History.json");
            Gson g = new GsonBuilder().create();
            g.toJson(player, writer);

            writer.close();
            // out.write(jString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
