package com.helcode.catalogo_sinevol.model;

import java.io.Serializable;

public class
itemList  implements Serializable {
    private String Nombre;
    private String Marca;
    private double PrecioC;
    private double PrecioD;
    private String Imagen;
    private String Codigo;
    private String Unidad_Med;
    private String Presentacion;
    public itemList() {
    }

    public itemList(String nombre, String marca, double precioC, double precioD, String imagen, String codigo, String unidad_Med, String presentacion) {
        Nombre = nombre;
        Marca = marca;
        PrecioC = precioC;
        PrecioD = precioD;
        Imagen = imagen;
        Codigo = codigo;
        Unidad_Med = unidad_Med;
        Presentacion = presentacion;
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

    public double getPrecioD() {
        return PrecioD;
    }

    public void setPrecioD(double precioD) {
        PrecioD = precioD;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getUnidad_Med() {
        return Unidad_Med;
    }

    public void setUnidad_Med(String unidad_Med) {
        Unidad_Med = unidad_Med;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String presentacion) {
        Presentacion = presentacion;
    }
}

