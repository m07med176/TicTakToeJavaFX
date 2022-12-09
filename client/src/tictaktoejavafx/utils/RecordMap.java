package tictaktoejavafx.utils;

import java.util.HashMap;
import java.util.Map;


public class RecordMap {
    private static HashMap<Integer,String> record=new HashMap();
    public static void addRecord(int key,String value){
        record.put(key, value);
    }
    public static HashMap getRecord(){
    
        return record;
    }
}
