package com.mygdx.game.powerUps.addidionalBullet;

public class Statistics {
    private int additionalBullet;
    private int moveSpeed;

    public Statistics() {
        additionalBullet = 1;
        moveSpeed = 500;
    }

    public int getAdditionalBullet() {return additionalBullet;}
    public void setAdditionalBullet(int additionalBullet){this.additionalBullet = additionalBullet;}

    public int getMoveSpeed() {return moveSpeed;}
    public void setMoveSpeed(int moveSpeed){this.moveSpeed = moveSpeed;}
}
