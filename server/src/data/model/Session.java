package data.model;

import java.sql.Date;
import java.sql.Time;

class Session {
    private int id;
    private Date Date;
    private Time start;
    private  Time end;
    private int users_id;
    
    public Session(int id, Date Date, Time start, Time end, int users_id) {
        this.id = id;
        this.Date = Date;
        this.start = start;
        this.end = end;
        this.users_id = users_id;
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

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
       
}
