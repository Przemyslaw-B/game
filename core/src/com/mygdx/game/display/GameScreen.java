package com.mygdx.game.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.background.Background;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.MainMenuScreen;
import com.mygdx.game.player.Ship;
import com.mygdx.game.background.Stars;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.database.Database;

public class GameScreen implements Screen {

    final Drop game;

    Texture star;
    int height;
    int width;
    float time;
    Background background;
    float positionPerSec=50f;
    boolean exitFlag=false;
    boolean deadFlag=false;
    private Ship ship;

    private Vector3 touchPoint;
    private Combat combat;

    public GameScreen(final Drop game, Background background, Ship ship) {

        this.game=game;
        this.ship = ship;
        this.time=0f;
        star = new Texture("star.png");
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        Stars stars = new Stars(width, height);
        this.background = background;
        //this.db = new Database();
        //this.db=null;   //TODO TEMPORARRY NULLS
        //this.ship=new Ship();
        this.combat = new Combat(ship);
        this.touchPoint = new Vector3();
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
            if(time > 3){   //level here
                background.setSpeedPerSec(800);
                //here add level

                //Ship Control
                if(Gdx.input.isTouched() && ship.statistics.isAlive()){
                    //ship.shipControl(Gdx.input.getX(), Gdx.input.getY(), delta);
                    //System.out.println("Ship is ALIVE!, let's move");
                    ship.movement.shipControl();
                }
                //End of Ship Control

                //level end
            } /* else if(time <= 2){   //speed up to enter level
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
        ship.draw();
        game.batch.end();

            if (Gdx.input.isTouched() && time>0.1) {    //press anywhere to quit level
                touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                //exitFlag = true;
            }
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
