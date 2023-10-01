package com.mygdx.game.combat;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.player.Ship;
import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.enemies.*;

import java.util.ArrayList;
import java.util.Random;

public class Combat {
    private float time;
    private float shotTimer;
    private Ship userShip;
    private Enemy enemy;
    private Bullet bullet;
    private static ArrayList<Enemy> enemyArrayList;
    private static ArrayList<Bullet>  bulletsArrayList;
    private Random rand;

    public Combat(Ship userShip){
        this.enemyArrayList = new ArrayList<Enemy>();
        this.bulletsArrayList = new ArrayList<Bullet>();
        this.userShip = userShip;
        this.time=0f;
        this.shotTimer = 0f;
        this.rand = new Random();
    }

    public void spawnEnemy(int enemyId){
        int enemyY = Gdx.app.getGraphics().getHeight();
        int enemyX = rand.nextInt(Gdx.app.getGraphics().getWidth());
        //TODO DO TESTOW WARTOSCI NA STALE
        enemyX=500;
        enemyY=500;
        enemyArrayList.add(new Enemy(enemyX, enemyY, enemyId));
    }

    public void removeDeadEnemy(){
        if(enemyArrayList.size() > 0){
            for(int i=enemyArrayList.size()-1; i>=0; i++){
                if(!enemyArrayList.get(i).statistics.isAlive()){
                    enemyArrayList.remove(i);
                }
            }
        }
    }

    public void moveBullet(float delta){
        System.out.println("Ilość pocisków na mapie: " + bulletsArrayList.size());
        if(bulletsArrayList.size() > 0) {
            for (Bullet pickedBullet : bulletsArrayList) {
                pickedBullet.moveBullet(delta);
                System.out.println("Bullet X: " + pickedBullet.getBulletX() + "Y: " + pickedBullet.getBulletY());
            }
        }
    }

    public void enemyMove(float delta){
        if(enemyArrayList.size() > 0){
            for(Enemy pickedEnemy : enemyArrayList){
                //todo podzielić Klase ENEMY na dodatkowo Move
                /*
                int enemyX = pickedEnemy.getX();
                enemyX += pickedEnemy.getSpeedX();
                int enemyY = pickedEnemy.getY();
                enemyY += pickedEnemy.getSpeedY();
                pickedEnemy.setX(enemyX);
                pickedEnemy.setY(enemyY);
                 */
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
            //System.out.println("Rysuję pocisk!");
        }
    }

    public void drawAllEnemies(){
        for(Enemy pickedEnemy: enemyArrayList){
            pickedEnemy.draw();
        }
    }

    public void tickOfBattle(float delta){
        shotTimer += delta;
        time += delta;

        //System.out.println("Making tick of a battle!");
        //System.out.println("Enemy is moving!");
        //enemyMove(delta);
        //System.out.println("Moving all bullets!");
        moveBullet(delta);
        //System.out.println("Enemy SHOT!");
        //enemyShoot(delta);
        if(Gdx.input.isTouched()){
            userShoot();
        }
        removeBulletNotInView();
        //System.out.println("Drawing all bullets!");
        enemyShoot(delta);  //strzelanie przeciwników
        drawAllEnemies();
        drawAllBullets();
        userShip.draw();
        //System.out.println("Removings dead bodies!");
        //removeDeadEnemy();
    }

    private void enemyShoot(float delta){
        if(enemyArrayList.size() > 0){
            for(int i=0; i < enemyArrayList.size(); i++){
                Enemy enemy = enemyArrayList.get(i);
                if(enemy.canShoot(delta)){
                    bulletsArrayList.add(enemy.shoot());
                }
            }
        }
    }

    private void userShoot(){
        if(userShip.canShoot(shotTimer)){
            shotTimer = 0;
            Bullet newBullet = userShip.shot();
            bulletsArrayList.add(newBullet);
        }
    }

    private void removeBulletNotInView(){
        if(bulletsArrayList.size() > 0){
            for(int i=bulletsArrayList.size()-1; i>=0; i--){
                if(!checkBulletInView(bulletsArrayList.get(i))){
                    bulletsArrayList.remove(i);
                }
            }
        }
    }

     private boolean checkBulletInView(Bullet pickedBullet){
         if(pickedBullet.getBulletY() < 0){
             return false;
         }
         if(pickedBullet.getBulletY() > Gdx.app.getGraphics().getHeight()){
             return false;
         }
         if(pickedBullet.getBulletX() < 0){
             return false;
         }
         if(pickedBullet.getBulletX() > Gdx.app.getGraphics().getWidth()){
            return false;
         }
        return true;
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
