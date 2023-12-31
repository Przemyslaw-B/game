package com.mygdx.game.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.background.Background;
import com.mygdx.game.display.gui.MainMenuScreen;
import com.mygdx.game.player.Ship;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.display.gui.gameOver.GameOver;


import java.util.ArrayList;
import java.util.LinkedList;

public class GameScreen implements Screen {

    final Drop game;

    int height;
    int width;
    float time;
    Background background;
    boolean exitFlag=false;
    boolean deadFlag=false;
    private Ship ship;

    private Vector3 touchPoint;
    private Combat combat;
    private GameOver gameOver;


    //Enemy enemy;
    //ArrayList<Enemy> enemyList;
    public GameScreen(final Drop game, Background background, Ship ship) {
        this.game=game;
        this.gameOver = new GameOver();

        this.ship = ship;
        this.time=0f;
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        this.background = background;
        //this.ship=new Ship();
        this.combat = new Combat(ship);
        //this.enemyList = new ArrayList<Enemy>();
        this.touchPoint = new Vector3();

        //DO TESTÓW JEDEN WRÓG
        //enemyList.add(new Enemy(500, 500, 2));
        combat.spawnEnemy(2);
    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        time += delta;
        game.batch.begin();
        background.draw();
        background.move(delta);



        if(exitFlag){ //exit to main menu
            game.setScreen(new MainMenuScreen(game));
            dispose();
            /*
            for (int i = 0; i < skyMap.length; i++) {
                game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
            }
            if(positionPerSec <= 50 && ship.position.getShipPositionY() < -ship.statistics.getShipHeight()/2){
            //ship.getShipY() < -ship.getShipLength()/2){
                game.setScreen(new MainMenuScreen(game, skyMap)); //enter menu
                dispose();
            }
            if (positionPerSec != 50){
                if(positionPerSec > 50){
                    if(positionPerSec-5<50){
                        positionPerSec -= 1;
                    } else {
                        positionPerSec -= 5;
                    }
                } else {
                    if(positionPerSec+5 > 50){
                        positionPerSec += 1;
                    } else{
                        positionPerSec += 5;
                    }
                }
                moveSky(delta, positionPerSec);
            }
            //if(ship.getShipY() >= -ship.getShipLength()/2){
            if(ship.position.getShipPositionY() >= -ship.statistics.getShipHeight()/2){
                //ship.setShipY(ship.getShipY()-7);
                ship.position.setShipPositionY(ship.position.getShipPositionY()-7);
                moveSky(delta, positionPerSec);
            }
        */

        }else{
            if(time > 1){   //level here
                background.setSpeedPerSec(800);
                combat.tickOfBattle(delta);
                //ship.draw();
                //here add level

                //Ship Control
                if(Gdx.input.isTouched() && ship.statistics.isAlive()){
                    //ship.shipControl(Gdx.input.getX(), Gdx.input.getY(), delta);
                    //System.out.println("Ship is ALIVE!, let's move");
                    ship.movement.shipControl();
                }
                //End of Ship Control

                //level end
            } else {ship.draw();} //TODO - DO TESTÓW WYŚWIETLANIA!!!
            /* else if(time <= 2){   //speed up to enter level
                positionPerSec += 20;
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                //if(ship.getShipY() + ship.getShipLength()/2 < (height/20)*19){
                if(ship.position.getShipPositionY() + ship.statistics.getShipHeight()/2 < (height/20)*19){
                    //ship.setShipY(ship.getShipY()+5);
                    ship.position.setShipPositionY(ship.position.getShipPositionY()+5);
                }
            } else if(time <3 && time >2) { //hold that speed
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
            }else if(time <= 5 && time >= 3){   //slow down to fight in level
                positionPerSec -= 17;
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                //if(ship.getShipY() - ship.getShipLength()/2 > height/20){
                if(ship.position.getShipPositionY() - ship.statistics.getShipHeight()/2 > height/20){
                    //ship.setShipY(ship.getShipY()-10);
                    ship.position.setShipPositionY(ship.position.getShipPositionY()-10);
                }
            }
           */
        }
        //game.batch.draw(ship.getShipTexture(), ship.getShipX()-(ship.getShipWidth()/2), ship.getShipY()-(ship.getShipLength()/2));    //draw ship
        //game.batch.draw(ship.skin.getShipTexture(), ship.position.getShipPositionX()-(ship.statistics.getShipWidth()/2), ship.position.getShipPositionY()-(ship.statistics.getShipHeight()/2)); //draw a ship


            if (!combat.isBattleOn()) {    //press anywhere to quit level
                gameOver.drawGameOver();
                if(gameOver.checkIfContinue()){
                    exitFlag = true;
                }
            }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
