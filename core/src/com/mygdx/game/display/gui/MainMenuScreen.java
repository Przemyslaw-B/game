package com.mygdx.game.display.gui;

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
import com.mygdx.game.background.Background;
import com.mygdx.game.display.Drop;
import com.mygdx.game.background.Stars;
import com.mygdx.game.display.GameScreen;
import com.mygdx.game.player.*;

public class MainMenuScreen extends Game implements Screen {

    final Drop game;
    private static Ship ship;
    int width;
    int height;
    OrthographicCamera camera;
    //Texture star;
    Texture shipT;
    private static Stage stage;
    private Texture myTexture;
    private TextureRegion shipMyTextureRegion;
    private TextureRegionDrawable shipMyTextureRegionDrawable;
    private ImageButton playButton;
    private float skyMap[][];
    private Stars sky;
    private Background background;
    private float time=0f;
    private float positionPerSec=50f;

    public MainMenuScreen(final Drop game, float skyMap[][]){
        this.game=game;
        ship = new Ship();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.sky = new Stars(width, height);
        this.skyMap = skyMap;
        createInterface();
    }


    public MainMenuScreen(final Drop game) {
        this.game=game;
        background = new Background();
        ship = new Ship();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.sky = new Stars(width, height);
        //skyMap = sky.createSkyMap(5);
        createInterface();
    }

    private void createInterface(){
        //this.star = new Texture("star.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        //
        shipT = new Texture(Gdx.files.internal("ship.png"));
        shipMyTextureRegion = new TextureRegion(shipT);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        //playButton = new ImageButton(shipMyTextureRegionDrawable);
        //
        playButton = new ImageButton(ship.skin.getShipMyTextureRegionDrawable());
        playButton.setWidth(Ship.skin.getShipWidth());
        playButton.setHeight(Ship.skin.getShipHeight());

        playButton.setPosition(Ship.position.getShipPositionX()-Ship.skin.getShipWidth(),Ship.position.getShipPositionY()-Ship.skin.getShipHeight(), Align.center);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.setScreen(new GameScreen(game, background, ship));
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
        background.draw();
        background.move(delta);
        game.batch.end();
        stage.draw(); //Draw the ui
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