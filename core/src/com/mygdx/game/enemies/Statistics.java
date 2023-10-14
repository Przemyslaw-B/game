package com.mygdx.game.enemies;

import com.mygdx.game.data.Data;
import com.mygdx.game.interfaces.stats;

public class Statistics implements stats {

    private static int id;
    private static int shipWidth;
    private static int shipHeight;
    private static int health;
    private static int damage;
    private static float attackSpeed = 0.4f;
    private static int speedForward;
    private static int speedSideways;

    public Statistics(int id){
        this.id=id;
        loadDefaultStatistics();
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        Statistics.health = health;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
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
        if(health > 0){
            return true;
        }
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

    public void loadDefaultStatistics(){
        this.health = (int) Data.read.readEnemyStat(id, "health");
        this.damage = (int) Data.read.readEnemyStat(id, "damage");
        this.attackSpeed = Data.read.readEnemyStat(id, "attackSpeed");
        this.speedForward = (int) Data.read.readEnemyStat(id, "speedForward");
        this.speedSideways = (int) Data.read.readEnemyStat(id, "speedSideways");
    }
}
