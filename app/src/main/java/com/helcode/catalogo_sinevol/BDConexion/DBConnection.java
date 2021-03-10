package com.helcode.catalogo_sinevol.BDConexion;

import java.sql.*;

public class DBConnection {

    private static String ip = "10042.50.190";
    private static String port = "3306";
    private static String Classes = "com.mysql.jdbc.Driver";
    private static String database = "ferrete2_allbd";
    private static String username = "ferr_admin";
    private static String password = "admin12345";
    private Connection connection = null;
    private static String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    private static DBConnection dbConnection;

    public DBConnection(){}

    public void conectar()
    {
        try
        {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBConnection getDbConnection()
    {
        if(dbConnection == null)
        {
            dbConnection = new DBConnection();
            dbConnection.conectar();
        }
        return dbConnection;
    }

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {
        connection = this.connection;
    }
}
