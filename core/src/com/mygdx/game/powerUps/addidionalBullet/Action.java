package com.mygdx.game.powerUps.addidionalBullet;

import com.mygdx.game.player.Ship;

public class Action {
    private Ship player;

    public Action(Ship player) {
        this.player = player;
    }


    public void addMainBullet(){
        player.getStatistics().addMainBullet();
    }

    public void addDiagonalBullet(){
        player.getStatistics().addDiagonalBullet();
    }
}
