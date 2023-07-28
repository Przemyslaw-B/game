package com.mygdx.game.database;

import java.sql.Connection;

public class PlayerShip {
    private Connection con;

    public PlayerShip(Connection con){
        this.con=con;
    }
}
