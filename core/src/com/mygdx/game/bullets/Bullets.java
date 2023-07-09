package com.mygdx.game.bullets;

import com.badlogic.gdx.graphics.Texture;

public interface Bullets {
    int x=0;
    int y=0;
    int speedX=0;
    int speedY=15;
    Texture bulletTexture = null;

   public int getBulletX();
   public void setBulletX(int x);
   public int getBulletY();
   public void setBulletY(int y);

    //TODO dokończyć interface do pocisków



}
