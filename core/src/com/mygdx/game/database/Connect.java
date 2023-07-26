package com.mygdx.game.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect{
    private Connection con;
    private Statement  stat;
    private static final String URL = "jdbc:sqlite:game.core.main.core/src.mygdx.game.database.DB";

    public Connect(){
        try{
            this.con = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
