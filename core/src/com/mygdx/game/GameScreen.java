package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Drop game;

    Texture star;
    int height;
    int width;
    float[][] skyMap;
    float time;
    float positionPerSec=50f;
    boolean exitFlag=false;
    boolean deadFlag=false;
    private Ship ship;

    private Vector3 touchPoint;
    private Combat combat;


    public GameScreen(final Drop game, float skyMap[][]) {

        this.game=game;
        this.time=0f;
        star = new Texture("star.png");
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        Stars stars = new Stars(width, height);
        this.skyMap = skyMap;
        this.ship=new Ship();
        this.combat = new Combat(ship);
        this.touchPoint = new Vector3();
    }

    @Override
    public void show() {

    }

    private void moveSky(float delta, float positionPerSec){
        for (int i=0; i < skyMap.length; i++) {
            skyMap[i][1] -= positionPerSec * delta;
            if (skyMap[i][1] <= 0) {
                skyMap[i][1] = height;
            }
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        time += delta;

        game.batch.begin();
        if(exitFlag){ //exit to main menu
            for (int i = 0; i < skyMap.length; i++) {
                game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
            }
            if(positionPerSec <= 50 && ship.getShipY() < -ship.getShipLength()/2){
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
            if(ship.getShipY() >= -ship.getShipLength()/2){
                ship.setShipY(ship.getShipY()-7);
                moveSky(delta, positionPerSec);
            }
        } else{
            if(time > 5){   //level here
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                //here add level

                //Ship Control
                if(Gdx.input.isTouched() && ship.isAlive()){
                    ship.shipControl(Gdx.input.getX(), Gdx.input.getY(), delta);
                }
                //End of Ship Control

                //level end
            } else if(time <= 2){   //speed up to enter level
                positionPerSec += 20;
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                if(ship.getShipY() + ship.getShipLength()/2 < (height/20)*19){
                    ship.setShipY(ship.getShipY()+5);
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
                if(ship.getShipY() - ship.getShipLength()/2 > height/20){
                    ship.setShipY(ship.getShipY()-10);
                }
            }
        }
        game.batch.draw(ship.getShipTexture(), ship.getShipX()-(ship.getShipWidth()/2), ship.getShipY()-(ship.getShipLength()/2));    //draw ship
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
