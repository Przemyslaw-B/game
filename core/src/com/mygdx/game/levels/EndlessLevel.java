package com.mygdx.game.levels;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.data.Data;
import com.mygdx.game.enemies.Enemy;
import com.mygdx.game.interfaces.levelInterface;

import java.util.Random;

public class EndlessLevel implements levelInterface {
    private int width;
    private int height;
    private int rotation;
    private int defaultRotation;
    private int enemyAmount;
    private int enemyLevel;
    private Random random;
    private int maxEnemyID;
    private float time;

    private boolean test = false;


    public EndlessLevel(){
        this.random = new Random();
        this.time = 0f;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        Data.setDefault.resetEnemyToDefault();
    }

    private int getRng(int min, int max){
        return random.nextInt(max-min) + min;
    }

    private void spawnEnemy(int amount){
        int enemyId = 2;
        boolean isleftSite;
        boolean isFromTop;
        for(int i=0; i<amount; i++){
        //TODO for test;
            Combat.spawnEnemy(enemyId, width/2,height/2, 250, true);
        }
    }

    public void tickOfLevel(float locTime){
        time += locTime;

        if(time > 3f && test == false){
            test = true;
            System.out.println("~~~ It's time for a new ENEMY! ~~~");
            spawnEnemy(1);
        }
    }

}
