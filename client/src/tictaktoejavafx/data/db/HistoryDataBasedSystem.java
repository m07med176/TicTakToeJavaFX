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
import tictaktoejavafx.data.model.HistoryModel;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;

public class HistoryDataBasedSystem {

     public static ArrayList<HistoryModel> getPlayerModleList() throws IOException {
          ArrayList<HistoryModel> data = new ArrayList();
          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)));
          Gson gson = new Gson();
          java.lang.reflect.Type listType = new TypeToken<ArrayList<HistoryModel>>() {
          }.getType();
          data = gson.fromJson(bufferedReader, listType);
          bufferedReader.close();
          return data;
     }

     public static void saveFile(String winnerName) throws IOException,JsonIOException {
          HistoryModel playerModel = getHistorySessionData(winnerName);
          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Config.HIST_FILE)));
          Gson gson = new Gson();
          List<HistoryModel> player;
          java.lang.reflect.Type listType = new TypeToken<ArrayList<HistoryModel>>() {
          }.getType();
          player = gson.fromJson(bufferedReader, listType);
          player.add(playerModel);
          FileWriter fileWriter = new FileWriter(new File(Config.HIST_FILE));
          gson.toJson(player, fileWriter);
          fileWriter.close();
          bufferedReader.close();
     }

     private static HistoryModel getHistorySessionData(String winnerName) {
          HistoryModel playerModel = new HistoryModel();
          playerModel.setPlayerXName(Navigator.getPlayerOne());
          playerModel.setPlayerOName(Navigator.getPlayerTwo());
          playerModel.setWinner(winnerName);
          return playerModel;

     }

}
