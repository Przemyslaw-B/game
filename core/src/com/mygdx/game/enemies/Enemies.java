package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullets.*;

import java.util.ArrayList;

public interface Enemies {

    public void setEnemyId(int id);
    public int getEnemyId();
    public void setX(int x);
    public int getX();
    public void setY(int y);
    public int getY();
    public void setSpeedX(int speedX);
    public int getSpeedX();
    public void setSpeedY(int speedY);
    public int getSpeedY();
    public void setTexture();
    public Texture getTexture();
    public void receiveDamage(float damage);
    public boolean isAlive();
    public void setAtackSpeed();
    public float getAttackSpeed();
    public Bullet shot();
    public void setDamage();
    public float getDamage();

}
