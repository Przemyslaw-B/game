package com.mygdx.game.database;

import java.sql.Connection;

public class Player {
    private Connection con;

    public Player(Connection con){
        this.con=con;
    }

    public int getPlayerHealth(){
    int health=1;

    return health;
    }
}