package tictaktoejavafx.data.model;

import java.sql.Date;
import java.sql.Time;

public class Session {
    private int id;
    private Date Date;
    private Time start;
    private  Time end;
    private int userId;
    private String playerOne;
    private String playerTwo = "PC";
    
    public Session(int id, Date Date, Time start, Time end, int userId,String playerOne,String playerTwo) {
        this.id = id;
        this.Date = Date;
        this.start = start;
        this.end = end;
        this.userId = userId;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

     public String getPlayerOne() {
          return playerOne;
     }

     public void setPlayerOne(String playerOne) {
          this.playerOne = playerOne;
     }

     public String getPlayerTwo() {
          return playerTwo;
     }

     public void setPlayerTwo(String playerTwo) {
          this.playerTwo = playerTwo;
     }
       
    
    
}
