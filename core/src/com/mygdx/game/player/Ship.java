package com.mygdx.game.player;

public class Ship {
    public static Movement movement;
    public static Position position;
    public static Statistics statistics;
    public static Bullets bullets;
    public static Skin skin;

    public Ship(){
        Ship.skin = new Skin();
        Ship.position = new Position();
        Ship.bullets = new Bullets();
        Ship.statistics = new Statistics();
        Ship.movement = new Movement();
    }

}
