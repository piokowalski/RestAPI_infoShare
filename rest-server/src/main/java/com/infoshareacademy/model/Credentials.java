package com.infoshareacademy.model;

public class Credentials {

    private String user;

    private String password;

    public Credentials() {

    }

    public Credentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
