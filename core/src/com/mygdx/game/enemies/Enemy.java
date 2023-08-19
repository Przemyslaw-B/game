package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.bullets.*;

import java.util.ArrayList;

public class Enemy  {

    private int id;
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private Texture texture;
    private TextureRegion textureRegion;
    private int health;
    private Bullet bullet;
    private float damage;
    private float attackSpeed;
    private float time;
    private static ArrayList<Bullet> bulletsArray;


    public Enemy(int x, int y, int id){
        this.x = x;
        this.y=y;
        this.id = id;
        this.bulletsArray=new ArrayList<Bullet>();
        this.time=0f;
        attackSpeed = 1f;
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
    public Bullet shot() {
        Bullet bullet = new Bullet(x,y,id);
        return  bullet;
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

    public boolean canShoot(float delta){
        time+=delta;
        if(time >= 1/attackSpeed){
            return true;
        }
        return false;
    }
}
