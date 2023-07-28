package com.mygdx.game.player;

public class Statistics extends Ship{

    private int shipWidth;
    private int shipHeight;
    private int health;
    private int speedForward;
    private int speedSideways;


    public Statistics(){
        shipWidth = Ship.skin.getShipWidth();
        shipHeight = Ship.skin.getShipHeight();
        speedForward = 10; //default value
        speedSideways = 10; //default value
        health = 1; //default value
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
}
