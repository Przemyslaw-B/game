package com.mygdx.game.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Bullet {

    private int damage;
    private int accelerateX;
    private int accelerateY;
    private int x;
    private int y;
    private boolean friendlyFire;
    private Texture bulletTexture;
    private int bulletLength;
    private int bulletWidth;

    private int id;

    private TextureRegion bulletTextureRegion;

    /*
    bullets podwójna lista
   najpierw lista pocisków
   druga lista bullet liście bullets
   bullet (x,y, accelerateX, accelerateY, FriendlyFire, idKtoWystrzelił, String textura);
     */

    public Bullet(int x, int y, int id){
        this.x=x;
        this.y=y;
        setFriendlyFire(id);
        setBulletTexture(id);
    }

    public Bullet(int x, int y, int bulletAccelerateX, int bulletAccelerateY, boolean friendlyFire){
        this.x=x;
        this.y = y;
        this.accelerateX=bulletAccelerateX;
        this.accelerateY = bulletAccelerateY;
        this.friendlyFire = friendlyFire;
    }

    private void setFriendlyFire(int id){
        if(id>1){
            this.friendlyFire = true;
        } else{
            this.friendlyFire = false;
        }
    }


    public boolean getFriendlyFire(){
        return friendlyFire;
    }

    private void setBulletTexture(int id){
        String bulletTextureName="but.png";
        this.bulletTexture= new Texture(bulletTextureName);
        this.bulletTextureRegion = new TextureRegion(bulletTexture);
        this.bulletWidth = bulletTextureRegion.getRegionWidth();
        this.bulletLength = bulletTextureRegion.getRegionHeight();
    } //TODO DODAĆ TEXTURĘ POCISKU

    public Texture getBulletTexture(){
        return bulletTexture;
    }

    private void setBulletAccelerate(int id){
        this.accelerateX = 0;
        this.accelerateY = 20;
    }

    public void moveBullet(){
        this.x += accelerateX;
        this.y += accelerateY;
    }

    public int getBulletX(){
        return this.x;
    }

    public int getBulletY(){
        return this.y;
    }
}
