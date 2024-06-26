package com.mygdx.game.powerUps.healthUp;

import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.player.Ship;

public class HealthUp {
    private Skin skin;
    private Position position;
    private Movement movement;
    private Action action;
    private Statistics statistics;

    public HealthUp(TexturesLoader manager, Ship player, int x, int y){
        this.statistics = new Statistics();
        this.skin = new Skin(manager);
        this.position = new Position(x,y);
        this.movement = new Movement(position, statistics);
        this.action = new Action(player);
    }

    public Skin getSkin(){
        return skin;
    }

    public Position getPosition(){
        return position;
    }

    public Movement getMovement(){
        return movement;
    }
    public Action getAction(){
        return action;
    }
}
