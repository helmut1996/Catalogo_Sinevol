package com.helcode.catalogo_sinevol.model;

import java.io.Serializable;

public class
itemList  implements Serializable {
    private String Nombre;
    private String Marca;
    private double PrecioC;
    private double PrecioC2;
    private double PrecioC3;
    private double PrecioC4;
    private double PrecioC5;
    private double PrecioD;
    private double PrecioD1;
    private double PrecioD2;
    private double PrecioD3;
    private double PrecioD4;
    private double PrecioD5;
    private String Imagen;
    private String Codigo;
    private String Unidad_Med;
    private String Presentacion;
    private int Existencia;
    private String Estado;
    public itemList() {
    }

    public itemList(String nombre, String marca, double precioC, double precioC2, double precioC3, double precioC4, double precioC5, double precioD, double precioD1, double precioD2, double precioD3, double precioD4, double precioD5, String imagen, String codigo, String unidad_Med, String presentacion, int existencia, String estado) {
        Nombre = nombre;
        Marca = marca;
        PrecioC = precioC;
        PrecioC2 = precioC2;
        PrecioC3 = precioC3;
        PrecioC4 = precioC4;
        PrecioC5 = precioC5;
        PrecioD = precioD;
        PrecioD1 = precioD1;
        PrecioD2 = precioD2;
        PrecioD3 = precioD3;
        PrecioD4 = precioD4;
        PrecioD5 = precioD5;
        Imagen = imagen;
        Codigo = codigo;
        Unidad_Med = unidad_Med;
        Presentacion = presentacion;
        Existencia = existencia;
        Estado = estado;
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

    public double getPrecioC2() {
        return PrecioC2;
    }

    public void setPrecioC2(double precioC2) {
        PrecioC2 = precioC2;
    }

    public double getPrecioC3() {
        return PrecioC3;
    }

    public void setPrecioC3(double precioC3) {
        PrecioC3 = precioC3;
    }

    public double getPrecioC4() {
        return PrecioC4;
    }

    public void setPrecioC4(double precioC4) {
        PrecioC4 = precioC4;
    }

    public double getPrecioC5() {
        return PrecioC5;
    }

    public void setPrecioC5(double precioC5) {
        PrecioC5 = precioC5;
    }

    public double getPrecioD() {
        return PrecioD;
    }

    public void setPrecioD(double precioD) {
        PrecioD = precioD;
    }

    public double getPrecioD1() {
        return PrecioD1;
    }

    public void setPrecioD1(double precioD1) {
        PrecioD1 = precioD1;
    }

    public double getPrecioD2() {
        return PrecioD2;
    }

    public void setPrecioD2(double precioD2) {
        PrecioD2 = precioD2;
    }

    public double getPrecioD3() {
        return PrecioD3;
    }

    public void setPrecioD3(double precioD3) {
        PrecioD3 = precioD3;
    }

    public double getPrecioD4() {
        return PrecioD4;
    }

    public void setPrecioD4(double precioD4) {
        PrecioD4 = precioD4;
    }

    public double getPrecioD5() {
        return PrecioD5;
    }

    public void setPrecioD5(double precioD5) {
        PrecioD5 = precioD5;
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

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int existencia) {
        Existencia = existencia;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}