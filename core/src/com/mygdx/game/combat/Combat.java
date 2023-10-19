package com.mygdx.game.combat;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.display.gui.BattleInterface;
import com.mygdx.game.player.Ship;
import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.enemies.*;
import com.mygdx.game.score.Score;

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
    private BattleInterface battleInterface;
    private Score score;

    public Combat(Ship userShip){
        score = new Score();
        this.enemyArrayList = new ArrayList<Enemy>();
        this.bulletsArrayList = new ArrayList<Bullet>();
        this.userShip = userShip;
        this.time=0f;
        this.shotTimer = 0f;
        this.rand = new Random();
        this.battleInterface = new BattleInterface(score);
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
        if(!enemyArrayList.isEmpty()){
            for(int i=enemyArrayList.size()-1; i>=0; i--){
                if(!enemyArrayList.get(i).statistics.isAlive()){
                    enemyArrayList.remove(i);
                }
            }
        }
    }

    public void moveBullet(float delta){
        //System.out.println("Ilość pocisków na mapie: " + bulletsArrayList.size());
        if(bulletsArrayList.size() > 0) {
            for (Bullet pickedBullet : bulletsArrayList) {
                pickedBullet.moveBullet(delta);
                //System.out.println("Bullet X: " + pickedBullet.getBulletX() + "Y: " + pickedBullet.getBulletY());
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
        if(!enemyArrayList.isEmpty()){
            for(Enemy pickedEnemy: enemyArrayList){
                pickedEnemy.draw();
            }
        }
    }

    public void tickOfBattle(float delta){
        shotTimer += delta;
        time += delta;

        //System.out.println("Making tick of a battle!");
        moveBullet(delta);
        if(Gdx.input.isTouched()){
            userShoot();
        }
        removeBulletNotInView();
        //System.out.println("Drawing all bullets!");
        enemyShoot(delta);  //strzelanie przeciwników
        drawAllBullets();
        drawAllEnemies();
        userShip.draw();
        boolean collision = checkUserCollision();
        //System.out.println("Wynik weryfikacji kolizji z przeciwnikiem: " + collision);

        checkHit();
        //System.out.println("Wynik weryfikacji pomyślnego trafienia: " + checkHit);
        //System.out.println("Removing dead bodies!");
        removeDeadEnemy();
        battleInterface.drawInterface();
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

    public boolean checkUserCollision() {
        //TODO sprawdzenie czy statek użytkownika nie zderzył się ze statkiem wroga
        int[] userCenter = new int[2];
        userCenter[0] = userShip.position.getShipPositionX();
        userCenter[1] = userShip.position.getShipPositionY();

        int userFront = userCenter[1] + userShip.skin.getShipHeight() / 2;
        int userBack = userCenter[1] - userShip.skin.getShipHeight() / 2;
        int userLeft = userCenter[0] - userShip.skin.getShipWidth() / 2;
        int userRight = userCenter[0] + userShip.skin.getShipWidth() / 2;


        if (!enemyArrayList.isEmpty()) {
            for (Enemy pickedEnemy : enemyArrayList) {
                if( checkCollisionForPickedEnemy(userFront, userBack, userLeft, userRight, pickedEnemy)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCollisionForPickedEnemy(int userFront, int userBack, int userLeft, int userRight , Enemy pickedEnemy){

        int[] enemyCenter = new int[2];
        enemyCenter[0] = pickedEnemy.position.getX();
        enemyCenter[1] = pickedEnemy.position.getY();

        int enemyFront = enemyCenter[1] + pickedEnemy.skin.getShipHeight() / 2;
        int enemyBack = enemyCenter[1] - pickedEnemy.skin.getShipHeight() / 2;
        int enemyLeft = enemyCenter[0] - pickedEnemy.skin.getShipWidth() / 2;
        int enemyRight = enemyCenter[0] + pickedEnemy.skin.getShipWidth() / 2;

        //Check Y
        if((userFront >= enemyBack && userFront <= enemyFront) || (userBack >= enemyBack && userBack <= enemyFront) ){
            //Check X
            if((userLeft >= enemyLeft && userLeft <= enemyRight) || (userRight >= enemyLeft && userRight <= enemyRight)){
                return true;
            }
        }
        return false;
    }


    /*
    private void checkHit(){
       for(Bullet pickedBullet : bulletsArrayList){
           // check if user got hit
           if(checkIsUserDamagedByBullet(pickedBullet)){
               bulletsArrayList.remove(pickedBullet);
               //TODO decrease user hp
           } else {
               //check if enemy got hit
               //if(!enemyArrayList.isEmpty()){
                   for(Enemy pickedEnemy : enemyArrayList){
                       if(checkIsEnemyDamagedByBullet(pickedEnemy, pickedBullet)){
                           bulletsArrayList.remove(pickedBullet);
                           //TODO decrease enemy hp
                           //pickedEnemy.action.reduceHp(userShip.statistics.getDamage());
                       }
                   }
               //}
           }
       }
    }
     */
    private void checkHit(){
        for(int i = bulletsArrayList.size()-1; i >=0; i--){
            Bullet pickedBullet = bulletsArrayList.get(i);
            if(pickedBullet.getFriendlyFire()){
                if(checkIsUserDamagedByBullet(pickedBullet)){
                    //TODO decrease user hp
                    userShip.statistics.reduceHealth(pickedBullet.getDamage());
                    bulletsArrayList.remove(pickedBullet);
                }
            } else{
                if(!enemyArrayList.isEmpty()){
                    boolean flag = false;
                    int counter = enemyArrayList.size()-1;
                    while(flag == false && counter >= 0) {
                        //System.out.println("COUNTER: " + counter);
                        Enemy pickedEnemy = enemyArrayList.get(counter);
                        if (checkIsEnemyDamagedByBullet(pickedEnemy, pickedBullet)) {
                            //TODO decrease enemy hp
                            pickedEnemy.action.reduceHp(pickedBullet.getDamage());
                            bulletsArrayList.remove(pickedBullet);
                            flag = true;
                        }
                        counter--;
                    }
                }
            }
        }
    }

    private boolean checkIsEnemyDamagedByBullet(Enemy pickedEnemy, Bullet  pickedBullet){
        if(pickedBullet.getFriendlyFire()){

            return false;
        }

        int bulletX = (int) pickedBullet.getBulletX();
        int bulletY = (int) pickedBullet.getBulletY();

        int[] enemyCenter = new int[2];
        enemyCenter[0] = pickedEnemy.position.getX();
        enemyCenter[1] = pickedEnemy.position.getY();

        int enemyFront = enemyCenter[1] + pickedEnemy.skin.getShipHeight()/2;
        int enemyBack = enemyCenter[1] - pickedEnemy.skin.getShipHeight()/2;
        int enemyLeft = enemyCenter[0] - pickedEnemy.skin.getShipWidth()/2;
        int enemyRight = enemyCenter[0] + pickedEnemy.skin.getShipWidth()/2;

        if(bulletY <= enemyFront && bulletY >= enemyBack){
            if(bulletX >= enemyLeft && bulletX <= enemyRight){
                return true;
            }
        }
        return false;
    }

    private boolean checkIsUserDamagedByBullet(Bullet pickedBullet){
        //TODO sprawdzenie czy pocisk gracza trafił jakiś statek przeciwnika
        //sprawdź czy pocisk został wystrzelony przez przeciwnika
        if(!pickedBullet.getFriendlyFire()){
            return false;
        }

        int bulletX = (int) pickedBullet.getBulletX();
        int bulletY = (int) pickedBullet.getBulletY();

        int[] userCenter = new int[2];
        userCenter[0] = userShip.position.getShipPositionX();
        userCenter[1] = userShip.position.getShipPositionY();

        int userFront = userCenter[1] + userShip.skin.getShipHeight()/2;
        int userBack = userCenter[1] - userShip.skin.getShipHeight()/2;
        int userLeft = userCenter[0] - userShip.skin.getShipWidth()/2;
        int userRight = userCenter[0] + userShip.skin.getShipWidth()/2;

        if(bulletY <= userFront && bulletY >= userBack){
            if(bulletX >= userLeft && bulletX <= userRight){
                return true;
            }
        }
        return false;
    }
}
