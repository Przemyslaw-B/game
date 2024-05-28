package com.mygdx.game.powerUps;

import com.mygdx.game.player.Ship;
import com.mygdx.game.powerUps.addidionalBullet.AdditionalBullet;
import com.mygdx.game.powerUps.addidionalBullet.PickingUpAdditionalBullet;
import com.mygdx.game.powerUps.damageUp.DamageUp;
import com.mygdx.game.powerUps.damageUp.PickingUpDamageUp;
import com.mygdx.game.powerUps.healthUp.HealthUp;
import com.mygdx.game.powerUps.healthUp.PickingUpHealthUp;

public class PickingAllUp {

    Ship player;
    PickingUpHealthUp pickingUpHealthUp;
    PickingUpDamageUp pickingUpDamageUp;
    PickingUpAdditionalBullet pickingUpAdditionalBullet;

    private int playerX;
    private int playerY;
    private int boxX;
    private int boxY;

    public PickingAllUp(Ship player) {
        this.player = player;
        this.pickingUpHealthUp = new PickingUpHealthUp();
        this.pickingUpDamageUp = new PickingUpDamageUp();
        this.pickingUpAdditionalBullet = new PickingUpAdditionalBullet();
    }

    public void checkAndPickUp(){

    }




    private void checkDamageUp(){

    }

    private void checkAdditionalBullet(){



    }

    private void setPlayerParameters(){
        this.playerX = player.getPosition().getShipPositionX();
        this.playerY = player.getPosition().getShipPositionY();
    }

    private void setBoxParameters(HealthUp picked){
        this.boxX = picked.getPosition().getX();
        this.boxY = picked.getPosition().getY();
    }
    private void setBoxParameters(DamageUp picked){
        this.boxX = picked.getPosition().getX();
        this.boxY = picked.getPosition().getY();
    }
    private void setBoxParameters(AdditionalBullet picked){
        this.boxX = picked.getPosition().getX();
        this.boxY = picked.getPosition().getY();
    }

    private boolean comparePosition(HealthUp picked){
        return false;
    }

    private boolean comparePosition(DamageUp picked){
        return false;
    }

    private boolean comparePosition(AdditionalBullet picked){
        return false;
    }

}
