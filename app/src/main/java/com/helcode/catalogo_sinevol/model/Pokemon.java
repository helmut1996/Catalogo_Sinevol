package com.helcode.catalogo_sinevol.model;

public class Pokemon {
    String name;
    String Url;

    public Pokemon(String name, String url) {
        this.name = name;
        Url = url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
