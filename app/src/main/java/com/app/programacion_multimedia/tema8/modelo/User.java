package com.app.programacion_multimedia.tema8.modelo;

public class User {

    private String ID;
    private String user, pass;

    public User(String ID, String user, String pass) {
        this.ID = ID;
        this.user = user;
        this.pass = pass;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
