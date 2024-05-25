package com.mygdx.game.powerUps.addidionalBullet;

import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.player.Ship;
import com.mygdx.game.powerUps.healthUp.Action;
import com.mygdx.game.powerUps.healthUp.Movement;
import com.mygdx.game.powerUps.healthUp.Position;
import com.mygdx.game.powerUps.healthUp.Skin;

public class AdditionalBullet {
    private com.mygdx.game.powerUps.healthUp.Skin skin;
    private Position position;
    private Movement movement;
    private Action action;

    public AdditionalBullet(TexturesLoader manager, Ship player, int x, int y){
        this.skin = new Skin(manager);
        this.position = new Position(x,y);
        this.movement = new Movement(position);
        this.action = new Action(player);
    }
}
