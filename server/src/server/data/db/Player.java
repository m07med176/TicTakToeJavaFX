/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.data.db;

/**
 *
 * @author hp
 */
class Player {
    private int id;
    private String email;
    private String userName;
    private String password;
    private boolean status;

    
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Player(int id, String email, String userName, String password, boolean status) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public Player() {
    }

    
    
}


