package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.bullets.*;
import com.mygdx.game.display.Drop;

import java.util.ArrayList;

public class Enemy {
    public Statistics statistics;
    public Skin skin;
    public Position position;
    public Actions action;
    private int id;
    float timer;

    public Enemy(int x, int y, int id) {
        this.id = id;
        this.action = new Actions(statistics);
        skin = new Skin(id);
        statistics = new Statistics(id);
        position = new Position(x, y);
        timer = 0f;
    }

    public Enemy(){}

    public boolean canShoot(float delta){
        timer += delta;
        if(timer >= 1/statistics.getAttackSpeed()){
            return true;
        }
        return false;
    }

    public Bullet shoot(){
        int x = position.getX();
        int y = position.getY();
        int id = statistics.getId();
        int damage = statistics.getDamage();
        Bullet bullet = new Bullet(x, y, damage, id);
        timer = 0f;
        return bullet;
    }

    public void draw(){
        int texturePositionX = position.getX() - skin.getShipWidth()/2;
        int texturePositionY = position.getY() - skin.getShipHeight()/2;
        Drop.batch.draw(skin.getShipTexture(),  texturePositionX, texturePositionY);
    }

}

