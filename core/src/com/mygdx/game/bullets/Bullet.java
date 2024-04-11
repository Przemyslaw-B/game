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
    private int speed;
    private Texture texture;
    private boolean friendlyFire;
    int rotation;
    int[] vector;

    public Bullet(int x, int y, int damage, int id, int rotation){
        setBulletX(x);
        setBulletY(y);
        this.vector = new int[2];
        vector[0]=0;
        vector[1]=0;
        speedX = 0; //TODO TEST VALUE
        speedY = 600;    //TODO TEST VALUE
        speed = 600;
        this.shipId = id;
        setBulletTexture(id);
        setFriendlyFire(id);
        this.damage = damage;

        this.rotation = rotation;
        //setVector(vectorX, vectorY);
    }

    public void setVector(int x, int y){
        vector[0] = x;
        vector[1] = y;
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

    public void setSpeed(int speed) {
        this.speed=speed;
    }
    public int getSpeed() {
        return speed;
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
    public void moveBullet(float delta) {
        double c = speed*delta;
        if(rotation == 0){
            y += c;
        } else if(rotation == 90){
            x += c;
        } else if (rotation == 180){
            y -= c;
        } else if(rotation == 270){
            x -= c;
        } else if(rotation == 360){
            y += c;
        }else{
            int[] searched = searchForXY(c);
            if(rotation < 90){
                x += searched[0];
                y += searched[1];
            } else if(rotation < 180){
                x += searched[0];
                y -= searched[1];
            } else if(rotation < 270){
                x -= searched[0];
                y -= searched[1];
            } else {
                x -= searched[0];
                y += searched[1];
            }
        }
    }

    private int[] searchForXY(double c){
        double a=0;
        double b=0;
        int[] searched = new int[2];
        if (rotation > 0 && rotation < 90){
            b = c * Math.sin(Math.toRadians(rotation));
            a =  Math.pow(c,2) - Math.pow(b,2);
            a = Math.sqrt(a);
            //b=-b;
        } else if(rotation > 90 && rotation < 180){
            int val = rotation - 90;
            b = c * Math.sin(Math.toRadians(val));
            a =  Math.pow(c,2) - Math.pow(b,2);
            a = Math.sqrt(a);
        }  else if(rotation < 270 && rotation > 180){
            int val = rotation - 180;
            b = c * Math.sin(Math.toRadians(val));
            a =  Math.pow(c,2) - Math.pow(b,2);
            a = Math.sqrt(a);
        }else if (rotation < 360 && rotation > 270){
            int val = rotation - 270;
            b = c * Math.sin(Math.toRadians(val));
            a =  Math.pow(c,2) - Math.pow(b,2);
            a = Math.sqrt(a);
        }
        searched[0] = (int) b;
        searched[1] = (int) a;
        return searched;
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


    public void setBulletTexture(int id) {
        //TODO wczytywanie textury z bazy
        switch (id){
            case 1:
                this.texture = new Texture("bullets/bullet.png");
                break;

            case 2:
                this.texture = new Texture("bullets/bullet_enemy.png");
                break;

            default:
                this.texture = new Texture("bullets/bullet_enemy.png");
                break;
        }
    }


}
