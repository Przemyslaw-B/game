package com.mygdx.game;
import com.mygdx.game.bullets.Bullet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.*;

public class Ship {
    private int health;

    private int horizontalAccelerate;
    private int veritcalAccelerate;
    private int bulletType;
    private int bulletAmount;
    private int sideBulletAmount;
    private Texture shipTexture;
    private TextureRegion shipMyTextureRegion;
    private int width;
    private int height;
    private int shipWidth;
    private int shipLength;
    private int shipX;
    private int shipY;

    private Bullet myBullet;

    //TODO bullet do wywalenia z klasy Ship
    List<List<Integer>> bullets;
    private int bulletX;
    private int bulletY;
    private int bulletAccelerateX=0;
    private int bulletAccelerateY=30;

    public Ship(){
        setHealthAmount(1);
        setBulletAmount(1);
        setShipTexture("ship.png");
        this.height = Gdx.app.getGraphics().getHeight(); //user device
        this.width = Gdx.app.getGraphics().getWidth();   //user device
        this.shipMyTextureRegion = new TextureRegion(shipTexture);
        this.shipWidth = shipMyTextureRegion.getRegionWidth();
        this.shipLength = shipMyTextureRegion.getRegionHeight();
        this.shipX = width/2;
        this.shipY = height/2;
        this.horizontalAccelerate = setDefaultHorizontalAccelerate();    //default accelerate
        this.veritcalAccelerate = setDefaultVerticalAccelerate();
    }

    public void shipControl(int inputX, int inputY, float delta){
        inputY = height-inputY;
        int differenceX = inputX-shipX;
        int differenceY = inputY-shipY;

        //moving X
        if(differenceX > 0){    //move to the right
            if(differenceX < horizontalAccelerate){
                this.shipX = inputX;
            } else{
                this.shipX += horizontalAccelerate;
            }
        } else if(differenceX < 0){ //move to the left
            if(-1*differenceX < horizontalAccelerate){
                this.shipX = inputX;
            } else {
                this.shipX -= horizontalAccelerate;
            }
        } else{ //move straight
        }

        //moving Y
        if(differenceY > 0){    //move up
            if(differenceY < veritcalAccelerate){
                this.shipY = inputY;
            } else{
                this.shipY += veritcalAccelerate;
            }
        } else if(differenceY < 0){ //move down
            if(-differenceY < veritcalAccelerate){
                this.shipY = inputY;
            } else {
                this.shipY -= veritcalAccelerate;
            }
        } else{ // stay still
        }
    }
    public void setShipHorizontalAccelerate(int accelerate){
        this.horizontalAccelerate = accelerate;
    }
    public int getShipHorizontalAccelerate(){
        return horizontalAccelerate;
    }

    public void addShipHorizontalAccelerate(){
        horizontalAccelerate += 1;
    }

    private int setDefaultHorizontalAccelerate(){
        int value = 10;
        return value;
    }

    private int setDefaultVerticalAccelerate(){
        int value = 15;
        return value;
    }

    public int getShipVerticalAccelerate(){
        return veritcalAccelerate;
    }

    public void setShipVerticalAccelerate(int accelerate){
        this.veritcalAccelerate = accelerate;
    }

    public void addShipVerticalAccelerate(){
        this.veritcalAccelerate+=1;
    }
    public void setShipX(int x){
        this.shipX=x;
    }

    public int getShipX(){
        return shipX;
    }

    public void setShipY(int y){
        this.shipY=y;
    }

    public int getShipY(){
        return shipY;
    }

    public int getShipWidth(){
        return shipWidth;
    }

    public int getShipLength(){
        return shipLength;
    }

    public boolean isAlive(){
        if(health>0){
            return true;
        } else{
            return false;
        }
    }

    private void setShipTexture(String shipTextureName){
        shipTextureName = "ship.png";
        this.shipTexture = new Texture(shipTextureName);
    }

    public Texture getShipTexture(){
        return shipTexture;
    }

    private void setHealthAmount(int amount){
        this.health = amount;
    }

    public int getHealthAmount(){
        return health;
    }

    public void addHealth(){
        this.health += 1;
    }

    private void setBulletAmount(int amount){
        this.bulletAmount = amount;
    }

    public int getBulletAmount(){
        return bulletAmount;
    }

    public void addBullet(){
        this.bulletAmount += 1;
    }

    private void setSideBulletAmount(int amount){
        this.sideBulletAmount = amount;
    }
    public int getSideBulletAmount(){
        return sideBulletAmount;
    }
    public void addSideBullet(){
        this.sideBulletAmount += 1;
    }
}
