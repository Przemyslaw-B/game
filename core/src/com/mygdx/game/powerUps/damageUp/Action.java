package com.mygdx.game.powerUps.damageUp;

import com.mygdx.game.player.Ship;

public class Action {
    Ship player;
    public Action (Ship player){
        this.player = player;
    }

    public void addDamage(){
        player.getStatistics().increaseDamage();
    }
}
