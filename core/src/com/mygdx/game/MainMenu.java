package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu extends ApplicationAdapter{

    SpriteBatch batch;
    Texture star;
    int height;
    int width;
    int[][] skyMap;
    Button playButton;
    Skin skin;


    @Override
    public void create () {
        batch = new SpriteBatch();
        star = new Texture("star.png");
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        Stars stars = new Stars(width, height);
        this.skyMap = stars.createSkyMap(5);
        //this.skin=new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        //this.playButton = new TextButton("Play", new Skin(), "small");
        //playButton.setSize(200, 60);
        //playButton.setPosition((width/2)-100,height-200);

    }





    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);  //black background
        batch.begin();
        for(int i=0; i<skyMap.length; i++){
            batch.draw(star, skyMap[i][0], skyMap[i][1]);
        }
        batch.end();

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
    public void dispose() {
        batch.dispose();
    }
}
