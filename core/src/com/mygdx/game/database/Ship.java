package com.mygdx.game.database;

import java.sql.Connection;

public class Ship {
    private Connection con;

    public Ship(Connection con){
        this.con=con;
    }
}
