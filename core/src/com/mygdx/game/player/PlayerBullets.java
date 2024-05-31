package com.mygdx.game.player;

import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.bullets.SpawnedBullets;
import com.mygdx.game.powerUps.PowerUp;

import java.util.ArrayList;

public class PlayerBullets {
    //private int bulletType;
    //private int bulletAmount;
    //private int sideBulletAmount;
    Statistics statistics;
    Skin skin;
    Position position;
    TexturesLoader manager;
    private ArrayList<Bullet> playerBulletArray;

    int playerX;
    int playerY;
    int playerWidth;
    float timer;


    public PlayerBullets(Statistics statistics, Position position, Skin skin, TexturesLoader manager){
        this.statistics = statistics;
        this.skin = skin;
        this.position = position;
        this.manager = manager;
        timer=0f;
        this.playerBulletArray = new ArrayList<Bullet>();
    }
    private boolean canShoot(float delta){
        timer += delta;
        if(timer>= 1/statistics.getAttackSpeed()){
            return true;
        }
        return false;
    }

    public boolean shot(Float delta){
        if(canShoot(delta)){
            readPlayerPosition();
            shotMainBullet();
            shotDiagonalBullet();
            timer = 0f;
        }
        return false;
    }

    private void shotMainBullet(){
        int rotation = 0;
        int space = Math.round(playerWidth/10);
        int amountToSpawn = statistics.getBulletAmount();
        int amountToSpawnLeft;
        int amountToSpawnRight;

        if(amountToSpawn == 1){
            addBullet(playerX, playerY, rotation);
            amountToSpawn--;
        } else if(amountToSpawn > 0){
            if(amountToSpawn % 2 != 0){
                addBullet(playerX, playerY, rotation);
                amountToSpawn--;
            }
            int temp = playerX;
            amountToSpawnLeft = amountToSpawn/2;
            amountToSpawnRight = amountToSpawn/2;
            while(amountToSpawnLeft > 0){
                temp -= space;
                addBullet(temp, playerY, rotation);
                amountToSpawnLeft--;
            }
            temp = playerX;
            while(amountToSpawnRight > 0){
                temp += space;
                addBullet(temp, playerY, rotation);
                amountToSpawnRight--;
            }
        }

    }

    private void shotDiagonalBullet(){
        int rotation = 0;
        int spacer = 15;
        int amountToSpawn = statistics.getDiagonalBulletAmount();
        if(statistics.getDiagonalBulletAmount() > 0){
            //Right
            while(amountToSpawn > 0){
                rotation += spacer;
                addBullet(playerX, playerY, 15);
                amountToSpawn--;
            }
            //left
            amountToSpawn = statistics.getDiagonalBulletAmount();
            rotation = 360;
            while(amountToSpawn > 0){
                rotation -= spacer;
                addBullet(playerX, playerY, 345);
                amountToSpawn--;
            }
        }
    }

    private void readPlayerPosition(){
        playerX = position.getShipPositionX();
        playerY = position.getShipPositionY();
        playerWidth = skin.getShipMyTextureRegion().getRegionWidth();
    }

    private void addBullet(int x, int y, int rotation){
        Bullet newBullet = new Bullet(x, y, statistics.getDamage(), statistics.getId(), rotation, manager);
        SpawnedBullets.bulletsArrayList.add(newBullet);
    }





}
