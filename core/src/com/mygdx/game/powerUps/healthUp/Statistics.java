package com.mygdx.game.powerUps.healthUp;

public class Statistics {
    private int health;
    private int moveSpeed;

    public Statistics() {
        health = 1;
        moveSpeed = 500;
    }

    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}

    public int getMoveSpeed() {return moveSpeed;}
    public void setMoveSpeed(int moveSpeed) {this.moveSpeed = moveSpeed;}

}
