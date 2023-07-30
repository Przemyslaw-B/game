package com.mygdx.game.player;

import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.display.Drop;

public class Ship {
    public static Movement movement;
    public static Position position;
    public static Statistics statistics;
    public static PlayerBullets bullets;
    public static Skin skin;
    private float time;

    public Ship(){
        skin = new Skin();
        position = new Position();
        bullets = new PlayerBullets();
        statistics = new Statistics();
        movement = new Movement();
        time = 0f;
    }

    public void draw(){
        int texturePositionX = position.getShipPositionX() - skin.getShipWidth()/2;
        int texturePositionY = position.getShipPositionY() - skin.getShipHeight()/2;
        Drop.batch.draw(skin.getShipTexture(),  texturePositionX, texturePositionY);
    }

    public boolean canShoot(float delta){
        time+= delta;
        if(time >= 1f/statistics.getAttackSpeed()){
            return true;
        }
        return false;
    }

    public Bullet shot(){
        int x = position.getShipPositionX();
        int y = position.getShipPositionY();
        int id = statistics.getPlayerId();
        Bullet bullet = new Bullet(x, y, id);
        return bullet;
    }

}
