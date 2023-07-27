package com.mygdx.game.database;

import java.sql.Connection;

public class Enemy {
    private Connection con;

    public Enemy(Connection con){
        this.con=con;
    }
}
