package com.mygdx.game.powerUps.damageUp;

public class Statistics {

    private int damage;
    private int moveSpeed;

    public Statistics() {
        damage = 1;
        moveSpeed = 500;
    }

    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}

    public int getMoveSpeed() {return moveSpeed;}
    public void setMoveSpeed(int moveSpeed) {this.moveSpeed = moveSpeed;}
}
