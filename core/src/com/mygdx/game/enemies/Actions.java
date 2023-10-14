package com.mygdx.game.enemies;

public class Actions {
    Statistics statistics;

    public Actions(Statistics statistics){
        this.statistics = statistics;
    }

    public void reduceHp(int value){
        int enemyHealth = statistics.getHealth();
        enemyHealth -= value;
        statistics.setHealth(enemyHealth);
    }

}
