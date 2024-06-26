package com.mygdx.game.combat;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.bullets.SpawnedBullets;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.BattleInterface;
import com.mygdx.game.display.powerUps.DrawAllPowerups;
import com.mygdx.game.levels.EndlessLevel;
import com.mygdx.game.levels.Level;
import com.mygdx.game.player.Ship;
import com.mygdx.game.bullets.Bullet;
import com.mygdx.game.enemies.*;
import com.mygdx.game.powerUps.MoveAllPowerUps;
import com.mygdx.game.powerUps.PickingAllUp;
import com.mygdx.game.powerUps.PowerUp;
import com.mygdx.game.powerUps.SpawnedPowerUps;
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
    //public Score score;
    private Level level;
    private int width;
    private int height;
    private TexturesLoader manager;
    public boolean isNewTopScore;
    private DrawAllPowerups drowAllPowerups;
    private PowerUp powerUp;
    private MoveAllPowerUps moveAllPowerUps;
    private PickingAllUp pickingUpPowerUps;

    public Combat(Ship userShip, TexturesLoader manager){
        this.manager = manager;
        this.isNewTopScore = false;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        //score = new Score();
        //score.reset
        Score.resetScore();
        this.enemyArrayList = new ArrayList<Enemy>();
        this.bulletsArrayList = new ArrayList<Bullet>();
        this.userShip = userShip;
        this.time=0f;
        this.shotTimer = 0f;
        this.rand = new Random();
        this.battleInterface = new BattleInterface(manager);
        setLevel();
        powerUp = new PowerUp(manager, userShip);
        drowAllPowerups = new DrawAllPowerups();
        moveAllPowerUps = new MoveAllPowerUps();
        pickingUpPowerUps = new PickingAllUp(userShip);
        SpawnedPowerUps.resetAllPowerUpsArrays();   //Remove all spawned powerUps
    }

    private void setLevel(){
        this.level = new Level(true, manager);   //TODO level setting
    }

    public void spawnEnemy(int enemyId){
        int enemyY = Gdx.app.getGraphics().getHeight();
        int enemyX = rand.nextInt(Gdx.app.getGraphics().getWidth());
        //TODO DO TESTOW WARTOSCI NA STALE
        //enemyX=500;
        //enemyY=500;
        //enemyArrayList.add(new Enemy(enemyX, enemyY, 2, 180, true, false));
    }

    public static void spawnEnemy(int enemyId, int enemyX, int enemyY, int rotation, boolean isFromTop, boolean isFocusedOnPlayer, TexturesLoader manager){
        enemyArrayList.add(new Enemy(enemyX,enemyY,enemyId, rotation, isFromTop, isFocusedOnPlayer, manager));
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
        /*
        if(bulletsArrayList.size() > 0) {
            for (Bullet pickedBullet : bulletsArrayList) {
                pickedBullet.moveBullet(delta);
                //System.out.println("Bullet X: " + pickedBullet.getBulletX() + "Y: " + pickedBullet.getBulletY());
            }
        }
         */
        if(SpawnedBullets.bulletsArrayList.size() > 0) {
            for (Bullet pickedBullet : SpawnedBullets.bulletsArrayList) {
                pickedBullet.moveBullet(delta);
                //System.out.println("Bullet X: " + pickedBullet.getBulletX() + "Y: " + pickedBullet.getBulletY());
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
        System.out.println("Ilość POCISKÓW na mapie: " + SpawnedBullets.bulletsArrayList.size());
        if(SpawnedBullets.bulletsArrayList.size() > 0){
            for(Bullet picked : SpawnedBullets.bulletsArrayList){
                Drop.batch.draw(picked.getTexture(), picked.getBulletX(), picked.getBulletY());
                //pickedBullet.drawBullet();
                //System.out.println("Rysuję pocisk!");
            }
        }
    }

    public void drawAllEnemies(){
        if(!enemyArrayList.isEmpty()){
            for(Enemy pickedEnemy: enemyArrayList){
                pickedEnemy.draw();
            }
        }
    }

    public void getAMOUNT_TEST_ONLY(){
        System.out.println("~~~ AMOUNT of ENEMY: " + enemyArrayList.size() + " ~~~");
        System.out.println("~~~ AMOUNT of BULLETS: " + bulletsArrayList.size() + " ~~~");
    }

    //TODO MEMORY LEAK arrays?
    public void tickOfBattle(float delta){
        shotTimer += delta;
        time += delta;
        level.tickOfLevel(delta);

        //System.out.println("Making tick of a battle!");

        moveBullet(delta);
        enemyMove(delta);

        drowAllPowerups.draw();
        moveAllPowerUps.move(delta);
        pickingUpPowerUps.checkAndPickUp();

        if(Gdx.input.isTouched()){
            userShoot(delta);
        }
        removeBulletNotInView();
        removeEnemyNotInView();
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

    public boolean isBattleOn(){
            //TODO sprawdź cz nastąpił koniec gry
        if(userShip.statistics.isAlive()){
            return true;
        }
        finalScore();
        return false;
    }

    public void finalScore(){
        if(Score.isNewTopScore()){
            isNewTopScore = true;
        } else {isNewTopScore = false;}
    }

    private void enemyShoot(float delta){
        if(enemyArrayList.size() > 0){
            for(Enemy pickedEnemy : enemyArrayList){
                if(pickedEnemy.canShoot(delta)){
                    SpawnedBullets.bulletsArrayList.add(pickedEnemy.shoot(pickedEnemy.getIsFocusedOnPlayer()));
                }
            }
        }
    }

    private void enemyMove(float delta){
        if(!enemyArrayList.isEmpty()){
            //int count = 0;
            for(Enemy pickedEnemy : enemyArrayList){
                //System.out.println("Ruszam wrogiem nr: " + count);
                //count++;
                pickedEnemy.movement.move(delta);
            }
        }
    }

    private void userShoot(float delta){
        if(userShip.shot(delta)){
            shotTimer = 0;
        }
    }

    private void removeBulletNotInView(){
        if(SpawnedBullets.bulletsArrayList.size() > 0){
            for(int i = SpawnedBullets.bulletsArrayList.size()-1; i>=0; i--){
                Bullet picked = SpawnedBullets.bulletsArrayList.get(i);
                if(!checkBulletInView(picked)){
                    SpawnedBullets.bulletsArrayList.remove(i);
                }
            }
        }

        /*
        if(bulletsArrayList.size() > 0){
            for(int i=bulletsArrayList.size()-1; i>=0; i--){
                if(!checkBulletInView(bulletsArrayList.get(i))){
                    bulletsArrayList.remove(i);
                }
            }
        }

         */

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

    private void removeEnemyNotInView(){
        if(!enemyArrayList.isEmpty()){
            for(int i = enemyArrayList.size()-1; i > 0; i--){
                Enemy pickedEnemy = enemyArrayList.get(i);
                if(checkEnemyNOTInView(pickedEnemy)){
                    enemyArrayList.remove(pickedEnemy);
                }
            }
        }
    }

    private boolean checkEnemyNOTInView(Enemy pickedEnemy){
        int enemyX = pickedEnemy.position.getX();
        int enemyY = pickedEnemy.position.getY();
        int sizeX = pickedEnemy.skin.getShipWidth()/2;
        int sizeY = pickedEnemy.skin.getShipHeight()/2;
        if(enemyX - sizeX > width){
            return true;
        }
        if(enemyX + sizeX < 0){
            return true;
        }
        if(enemyY - sizeY > height){
            return true;
        }
        if(enemyY + sizeY < 0){
            return true;
        }
        return false;
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
        for(int i = SpawnedBullets.bulletsArrayList.size()-1; i >=0; i--){
            Bullet pickedBullet = SpawnedBullets.bulletsArrayList.get(i);
            if(pickedBullet.getFriendlyFire()){
                if(checkIsUserDamagedByBullet(pickedBullet)){
                    userShip.statistics.reduceHealth(pickedBullet.getDamage());
                    SpawnedBullets.bulletsArrayList.remove(pickedBullet);
                }
            } else{
                if(!enemyArrayList.isEmpty()){
                    boolean flag = false;
                    int counter = enemyArrayList.size()-1;
                    while(flag == false && counter >= 0) {
                        //System.out.println("COUNTER: " + counter);
                        Enemy pickedEnemy = enemyArrayList.get(counter);
                        if (checkIsEnemyDamagedByBullet(pickedEnemy, pickedBullet)) {
                            pickedEnemy.action.reduceHp(pickedBullet.getDamage());
                            if(pickedEnemy.statistics.getHealth() <= 0){
                                int tempScore = pickedEnemy.statistics.getScore();
                                Score.addToScore(tempScore);
                                System.out.println("Punkty za przeciwnika: " + tempScore);
                                //System.out.println("~~~ DROP: " + EndlessLevel.powerUpDrop() + " ~~~");
                                String roll = EndlessLevel.powerUpDrop();
                                switch(roll){
                                    case "healthUp":
                                        powerUp.dropHealthUp(pickedEnemy.position.getX(), pickedEnemy.position.getY());
                                        break;

                                    case "addBullet":
                                        powerUp.dropAdditionalBullet(pickedEnemy.position.getX(), pickedEnemy.position.getY());
                                        break;

                                    case "damageUp":
                                        powerUp.dropDamageUp(pickedEnemy.position.getX(), pickedEnemy.position.getY());
                                        break;
                                    default:
                                        break;
                                }
                            }
                            SpawnedBullets.bulletsArrayList.remove(pickedBullet);
                            flag = true;
                        }
                        counter--;
                    }
                }
            }
        }
    }

    private boolean checkIsEnemyDamagedByBullet(Enemy pickedEnemy, Bullet pickedBullet){
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

    public void endOfGameKillAll(){
        SpawnedBullets.bulletsArrayList.clear();
        enemyArrayList.clear();
    }


}
