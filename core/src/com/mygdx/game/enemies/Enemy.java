package com.mygdx.game.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.bullets.*;

import java.util.ArrayList;

public class Enemy {
    Statistics statistics;
    Skin skin;
    Position position;
    Actions actions;
    private int id;

    public Enemy(int x, int y, int id) {
        this.id = id;
        skin = new Skin(id);
        statistics = new Statistics(id);
        position = new Position(x, y);
    }

}

