/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import tictaktoejavafx.data.model.PlayerModel;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
