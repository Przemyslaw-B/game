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
    public Movement movement;
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
        movement = new Movement(position, statistics);
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
        movement = new Movement(position, statistics);
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
        //Bullet bullet = new Bullet(x, y, damage, id, skin.getRotation());
        //Bullet bullet = new Bullet(x, y, damage, id, position.getRotation());
        int angle = calculateAngle(x, y);
        Bullet bullet = new Bullet(x, y, damage, id, angle);
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
    public int getId(){return id;}

    private int calculateAngle(int startingX, int startingY){
        int angle=0;
        int playerX = com.mygdx.game.player.Position.getShipPositionX();
        int playerY = com.mygdx.game.player.Position.getShipPositionY();
        double x = mod(startingX-playerX);
        double y = mod(startingY-playerY);
        double c = Math.sqrt((x*x) + (y*y));
        double val = Math.asin(x/c);
        //TODO ODBICIE 0, 90, 180, 270 degree
        System.out.println("Pozycja ENEMY: X: " + startingX + ", Y: " + startingY);
        System.out.println("Pozycja GRACZA: X: " + playerX + ", Y: " + playerY);
        System.out.println("Wylicznony kąt pocisku to: " + val);
        angle = (int) val;
        return angle;
    }

    private int mod (int value){
        if(value <0){
            return -value;
        }
        return value;
    }
}

