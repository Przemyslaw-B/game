package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.bullets.*;

import java.util.ArrayList;

public class Enemy {
    public Statistics statistics;
    public Skin skin;
    public Position position;
    public Actions actions;
    private int id;
    float timer;

    public Enemy(int x, int y, int id) {
        this.id = id;
        skin = new Skin(id);
        statistics = new Statistics(id);
        position = new Position(x, y);
        timer = 0f;
    }

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
        Bullet bullet = new Bullet(x, y, id);
        timer = 0f;
        return bullet;
    }

}

