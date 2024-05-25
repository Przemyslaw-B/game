package com.mygdx.game.powerUps.damageUp;

import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.player.Ship;


public class DamageUp {

    private Skin skin;
    private Position position;
    private Movement movement;
    private Action action;

    public DamageUp(TexturesLoader manager, Ship player, int x, int y){
        this.skin = new Skin(manager);
        this.position = new Position(x,y);
        this.movement = new Movement(position);
        this.action = new Action(player);
    }

}
