package com.helcode.catalogo_sinevol.SQLite.utilidades;

public class tableUsuarios {
    public static final String TABLA_USUARIOS="usuarios";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombreusuario";
    public static final String CAMPO_PASSWORD="password";
    public static final String CAMPO_CONFIRMAR="password_confimar";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+ TABLA_USUARIOS +"("+ CAMPO_ID+" INTEGER AUTOINCREMENT PRIMARY KEY NOT NULL  ,"+ CAMPO_NOMBRE +" TEXT NOT NULL, "+ CAMPO_PASSWORD +" TEXT NOT NULL,"+ CAMPO_CONFIRMAR +" TEXT NOT NULL) ";

}
