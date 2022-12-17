/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.data.db;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import tictaktoejavafx.controller.GameBoardMultiController;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.data.model.RecordModelData;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.LocalMultiPlayer;

/**
 *
 * @author hp
 */
public class RecordData {

    public static RecordModelData recordClass = new RecordModelData();
    public RecordData() {

    }

    public static void saveRecord(boolean isRecorded, Button button, String number) {
        
        Gson gson = new Gson();
        recordClass.add(number + button.getText());

        if (isRecorded) {
            System.out.println("recording");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)))) {
                List<RecordModelData> player;
                java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordModelData>>() {
                }.getType();
                try {
                    player = gson.fromJson(bufferedReader, listType);
                } catch (JsonIOException ex) {
                    player = new ArrayList();
                }
                player.add(recordClass);

                FileWriter fileWriter = new FileWriter(new File(Config.REC_FILE));
                new Gson().toJson(player, fileWriter);
                fileWriter.close();
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
        // if (LocalMultiPlayer.getGameEnded()) {

//            try {
//                Writer writer = Files.newBufferedWriter(Paths.get("src/tictaktoejavafx/data/db/rec.json"));
//                gson.toJson(recordClass, writer);
//                writer.close();
//                System.out.println("done");
//            } catch (IOException ex) {
//                Logger.getLogger(GameBoardMultiController.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }

    public static ArrayList<RecordModelData> getData() {

        return new ArrayList<RecordModelData>();
    }

}
