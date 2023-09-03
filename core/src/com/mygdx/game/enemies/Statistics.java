package com.mygdx.game.enemies;

import com.mygdx.game.interfaces.stats;

public class Statistics implements stats {

    private static int id;
    private static int shipWidth;
    private static int shipHeight;
    private static int health;
    private static float attackSpeed = 0.4f;
    private static int speedForward;
    private static int speedSideways;

    public Statistics(int id){
        this.id=id;

    }
    @Override
    public void setAttackSpeed(float attackSpeed) {

    }

    @Override
    public float getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public void setId(int Id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setSpeedForward(int speedForward) {

    }

    @Override
    public int getSpeedForward() {
        return 0;
    }

    @Override
    public void setSpeedSideways(int speedSideways) {

    }

    @Override
    public int getSpeedSideways() {
        return 0;
    }

    @Override
    public int getShipWidth() {
        return 0;
    }

    @Override
    public int getShipHeight() {
        return 0;
    }
}
