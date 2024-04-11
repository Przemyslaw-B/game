package com.mygdx.game.bullets;

import com.badlogic.gdx.graphics.Texture;

public interface Bullets {

   public float getBulletX();
   public void setBulletX(int x);
   public float getBulletY();
   public void setBulletY(int y);
   public int getSpeedX();
   public void setSpeedX(int speedX);
   public int getSpeedY();
   public void setSpeedY(int speedY);

   public Texture getBulletTexture();
   public void setBulletTexture(int id);

   public void moveBullet(float delta);

   public boolean getFriendlyFire();
   public void setFriendlyFire(int id);


}
