package com.mygdx.game.display.powerUps;

import com.mygdx.game.powerUps.SpawnedPowerUps;
import com.mygdx.game.powerUps.damageUp.DamageUp;

public class DrawAllPowerups {

    DrawAdditionalBullet drawAdditionalBullet;
    DrawDamageUp drawDamageUp;
    DrawHealthUp drawHealthUp;

    public DrawAllPowerups(){
        drawHealthUp = new DrawHealthUp();
        drawAdditionalBullet = new DrawAdditionalBullet();
        drawDamageUp = new DrawDamageUp();
    }

    public void draw(){
        drawHealthUp.draw();
        drawDamageUp.draw();
        drawAdditionalBullet.draw();
    }






}
