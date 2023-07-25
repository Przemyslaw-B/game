package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.enemies.*;

import java.util.ArrayList;
import java.util.Random;

public class Combat {
    private float time;
    private Ship userShip;
    private Enemy enemy;
    private Bullet bullet;
    private ArrayList<Enemy> enemyArrayList;
    private ArrayList<Bullet>  bulletsArrayList;
    private Random rand;

    public Combat(Ship userShip){
        this.enemyArrayList = new ArrayList<Enemy>();
        this.time=0f;
        this.rand = new Random();
    }

    public void spawnEnemy(int enemyId){
        int enemyY = Gdx.app.getGraphics().getHeight();
        int enemyX = rand.nextInt(Gdx.app.getGraphics().getWidth());
        this.enemy = new Enemy(enemyX, enemyY, enemyId);
    }

    public void removeDeadEnemy(Enemy enemyPick){
        if(!enemyPick.isAlive()){
            enemyArrayList.remove(enemyPick);
        }
    }

    public void enemyMove(float delta){
        int enemiesAmount = enemyArrayList.size();
        Enemy pickEnemy;
        if(enemiesAmount > 0) {
            pickEnemy = enemyArrayList.get(0);
            enemyBullets(delta, pickEnemy);

            for (int i = 0; i < enemiesAmount; i++) {
                pickEnemy = enemyArrayList.get(i);
                if (pickEnemy.isAlive()) {
                    pickEnemy.getBulletArrayList();
                } else {
                    removeDeadEnemy(pickEnemy);
                }
            }
        }

    }
    public void enemyBullets(float delta , Enemy enemy){
        bulletsArrayList = enemy.getBulletArrayList();
        if(bulletsArrayList.size()>0){
            for (Bullet bullet: bulletsArrayList) {
                bullet.moveBullet();
            }
        }
    }

    public void tickOfBattle(float delta){
        this.time += delta;
        enemyMove(delta);
    }
}
