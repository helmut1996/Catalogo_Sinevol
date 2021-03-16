package com.helcode.catalogo_sinevol.model;

import java.io.Serializable;

public class itemList  implements Serializable {
    private String Nombre;
    private String Marca;
    private double PrecioC;
    private int Imagen;

    public itemList() {
    }

    public itemList(String nombre, String marca, double precioC, int imagen) {
        Nombre = nombre;
        Marca = marca;
        PrecioC = precioC;
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public double getPrecioC() {
        return PrecioC;
    }

    public void setPrecioC(double precioC) {
        PrecioC = precioC;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}

