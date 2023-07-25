package com.mygdx.game.bullets;

import com.badlogic.gdx.graphics.Texture;

public interface Bullets {
    int x=0;
    int y=0;
    int speedX=0;
    int speedY=15;
    float damage=1;
    Texture bulletTexture = null;

   public int getBulletX();
   public void setBulletX(int x);
   public int getBulletY();
   public void setBulletY(int y);
   public int getSpeedX();
   public void setSpeedX(int speedX);
   public int getSpeedY();
   public void setSpeedY(int speedY);

   public Texture getBulletTexture();
   public void setBulletTexture(Texture texture);

   public void  moveBullet();

   public boolean getFriendlyFire();
   public void setFriendlyFire(int id);
   public  boolean isOnScreen();


}
