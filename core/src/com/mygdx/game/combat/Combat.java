package com.mygdx.game.combat;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.player.Ship;
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
        this.bulletsArrayList = new ArrayList<Bullet>();
        this.userShip = userShip;
        this.time=0f;
        this.rand = new Random();
    }

    public void spawnEnemy(int enemyId){
        int enemyY = Gdx.app.getGraphics().getHeight();
        int enemyX = rand.nextInt(Gdx.app.getGraphics().getWidth());
        enemyArrayList.add(new Enemy(enemyX, enemyY, enemyId));
    }

    public void removeDeadEnemy(){
        for(int i=enemyArrayList.size()-1; i>=0; i++){
            if(!enemyArrayList.get(i).isAlive()){
                enemyArrayList.remove(i);
            }
        }
    }

    public void moveBullet(float delta){
        for(Bullet pickedBullet : bulletsArrayList){
            pickedBullet.moveBullet(delta);
        }
    }

    public void enemyMove(float delta){
        if(enemyArrayList.size() > 0){
            for(Enemy pickedEnemy : enemyArrayList){
                //todo podzielić Klase ENEMY na dodatkowo Move
                int enemyX = pickedEnemy.getX();
                enemyX += pickedEnemy.getSpeedX();
                int enemyY = pickedEnemy.getY();
                enemyY += pickedEnemy.getSpeedY();
                pickedEnemy.setX(enemyX);
                pickedEnemy.setY(enemyY);
            }
        }
    }
    public void enemyBullets(float delta , Enemy enemy){
        if(bulletsArrayList.size()>0){
            for (Bullet bullet: bulletsArrayList) {
                bullet.moveBullet(delta);
            }
        }
    }

    public void drawAllBullets(){
        for(Bullet pickedBullet : bulletsArrayList){
            pickedBullet.drawBullet();
        }
    }

    public void tickOfBattle(float delta){
        this.time += delta;
        enemyMove(delta);
        enemyShoot(delta);
        if(Gdx.input.isTouched()){
            userShoot(delta);
        }
        moveBullet(delta);
        drawAllBullets();
        removeDeadEnemy();
    }

    private void enemyShoot(float delta){
        if(enemyArrayList.size() > 0){
            for(int i=0; i < enemyArrayList.size(); i++){
                Enemy enemy = enemyArrayList.get(i);
                if(enemy.canShoot(delta)){
                    bulletsArrayList.add(enemy.shot());
                }
            }
        }
    }

    private void userShoot(float delta){
        if(userShip.canShoot(delta)){
            bulletsArrayList.add(userShip.shot());
        }
    }
    public boolean checkUserCollision(){
        //TODO sprawdzenie czy statek użytkownika nie zderzył się ze statkiem wroga
        return false;
    }

    public boolean checkEnemyHit(){
        //TODO sprawdzenie czy pocisk przeciwnika trafił statek użytkownika
        return false;
    }

    public boolean checkUserBulletHit(){
        //TODO sprawdzenie czy pocisk gracza trafił jakiś statek przeciwnika
        return false;
    }
}
