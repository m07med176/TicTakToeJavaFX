/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

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

   // static File historyFile;

   /* public static void createFile() {
        //File fileResult=historyFile;
        if (historyFile == null) {
            historyFile = new File("History.txt");
           // fileResult=historyFile;
           
        }
    }*/

    public static void saveFile(PlayerModel model) {
       
       // File historyFile = new File("History.txt");
       
        
       
       /* try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String data = formatter.format(date);
            data = data + "," + model.getPlayerXName() + "," + model.getPlayerOName() + "," + model.getWinner() + ","
                    + model.getxScore() + "," + model.getoScore() + "\n";

            System.out.println(data);
          File historyFile = new File("History.txt");
          if(!historyFile.exists()){
                        historyFile.createNewFile();
          }
            FileOutputStream fileOutputStream = new FileOutputStream(historyFile,true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            byte[] b = data.getBytes();
            dataOutputStream.write(b);
            // FileWriter fileWriter=new FileWriter(historyFile);
            // fileWriter.write(data);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        String path = "companies.json";
      
 
        try (PrintWriter out = new PrintWriter(new FileWriter(path),true)) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(model);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
