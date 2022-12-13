package JsonProject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictaktoejavafx.data.model.PlayerModel;
import tictaktoejavafx.model.History;
import java.lang.reflect.Type;

public class HistoryJson {

    public HistoryJson(PlayerModel model) {
        
        
        FileInputStream fis=null;
        try {
            
            File fe=new File("History.json");
            fis = new FileInputStream(fe);
            byte data[]=new byte[fis.available()];
            fis.read(data);
            String str=new String(data);
            
          
            Gson gson=new Gson();
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            List<String> historyList = gson.fromJson(str, listType); 
            
             //////////
             for(String history:historyList){
                 System.out.println(history);
                 //System.out.println(history.getId()+"-"+history.getMovement()+"-"+history.getPlayer()+"-"+history.getSessionsId()+"\n");
             }

// history =gson.fromJson(str,History.class);
                   
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoryJson.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(HistoryJson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

            
    
}
