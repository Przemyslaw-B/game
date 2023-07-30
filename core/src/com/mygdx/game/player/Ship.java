package com.mygdx.game.player;

import com.mygdx.game.display.Drop;

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

    public void draw(){
        int texturePositionX = position.getShipPositionX() - skin.getShipWidth()/2;
        int texturePositionY = position.getShipPositionY() - skin.getShipHeight()/2;
        Drop.batch.draw(skin.getShipTexture(),  texturePositionX, texturePositionY);
    }

}
