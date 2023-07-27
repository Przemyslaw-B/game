package com.mygdx.game.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect{
    private static Connection con;
    private Statement  stat;
    private static final String URL = "jdbc:sqlite:game.core.main.core/src.mygdx.game.database.DB";
    private static final String Driver = "org.sqlite.JDBC";

    public Connect(){
        try{
            this.con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCon(){
        return con;
    }



}
