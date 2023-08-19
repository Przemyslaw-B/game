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
    private static Stage stage;
    private ImageButton playButton;
    private Background background;
    private float time=0f;


    public MainMenuScreen(final Drop game) {
        this.game=game;
        background = new Background();
        ship = new Ship();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        createInterface();
    }

    private void createInterface(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        playButton = new ImageButton(ship.skin.getShipMyTextureRegionDrawable());
        playButton.setWidth(Ship.skin.getShipWidth());
        playButton.setHeight(Ship.skin.getShipHeight());
        playButton.setPosition(Ship.position.getShipPositionX(),Ship.position.getShipPositionY(), Align.center);
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