package com.mygdx.game.display.powerUps;

import com.mygdx.game.display.Drop;
import com.mygdx.game.powerUps.SpawnedPowerUps;
import com.mygdx.game.powerUps.addidionalBullet.AdditionalBullet;

public class DrawAdditionalBullet {

    public DrawAdditionalBullet() {}

    public void draw(){
        if(!SpawnedPowerUps.additionalBulletsArray.isEmpty()){
            for(AdditionalBullet picked : SpawnedPowerUps.additionalBulletsArray){
                int x = picked.getPosition().getX();
                int y = picked.getPosition().getY();
                Drop.batch.draw(picked.getSkin().getTexture(), x, y);
            }
        }
    }
}
