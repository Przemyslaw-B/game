package com.mygdx.game.powerUps.addidionalBullet;

import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.player.Ship;


public class AdditionalBullet {
    private Skin skin;
    private Statistics statistics;
    private Position position;
    private Movement movement;
    private Action action;

    public AdditionalBullet(TexturesLoader manager, Ship player, int x, int y){
        this.statistics = new Statistics();
        this.skin = new Skin(manager);
        this.position = new Position(x,y);
        this.movement = new Movement(position, statistics);
        this.action = new Action(player);
    }

    public Statistics getStatistics(){return statistics;}

    public Skin getSkin() {return skin;}
    public Position getPosition() {return position;}
    public Action getAction() {return action;}
    public Movement getMovement() {return movement;}
}
