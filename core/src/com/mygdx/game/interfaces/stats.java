package com.mygdx.game.interfaces;

import com.mygdx.game.player.Statistics;

public interface stats {
    static int id=0;
    static int shipWidth=0;
    static int shipHeight=0;
    static int health=0;
    static float attackSpeed=0;
    static int speedForward=0;
    static int speedSideways=0;

    public void setAttackSpeed(float attackSpeed);
    public float getAttackSpeed();
    public void setId(int Id);
    public int getId();
    public boolean isAlive();
    public void setSpeedForward(int speedForward);
    public int getSpeedForward();
    public void setSpeedSideways(int speedSideways);
    public int getSpeedSideways();
    public int getShipWidth();
    public int getShipHeight();
}
