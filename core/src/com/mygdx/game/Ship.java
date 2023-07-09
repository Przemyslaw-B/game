package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Ship {
    private int health;
    private int bulletType;
    private int bulletAmount;
    private int sideBulletAmount;
    private Texture shipTexture;
    public Ship(){
        setHealthAmount(1);
        setBulletAmount(1);
        setShipTexture("ship.png");
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
