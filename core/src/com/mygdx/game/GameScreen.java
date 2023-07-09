package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    private int shipX;
    private int shipY;
    private Texture shipTexture;
    private TextureRegion shipMyTextureRegion;
    private TextureRegionDrawable shipMyTextureRegionDrawable;
    private int shipWidth;
    private int shipLength;

    public GameScreen(final Drop game, float skyMap[][]) {

        this.game=game;
        this.time=0f;
        star = new Texture("star.png");
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        shipX = width/2;
        shipY = height/2;
        Stars stars = new Stars(width, height);
        this.skyMap = skyMap;
        this.ship=new Ship();
        this.shipTexture = ship.getShipTexture();
        shipMyTextureRegion = new TextureRegion(shipTexture);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        this.shipWidth = shipMyTextureRegion.getRegionWidth();
        this.shipLength = shipMyTextureRegion.getRegionWidth();
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

        //System.out.println("Speed: " + positionPerSec);
        game.batch.begin();
        if(exitFlag==true){ //exit to main menu
            for (int i = 0; i < skyMap.length; i++) {
                game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
            }
            if(positionPerSec <= 50 && shipY < 0-shipLength/2){
                game.setScreen(new MainMenuScreen(game, skyMap)); //enter menu
                dispose();
            } else if (positionPerSec != 50){
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
            } else if(shipY > 0-shipLength/2){
                shipY -= 5;
                moveSky(delta, positionPerSec);
            }
        } else{
            //draw moving sky
            if(time > 5){   //level here
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                //here add level


            } else if(time <= 2){   //speed up to enter level
                positionPerSec += 20;
                for (int i = 0; i < skyMap.length; i++) {
                    game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
                }
                moveSky(delta, positionPerSec);
                if(shipY + shipLength/2 < (height/20)*19){
                    shipY += 5;
                }
            } else if(time <3 && time >2) { //hold fast speed
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
                if(shipY - shipLength/2 > height/20){
                    shipY -= 10;
                }
            }
        }

        game.batch.draw(shipTexture, shipX-(shipWidth/2), shipY-(shipLength/2));    //draw ship
        game.batch.end();

            if (Gdx.input.isTouched() && time>0.1) {    //press anywhere to quit level
                exitFlag = true;
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
