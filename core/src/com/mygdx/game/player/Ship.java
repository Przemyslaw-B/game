package com.mygdx.game.player;

public class Ship {
    public static Movement movement;
    public static Position position;
    public static Statistics statistics;
    public static PlayerBullets bullets;
    public static Skin skin;

    public Ship(){
        skin = new Skin();
        position = new Position();
        bullets = new PlayerBullets();
        statistics = new Statistics();
        movement = new Movement();
    }

}
