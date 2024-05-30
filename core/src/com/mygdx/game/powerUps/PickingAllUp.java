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

    private int playerMaxLeftX;
    private int playerMaxRightX;
    private int playerMaxTopY;
    private int playerMaxBottomY;

    private int boxMaxLeftX;
    private int boxMaxRightX;
    private int boxMaxTopY;
    private int boxMaxBottomY;

    public PickingAllUp(Ship player) {
        this.player = player;
        this.pickingUpHealthUp = new PickingUpHealthUp(player);
        this.pickingUpDamageUp = new PickingUpDamageUp(player);
        this.pickingUpAdditionalBullet = new PickingUpAdditionalBullet(player);
    }

    public void checkAndPickUp(){
        checkHealthUp();
        checkDamageUp();
        checkAdditionalBullet();
    }




    private void checkDamageUp(){
        pickingUpDamageUp.checkAndPickUp();
    }

    private void checkAdditionalBullet(){
        pickingUpAdditionalBullet.checkAndPickUp();

    }

    private void checkHealthUp(){
        pickingUpHealthUp.checkAndPickUp();
    }


}
