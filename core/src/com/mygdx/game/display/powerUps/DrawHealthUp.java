package com.mygdx.game.display.powerUps;

import com.mygdx.game.display.Drop;
import com.mygdx.game.powerUps.SpawnedPowerUps;
import com.mygdx.game.powerUps.healthUp.HealthUp;

public class DrawHealthUp {

    public DrawHealthUp(){

    }
    public void draw(){
        if(!SpawnedPowerUps.healthUpArray.isEmpty()){
            for(HealthUp picked : SpawnedPowerUps.healthUpArray){
                int x = picked.getPosition().getX();
                int y = picked.getPosition().getY();
                Drop.batch.draw(picked.getSkin().getTexture(), x, y);
            }
        }
    }
}
