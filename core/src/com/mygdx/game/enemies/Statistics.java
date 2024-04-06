package com.mygdx.game.enemies;

import com.mygdx.game.data.Data;
import com.mygdx.game.interfaces.stats;

public class Statistics implements stats {

    private int id;
    private int shipWidth;
    private int shipHeight;
    private int health;
    private int damage;
    private float attackSpeed = 0.4f;
    private int speedForward;
    private int speedSideways;
    private int score;

    public Statistics(int id){
        this.id=id;
        loadDefaultStatistics();
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
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
        return id;
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
        return speedForward;
    }

    @Override
    public void setSpeedSideways(int speedSideways) {

    }

    @Override
    public int getSpeedSideways() {
        return speedSideways;
    }

    @Override
    public int getShipWidth() {
        return 0;
    }

    @Override
    public int getShipHeight() {
        return 0;
    }
    public int getScore(){return score;}

    public void loadDefaultStatistics(){
        this.health = (int) Data.read.readEnemyStat(id, "health");
        this.damage = (int) Data.read.readEnemyStat(id, "damage");
        this.attackSpeed = Data.read.readEnemyStat(id, "attackSpeed");
        this.speedForward = (int) Data.read.readEnemyStat(id, "speedForward");
        this.speedSideways = (int) Data.read.readEnemyStat(id, "speedSideways");
        this.score = (int) Data.read.readEnemyStat(id, "points");
    }
}
