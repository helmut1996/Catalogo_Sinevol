package com.helcode.catalogo_sinevol.Entity;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Unique;


public class Usuarios extends SugarRecord {
    @Unique
    @Column(name = "nombre_usuario")
private String nombreUsuario;
    @Column(name = "password")
private String passUsuario;

    public Usuarios() {

    }

    public Usuarios(String nombreUsuario, String passUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passUsuario = passUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
}
