package com.mygdx.game;

import com.mygdx.game.enemies.*;

import java.util.ArrayList;

public class Combat {
    private float time;
    private Ship userShip;
    private Enemy enemy;

    private ArrayList<Enemy> enemyArrayList;

    public Combat(){
        this.enemyArrayList = new ArrayList<Enemy>();
    }
}
