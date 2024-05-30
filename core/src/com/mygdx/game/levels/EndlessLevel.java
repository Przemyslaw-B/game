package com.mygdx.game.levels;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.data.Data;
import com.mygdx.game.TextureLoader.TexturesLoader;
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
    private TexturesLoader manager;

    private boolean test = false;
    private float reqTime = 3f;
    private int amountEnemy = 3;
    private int amountSameEnemy=1;
    private ArrayList <Enemy> enemyQueue;


    public EndlessLevel(TexturesLoader manager){
        this.manager = manager;
        this.random = new Random();
        this.time = 0f;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        Data.setDefault.resetEnemyToDefault();
        this.enemyQueue = new ArrayList();
    }

    private int getRng(int min, int max){
        int roll = random.nextInt(max - min) + min;
        return roll;
    }

    public static String powerUpDrop(){
        int min = 0;
        int max = 1000;
        Random rand = new Random();
        int roll = rand.nextInt(max - min) + min;

        System.out.println("Wylosowany drop w pkt: " + roll);

        if(roll<7){
            return "damageUp";
        } else if(roll < 30){
            return "addBullet";
        } else if(roll < 80){
            return "healthUp";
        }
        return "addBullet";
    }

    private void spawnEnemy(int x, int y, int enemyId,int rotation, boolean isFromTop, boolean isFocusedOnPlayer){
        Combat.spawnEnemy(enemyId, x,y, rotation, isFromTop, isFocusedOnPlayer, manager);
    }

    //TODO kolejka przeciwników w nowej klasie nie w enemy tylko tempEnemy?
    //TODO przeciwnicy na diagonali nie poruszają się zgodnie z rotacją
    //TODO przeciwnicy na start bardziej  przesunięci
    //TODO ruch przeciwników na boki + góra/dół podczas rozgrywki

    public void tickOfLevel(float locTime) {
        time += locTime;

        if (time > reqTime) {
            chooseEnemyToSpawn(amountEnemy);
            if (!enemyQueue.isEmpty()) {
                spawnEnemy(enemyQueue.get(0).position.getX(), enemyQueue.get(0).position.getY(), enemyQueue.get(0).getId(), enemyQueue.get(0).position.getRotation(), enemyQueue.get(0).getIsFromTop(), enemyQueue.get(0).getIsFocusedOnPlayer());
                enemyQueue.remove(0);
                reqTime += 1.5f;
            }
        }
        if (amountEnemy <= 0) {
            reqTime = time;
            amountEnemy = 1;
        }
    }
    
    private void chooseEnemyToSpawn(int amount){
        this.amountSameEnemy = amount;
        int id = rollID();
        boolean isFromTop = rollIsFromTop();
        boolean isLeft = rollIsLeft();
        int rotation = rollRotation(isFromTop, isLeft);
        boolean isAimedOnPlayer = rollIsAimedOnPlayer(isFromTop);
        int x = width;
        int y = height;
        if(!isFromTop){ //Same starting position for all enemies in cycle spawned on diagonal
            x = rollPositionX(isFromTop, isLeft);
            y = rollPositionY(x, isFromTop);
        }
        while(amountSameEnemy > 0){
            if(isFromTop){  //Different position for enemies in cycle spawned NOT on diagonal
                x = rollPositionX(isFromTop, isLeft);
                y = rollPositionY(x, isFromTop);
            }
            Enemy tempEnemy = new Enemy(x, height, id, rotation, isFromTop, isAimedOnPlayer, manager);
            enemyQueue.add(tempEnemy);
            amountSameEnemy--;
        }
    }

    private int rollID(){
        int id = 2;
        int maxRoll = 2;
        //id = getRng(2,maxRoll);
        return id;
    }

    private boolean rollIsFromTop(){
        int roll = getRng(1, 10);
        if(roll <= 7){
            return true;
        }
        return false;
    }

    private boolean rollIsAimedOnPlayer(boolean isFromTop){
        if(isFromTop){
            return false;
        }
        int roll = getRng(0, 10);
        if(roll >= 0 && roll <= 6){
            return false;
        }
        return true;
    }

    private int rollPositionX(boolean isFromTop, boolean isLeft){
        int x;
        if(isFromTop){
            int roll = getRng(0,2);
            if(roll==1){ //from top left;
                x = -50;
                return x;
            } else if(roll == 2){
                x = getRng(0, width);
                return x;
            } else {
                x = width + 50;
                return x;
            }
        }
        if(isLeft){
            x = -50;
            return x;
        }
        x = width + 50;
        return x;
    }

    private int rollPositionY(int positionX, boolean isFromTop){
        int y;
        if(isFromTop){
            if(positionX < 0 || positionX > width){
                y = getRng((height*3)/4, height);
                return y;
            } else {
                y = height + 50;
                return y;
            }
        }
        y = getRng((int)(height*(2/3)), height);
        return y;
    }

    private boolean rollIsLeft(){
        int roll = getRng(1,10);
        if(roll <= 5){
            return true;
        }
        return false;
    }

    private int rollRotation(boolean isFromTop, boolean isLeft){
        if(isFromTop){
            return 180;
        }
        if(isLeft){
            int roll = getRng(90+30, 90+60);
            return roll;
        }
        int roll = getRng(180 + 30, 180 + 60);
        return roll;
    }


}
