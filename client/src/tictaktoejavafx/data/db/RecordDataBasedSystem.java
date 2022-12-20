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
import tictaktoejavafx.data.model.HistoryDataModel;
import tictaktoejavafx.data.model.RecordDataModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class RecordDataBasedSystem {

     public static RecordDataBasedSystem singletone;
     public static RecordDataModel recordModelData;
     public static boolean newGame = true;

     private RecordDataBasedSystem() {
          recordModelData = new RecordDataModel();
     }

     public static RecordDataBasedSystem getInstance() {
          newGame = true;
          if (singletone == null) {
               singletone = new RecordDataBasedSystem();
          }
          return singletone;
     }

     public static void saveRecord(boolean isRecorded, Button button, String number) throws IOException, JsonIOException {
          recordModelData.add(number + button.getText());
          if (isRecorded) {
               BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)));
               List<RecordDataModel> player = new ArrayList();
               java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordDataModel>>() {
               }.getType();
               Gson gson = new Gson();
               player = gson.fromJson(bufferedReader, listType);
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
          }

     }

     public static void saveRecordSession(String type) {
          recordModelData.setPlayerXName(Navigator.getPlayerOne());
          recordModelData.setPlayerOName(Navigator.getPlayerTwo());
          recordModelData.setType(type);
     }

     public ArrayList<RecordDataModel> getData() throws IOException, JsonIOException {
          ArrayList<RecordDataModel> data = new ArrayList();
          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.REC_FILE)));
          Gson gson = new Gson();
          java.lang.reflect.Type listType = new TypeToken<ArrayList<RecordDataModel>>() {
          }.getType();
          data = gson.fromJson(bufferedReader, listType);
          bufferedReader.close();
          return data;
     }

}
