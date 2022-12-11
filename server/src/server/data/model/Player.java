package server.data.model;

public class Player {

    public Player(int id, String email, String username, int password, boolean status) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
    private int id;
    private String email;
    private String username;
    private int password;
    private boolean status;
    
    
}
