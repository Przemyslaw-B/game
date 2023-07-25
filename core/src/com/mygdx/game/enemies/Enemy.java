package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullets.*;

import java.util.ArrayList;

public class Enemy implements Enemies{

    private int id;
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private Texture texture;
    private int health;
    private Bullet bullet;
    private float damage;
    private float attackSpeed;
    float time;

    private ArrayList<Bullet> bulletsArray;


    public Enemy(){
        this.bulletsArray=new ArrayList<Bullet>();
        this.time=0f;
    }

    @Override
    public void setEnemyId(int id) {
        this.id=id;
    }

    @Override
    public int getEnemyId() {
        return id;
    }

    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setY(int y) {
        this.y=y;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setSpeedX(int speedX) {
        this.speedX=speedX;
    }

    @Override
    public int getSpeedX() {
        return speedX;
    }

    @Override
    public void setSpeedY(int speedY) {
        this.speedY=speedY;
    }

    @Override
    public int getSpeedY() {
        return speedY;
    }

    @Override
    public void setTexture() {
        //this.texture =    //TODO textura wczytywana z bazy
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void receiveDamage(float damage) {
        this.health -= (int) damage;
    }

    @Override
    public boolean isAlive() {
        if (this.health > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setAtackSpeed() {
        //todo atackSpeed wczytywany z  bazy
        //this.attackSpeed =
    }

    @Override
    public float getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public void shot(float delta) {
        time += delta;
        float timeTillShot = 1/attackSpeed;
        if(timeTillShot >= time){
            this.bullet = new Bullet(x,y, id);
            bulletsArray.add(bullet);
            time=0;
        }
    }

    @Override
    public void setDamage() {
        //todo damage wczytywany z bazy
        //this.damage =
    }

    @Override
    public float getDamage() {
        return damage;
    }
}
