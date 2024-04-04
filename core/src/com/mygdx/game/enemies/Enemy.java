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
    int[] vector;
    private boolean isFromTop;

    //TODO Get rotation from enemy
    //TODO SET shoting direction of enemy

    public Enemy(int x, int y, int id) {
        this.id = id;
        statistics = new Statistics(id);
        this.action = new Actions(statistics);
        skin = new Skin(id);
        position = new Position(x, y);
        timer = 0f;
        this.vector = new int[2];
        vector[0] = 0;
        vector[1] = -1;
    }

    public Enemy(int x, int y, int id, int rotation, boolean isFromTop) {
        this.id = id;
        statistics = new Statistics(id);
        this.action = new Actions(statistics);
        skin = new Skin(id);
        position = new Position(x, y, rotation, isFromTop);
        timer = 0f;
        this.vector = new int[2];
        vector[0] = 0;
        vector[1] = -1;
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
        Bullet bullet = new Bullet(x, y, damage, id, skin.getRotation());
        timer = 0f;
        return bullet;
    }

    public void draw(){
        int texturePositionX = position.getX() - skin.getShipWidth()/2;
        int texturePositionY = position.getY() - skin.getShipHeight()/2;
        //Drop.batch.draw(skin.getShipTexture(),  texturePositionX, texturePositionY);
        skin.setPositionSprite(texturePositionX, texturePositionY);
        skin.setRotation(position.getRotation());
        skin.getSprite().draw(Drop.batch);
    }
}

