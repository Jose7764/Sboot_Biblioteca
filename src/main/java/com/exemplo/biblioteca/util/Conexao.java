package com.exemplo.biblioteca.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String pass = "mysqlPW";
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
}
