package com.mygdx.game.database;

import java.sql.Connection;

public class Database {
    private Connection con;
    private Connect connect;
    protected Player player;
    protected Enemy enemy;
    protected PlayerShip ship;
    public Database(){
        this.connect = new Connect();
        this.con=connect.getCon();
        this.player = new Player(con);
        this.enemy = new Enemy(con);
        this.ship = new PlayerShip(con);
    }

}
