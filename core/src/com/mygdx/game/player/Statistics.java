package com.mygdx.game.player;
import com.mygdx.game.interfaces.stats;
import com.mygdx.game.data.*;

public class Statistics implements stats {
    private static int id;
    private static int damage;
    private static int shipWidth;
    private static int shipHeight;
    private static int health;
    private static float attackSpeed;
    private static int speedForward;
    private static int speedSideways;
    private int bulletAmount;
    private int diagonalBulletAmount;
    private Skin skin;


    public Statistics(Skin skin){
        this.skin = skin;
        shipWidth = skin.getShipWidth();
        shipHeight = skin.getShipHeight();
        loadDefaultStatistics();
        this.diagonalBulletAmount = 0;
        this.bulletAmount = 1;
        //id = 1;
        //speedForward = 10; //default value
        //speedSideways = 10; //default value
        //health = 1; //default value
        //attackSpeed = 1; //default value
    }

    public int getBulletAmount(){return bulletAmount;}
    public void setBulletAmount(int bulletAmount){
        this.bulletAmount = bulletAmount;
        if(bulletAmount > 11){
            bulletAmount = 11;
        }
    }
    public void addMainBullet(){
        if(bulletAmount < 11){
            bulletAmount++;
        }
    }

    public void addDiagonalBullet(){
        if(diagonalBulletAmount < 5){
            diagonalBulletAmount++;
        }
    }

    public int getDiagonalBulletAmount(){return diagonalBulletAmount;}
    public void setDiagonalBulletAmount(int diagonalBulletAmount){this.diagonalBulletAmount = diagonalBulletAmount;}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        Statistics.health = health;
    }

    public void reduceHealth(int value){
        health -= value;
    }

    public void increaseHealth(){
        if(!isHealthMax()){
            health += 1;
        }
    }

    public void increaseDamage(){
        damage += 1;
    }

    private boolean isHealthMax(){
        if(health >= 10){
            health =10;
            return true;
        } else {
            return false;
        }
    }
    public void setAttackSpeed(float attackSpeed){
        Statistics.attackSpeed = attackSpeed;
    }
    public float getAttackSpeed(){
        return attackSpeed;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public boolean isAlive(){
        if(health>0){
            return true;
        } else{
            return false;
        }
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }
    public void setSpeedForward(int speedForward) {
        this.speedForward = speedForward;
    }

    public int getSpeedForward(){
        return speedForward;
    }

    public void setSpeedSideways(int speedSideways){
        this.speedSideways=speedSideways;
    }

    public int getSpeedSideways(){
        return speedSideways;
    }

    public int getShipWidth(){
        return shipWidth;
    }

    public int getShipHeight(){
        return shipHeight;
    }

    public void setDefaultStatistics(){
        Data.setDefault.setDefaultPlayerStats();
    }

    public void loadDefaultStatistics(){
        this.id = (int) Data.read.readPlayerStat("id");
        this.health = (int) Data.read.readPlayerStat("health");
        this.damage = (int) Data.read.readPlayerStat("damage");
        this.attackSpeed = Data.read.readPlayerStat("attackSpeed");
        this.speedForward = (int) Data.read.readPlayerStat("speedForward");
        this.speedSideways = (int) Data.read.readPlayerStat("speedSideways");
    }
}
