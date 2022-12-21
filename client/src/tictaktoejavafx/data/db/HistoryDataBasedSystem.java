package tictaktoejavafx.data.db;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tictaktoejavafx.data.model.HistoryDataModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class HistoryDataBasedSystem {

     public static ArrayList<HistoryDataModel> getPlayerModleList() throws IOException,JsonIOException {
          ArrayList<HistoryDataModel> data = new ArrayList();
          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)));
          Gson gson = new Gson();
          java.lang.reflect.Type listType = new TypeToken<ArrayList<HistoryDataModel>>() {
          }.getType();
          data = gson.fromJson(bufferedReader, listType);
          bufferedReader.close();
          return data;
     }

     public static void saveFile(String winnerName) throws IOException,JsonIOException {
          HistoryDataModel playerModel = getHistorySessionData(winnerName);
          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)));
          Gson gson = new Gson();
          List<HistoryDataModel> player;
          java.lang.reflect.Type listType = new TypeToken<ArrayList<HistoryDataModel>>() {
          }.getType();
          player = gson.fromJson(bufferedReader, listType);
          player.add(playerModel);
          FileWriter fileWriter = new FileWriter(new File(Config.HIST_FILE));
          gson.toJson(player, fileWriter);
          fileWriter.close();
          bufferedReader.close();
     }

     private static HistoryDataModel getHistorySessionData(String winnerName) {
          return new HistoryDataModel(Navigator.getPlayerOne(), Navigator.getPlayerTwo(),winnerName);
     }

}
