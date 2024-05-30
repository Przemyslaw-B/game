package com.mygdx.game.powerUps.healthUp;
import com.mygdx.game.player.Ship;

public class Action {

    private Ship player;

    public Action(Ship player){
        this.player = player;
    }

    public void increaseHealth(){
        player.getStatistics().increaseHealth();
    }


}
