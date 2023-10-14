package com.mygdx.game.player;

public class Actions extends Ship{

    public void reduceHp(int value){
        int userHealth = statistics.getHealth();
        userHealth -= value;
        statistics.setHealth(userHealth);
    }
}
