package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ship {
    private int health;
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
