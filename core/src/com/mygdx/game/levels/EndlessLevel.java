package com.mygdx.game.levels;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.data.Data;
import com.mygdx.game.enemies.Enemy;
import com.mygdx.game.interfaces.levelInterface;

import java.util.ArrayList;
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
    private float reqTime = 3f;
    private int amountEnemy = 3;
    private int amountSameEnemy=1;
    private ArrayList enemyQueue;


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

    private void spawnEnemy(boolean isFromTop, boolean isFocusedOnPlayer){
        int enemyId = 2;
        Combat.spawnEnemy(enemyId, width/2,height/2, 250, isFromTop, isFocusedOnPlayer);
    }

    public void tickOfLevel(float locTime) {
        time += locTime;
        if (time > reqTime) {
            if (amountEnemy > 0) {
                System.out.println("~~~ It's time for a new ENEMY! ~~~");
                spawnEnemy(false, true);
                amountEnemy--;
                reqTime += 2f;
            }
        }
        if (amountEnemy <= 0) {
            reqTime = time;
            amountEnemy = 3;
        }
    }

    private void chooseEnemyToSpawn(int amount){
        this.amountSameEnemy = amount;
        //TODO add new enemy to queue spawn;
    }


}
