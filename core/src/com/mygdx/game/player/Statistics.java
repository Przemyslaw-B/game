package com.mygdx.game.player;

public class Statistics extends Skin{

    private static int shipWidth;
    private static int shipHeight;
    private static int health;
    private static int speedForward;
    private static int speedSideways;


    public Statistics(){
        shipWidth = super.getShipWidth();
        shipHeight = super.getShipHeight();
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

    public int getShipWidth(){
        return shipWidth;
    }

    public int getShipHeight(){
        return shipHeight;
    }
}
