package com.mygdx.game.player;

public class Actions{
    private Statistics statistics;

    public Actions(Statistics statistics){
        this.statistics = statistics;
    }

    public void reduceHp(int value){
        int userHealth = statistics.getHealth();
        userHealth -= value;
        statistics.setHealth(userHealth);
    }
}
