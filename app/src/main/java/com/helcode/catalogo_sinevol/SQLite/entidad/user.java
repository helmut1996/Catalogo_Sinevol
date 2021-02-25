package com.helcode.catalogo_sinevol.SQLite.entidad;

public class user {
private int id;
private String npmbreU;
private String password;

    public user() {
    }

    public user(int id, String npmbreU, String password) {
        this.id = id;
        this.npmbreU = npmbreU;
        this.password = password;
    }

    public String getNpmbreU() {
        return npmbreU;
    }

    public void setNpmbreU(String npmbreU) {
        this.npmbreU = npmbreU;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
