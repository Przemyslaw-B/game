package com.mygdx.game.powerUps;

import com.mygdx.game.powerUps.addidionalBullet.AdditionalBullet;
import com.mygdx.game.powerUps.damageUp.DamageUp;
import com.mygdx.game.powerUps.healthUp.HealthUp;

public class MoveAllPowerUps {

    public MoveAllPowerUps(){}

    public void move(float delta){
        moveHealthUps(delta);
        moveDamageUps(delta);
        moveAdditionalBullets(delta);
    }

    private void moveHealthUps(float delta){
        if(!SpawnedPowerUps.healthUpArray.isEmpty()){
            for(HealthUp picked : SpawnedPowerUps.healthUpArray){
                picked.getMovement().move(delta);
            }
        }
    }

    private void moveDamageUps(float delta){
        if(!SpawnedPowerUps.damageUpArray.isEmpty()){
            for(DamageUp picked : SpawnedPowerUps.damageUpArray){
                picked.getMovement().move(delta);
            }
        }
    }

    private void moveAdditionalBullets(float delta){
        if(!SpawnedPowerUps.additionalBulletsArray.isEmpty()){
            for(AdditionalBullet picked : SpawnedPowerUps.additionalBulletsArray){
                picked.getMovement().move(delta);
            }
        }
    }
}
