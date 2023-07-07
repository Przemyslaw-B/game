package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Drop game;

    Texture star;
    int height;
    int width;
    float[][] skyMap;
    float time;
    float positionPerSec;

    public GameScreen(final Drop game) {

        this.game=game;
        this.time=0f;
        this.positionPerSec = 50f;
        star = new Texture("star.png");
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        Stars stars = new Stars(width, height);
        this.skyMap = stars.createSkyMap(5);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        time += delta;
        game.batch.begin();
        for(int i=0; i<skyMap.length; i++){
            game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
            skyMap[i][1] -= positionPerSec*delta;
            if(skyMap[i][1] <= 0){
                skyMap[i][1] = height;
            }
        }
        game.batch.end();

        if (Gdx.input.isTouched() && time>1) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
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
