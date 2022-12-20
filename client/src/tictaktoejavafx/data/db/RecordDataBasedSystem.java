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
import javafx.scene.control.Button;
import tictaktoejavafx.data.model.RecordModelData;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class RecordDataBasedSystem {

    public static RecordDataBasedSystem singletone;
    public static RecordModelData recordModelData;
    public static boolean newGame = true;

    private RecordDataBasedSystem() {
        recordModelData = new RecordModelData();
    }

    public static RecordDataBasedSystem getInstance() {
        if (singletone == null) {
            singletone = new RecordDataBasedSystem();
        }
        return singletone;
    }

    public static void saveRecordSession(String type) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        recordModelData.setDateGame(date.toString());
        recordModelData.setPlayerXName(Navigator.getPlayerOne());
        recordModelData.setPlayerOName(Navigator.getPlayerTwo());
        recordModelData.setType(type);
    }

    public static void saveRecord(boolean isRecorded, Button button, String number) {
        recordModelData.add(number + button.getText());
        if (isRecorded) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)))) {
                List<RecordModelData> player = new ArrayList();
                java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordModelData>>() {
                }.getType();
                Gson gson = new Gson();
                try {
                    player = gson.fromJson(bufferedReader, listType);
                } catch (JsonIOException ex) {
                    ex.printStackTrace();
                }

                if (newGame) {
                    player.add(recordModelData); // change 
                    newGame = false;
                } else {
                    player.remove(player.size() - 1);
                    player.add(recordModelData);
                }

                FileWriter fileWriter = new FileWriter(new File(Config.REC_FILE));
                new Gson().toJson(player, fileWriter);
                fileWriter.close();
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

//            try {
//                Writer writer = Files.newBufferedWriter(Paths.get(Config.REC_FILE));
//                gson.toJson(recordModelData, writer);
//                writer.close();
//                System.out.println("done");
//            } catch (IOException ex) {
//                Logger.getLogger(RecordDataBasedSystem.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }

    
    
    public ArrayList<RecordModelData> getData() {
        System.out.println("Get Data Where my Data");
        ArrayList<RecordModelData> data = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)))) {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordModelData>>() {
            }.getType();
            try {
                data = gson.fromJson(bufferedReader, listType);
            } catch (JsonIOException ex) {
                data = new ArrayList();
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }


}
