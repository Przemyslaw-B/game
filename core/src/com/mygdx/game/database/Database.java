package com.mygdx.game.database;

import java.sql.Connection;

public class Database {
    private Connection con;
    private Connect connect;
    protected Player player;
    protected Enemy enemy;
    protected Ship ship;
    public Database(){
        this.connect = new Connect();
        this.con=connect.getCon();
        this.player = new Player(con);
        this.enemy = new Enemy(con);
        this.ship = new Ship(con);
    }

}
