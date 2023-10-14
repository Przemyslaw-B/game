package com.mygdx.game.bullets;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.display.Drop;

public class Bullet implements Bullets{

    private int shipId;
    private float x;
    private float y;
    private int damage;
    private int speedX;
    private int speedY;
    private Texture texture;
    private boolean friendlyFire;

    public Bullet(int x, int y, int damage, int id){
        setBulletX(x);
        setBulletY(y);
        speedX = 0; //TODO TEST VALUE
        speedY = 600;    //TODO TEST VALUE
        this.shipId = id;
        texture = new Texture("star.png");
        setFriendlyFire(id);
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    @Override
    public float getBulletX() {
        return x;
    }

    @Override
    public void setBulletX(int x) {
        this.x = x;
    }

    @Override
    public float getBulletY() {
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
    public void moveBullet(float delta) {
        x += speedX*delta;
        y += speedY*delta;
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

    public void drawBullet(){
        Drop.batch.draw(texture, x, y);
    }


}
