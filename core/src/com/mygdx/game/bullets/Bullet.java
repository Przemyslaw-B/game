package com.mygdx.game.bullets;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Bullet implements Bullets{

    private int shipId;
    private int x;
    private int y;
    private int screenX;
    private int screenY;
    private int speedX;
    private int speedY;
    private Texture texture;
    private boolean friendlyFire;

    public Bullet(int x, int y, int id){
        setBulletX(x);
        setBulletY(y);
        this.shipId = id;
        this.screenX = Gdx.app.getGraphics().getWidth();
        this.screenY = Gdx.app.getGraphics().getHeight();
    }
    @Override
    public int getBulletX() {
        return x;
    }

    @Override
    public void setBulletX(int x) {
        this.x = x;
    }

    @Override
    public int getBulletY() {
        return y;
    }

    @Override
    public void setBulletY(int y) {
        this.y=y;
    }

    @Override
    public int getSpeedX() {
        return speedX;
    }

    @Override
    public void setSpeedX(int speedX) {
        this.speedX=speedX;
    }

    @Override
    public int getSpeedY() {
        return speedY;
    }

    @Override
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    @Override
    public Texture getBulletTexture() {
        return texture;
    }

    @Override
    public void setBulletTexture(Texture texture) {
    //TODO wczytywanie textury z bazy

    //this.texture=
    }

    @Override
    public void moveBullet() {
        x += speedX;
        y += speedY;
    }

    @Override
    public boolean getFriendlyFire() {
        return friendlyFire;
    }

    @Override
    public void setFriendlyFire(int id) {
        if(id == 1){
            this.friendlyFire = false;
        } else {
            this.friendlyFire = true;
        }
    }

    @Override
    public boolean isOnScreen() {
        if(x > screenX || y > screenY){
            return false;
        } else {
            return true;
        }
    }
}
