package com.mygdx.game.player;

import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.data.TexturesLoader;
import com.mygdx.game.display.Drop;

public class Ship {
    public static Movement movement;
    public static Position position;
    public static Statistics statistics;
    public static PlayerBullets bullets;
    public static Skin skin;
    private float time;
    int[] vector;
    private TexturesLoader manager;

    public Ship(TexturesLoader manager){
        this.manager = manager;
        skin = new Skin(manager);
        position = new Position();
        //bullets = new PlayerBullets();
        statistics = new Statistics(skin);
        movement = new Movement(position, statistics);
    }

    public void draw(){
        int texturePositionX = position.getShipPositionX() - skin.getShipWidth()/2;
        int texturePositionY = position.getShipPositionY() - skin.getShipHeight()/2;
        //Drop.batch.draw(skin.getShipTexture(),  texturePositionX, texturePositionY);
        skin.setPositionSprite(texturePositionX, texturePositionY);
        skin.getSprite().draw(Drop.batch);
    }

    public boolean canShoot(float shotTimer){
        if(shotTimer >= 1/statistics.getAttackSpeed()){
            return true;
        }
        return false;
    }

    public Bullet shot(){
        int x = position.getShipPositionX();
        int y = position.getShipPositionY();
        int id = statistics.getId();
        int damage = statistics.getDamage();
        Bullet bullet = new Bullet(x, y, damage, id, skin.getRotation(), manager);
        time = 0f;
        return bullet;
    }

}
