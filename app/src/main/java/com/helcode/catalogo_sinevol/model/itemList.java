package com.helcode.catalogo_sinevol.model;

public class itemList {
    private String Nombre;
    private  String Descripcion;
    private double precio;
    private String imgResouce;

    public itemList() {
    }

    public itemList(String nombre, String descripcion, double precio, String imgResouce) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.precio = precio;
        this.imgResouce = imgResouce;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImgResouce() {
        return imgResouce;
    }

    public void setImgResouce(String imgResouce) {
        this.imgResouce = imgResouce;
    }
}
