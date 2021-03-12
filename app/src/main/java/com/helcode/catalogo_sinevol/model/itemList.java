package com.helcode.catalogo_sinevol.model;

import java.io.Serializable;

public class itemList  implements Serializable {
    private String Nombre;
    private  String Presentacion;
    private double PrecioC;
    private String Imagen;


    public itemList(String nombre, String presentacion, double precioC, String imagen) {
        Nombre = nombre;
        Presentacion = presentacion;
        PrecioC = precioC;
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        Presentacion = presentacion;
    }

    public double getPrecioC() {
        return PrecioC;
    }

    public void setPrecioC(double precioC) {
        PrecioC = precioC;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
