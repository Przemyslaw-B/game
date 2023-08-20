package com.mygdx.game.player;
import com.mygdx.game.interfaces.stats;

public class Statistics extends Skin implements stats {
    private static int id;
    private static int shipWidth;
    private static int shipHeight;
    private static int health;
    private static float attackSpeed;
    private static int speedForward;
    private static int speedSideways;


    public Statistics(){
        shipWidth = super.getShipWidth();
        shipHeight = super.getShipHeight();
        id = 1;
        speedForward = 10; //default value
        speedSideways = 10; //default value
        health = 1; //default value
        attackSpeed = 1; //default value
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
}
