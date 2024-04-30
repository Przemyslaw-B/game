package com.mygdx.game.powerUps.healthUp;

import com.mygdx.game.data.TexturesLoader;
import com.mygdx.game.player.Ship;

public class HealthUp {
    private Skin skin;
    private Position position;
    private Movement movement;
    private Action action;

    public HealthUp(TexturesLoader manager, Ship player, int x, int y){
        this.skin = new Skin(manager);
        this.position = new Position(x,y);
        this.movement = new Movement(position);
        this.action = new Action(player);

    }
}
