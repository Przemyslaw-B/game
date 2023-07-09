package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen extends Game implements Screen {

    final Drop game;
    int width;
    int height;
    OrthographicCamera camera;
    Texture star;
    Texture ship;
    Skin skin;
    Stage stage;
    private Texture myTexture;
    private TextureRegion shipMyTextureRegion;
    private TextureRegionDrawable shipMyTextureRegionDrawable;
    private ImageButton playButton;
    private float skyMap[][];
    private Stars sky;
    private float time=0f;
    private float positionPerSec=50f;

    public MainMenuScreen(final Drop game, float skyMap[][]){
        this.game=game;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.sky = new Stars(width, height);
        this.skyMap = skyMap;
        createInterface();
    }


    public MainMenuScreen(final Drop game) {
        this.game=game;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.sky = new Stars(width, height);
        skyMap = sky.createSkyMap(5);
        createInterface();
    }

    private void createInterface(){
        this.star = new Texture("star.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        ship = new Texture(Gdx.files.internal("ship.png"));
        shipMyTextureRegion = new TextureRegion(ship);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        playButton = new ImageButton(shipMyTextureRegionDrawable);
        playButton.setWidth(height/5);
        playButton.setHeight(height/5);

        playButton.setPosition( width/2,height/2, Align.center);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.setScreen(new GameScreen(game, skyMap));
                dispose();
                return false;
            }
        });
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        //game.batch.draw(star, 0,0,100,100,200,200,1,1,0,0,0,250,250,false,false);

        for(int i=0; i<skyMap.length; i++){
            game.batch.draw(star, skyMap[i][0], skyMap[i][1]);
            skyMap[i][1] -= positionPerSec*delta;
            if(skyMap[i][1] <= 0){
                skyMap[i][1] = height;
            }
        }
        game.batch.end();
        stage.draw(); //Draw the ui


        /*
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
         */

    }

    @Override
    public void create() {

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
        stage.dispose();
    }

    // Rest of class still omitted...

}