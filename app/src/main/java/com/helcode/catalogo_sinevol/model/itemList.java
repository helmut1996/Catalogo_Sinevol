package com.helcode.catalogo_sinevol.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class itemList  implements Serializable {
    @SerializedName("Nombre")
    private String Nombre;
    @SerializedName("Presentacion")
    private  String Presentacion;
    @SerializedName("PrecioC")
    private double PrecioC;
    @SerializedName("Imagen")
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
