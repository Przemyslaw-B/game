package com.mygdx.game.powerUps.healthUp;

import com.mygdx.game.powerUps.SpawnedPowerUps;

public class PickingUpHealthUp {

    public PickingUpHealthUp(){}

    private void check(){
        if(SpawnedPowerUps.healthUpArray.size() > 0){
            for(int i = SpawnedPowerUps.healthUpArray.size() - 1; i >= 0; i--){
                HealthUp picked = SpawnedPowerUps.healthUpArray.get(i);
                if(comparePosition(picked)){
                    //TODO ACTION.PICKUP.AMD ACTIVATE
                }
            }
        }
    }

    private boolean comparePosition(HealthUp picked){

        return false;
    }
}
