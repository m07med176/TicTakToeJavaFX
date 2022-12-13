/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import com.google.gson.Gson;
import tictaktoejavafx.data.model.PlayerModel;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Ahmed
 */
public class HistoryController {

    public HistoryController() {
    }



    public static void saveFile(PlayerModel model) {
       
     
        try (PrintWriter out = new PrintWriter(new FileWriter("History.json"),true)) {

            String jsonString = new Gson().toJson(model);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
