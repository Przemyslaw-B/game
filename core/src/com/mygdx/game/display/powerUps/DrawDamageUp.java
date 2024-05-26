package com.mygdx.game.display.powerUps;

import com.mygdx.game.display.Drop;
import com.mygdx.game.powerUps.SpawnedPowerUps;
import com.mygdx.game.powerUps.damageUp.DamageUp;

public class DrawDamageUp {
    public DrawDamageUp() {}

    public void draw(){
        if(!SpawnedPowerUps.damageUpArray.isEmpty()){
            for(DamageUp picked : SpawnedPowerUps.damageUpArray){
                int x = picked.getPosition().getX();
                int y = picked.getPosition().getY();
                Drop.batch.draw(picked.getSkin().getTexture(), x, y);
            }
        }
    }
}
