package com.mygdx.game;

import box2dLight.ChainLight;
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
    Skin skin;
    Stage stage;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton playButton;


    public MainMenuScreen(final Drop game) {
        this.game=game;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.star = new Texture("badlogic.jpg");
        this.skin = new Skin();
        skin.add("play", new Texture("button.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        //camera.setToOrtho(false, 1000, 600);

        myTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        playButton = new ImageButton(myTexRegionDrawable);
        playButton.setWidth(height/5);
        playButton.setHeight(height/5);

        playButton.setPosition( width/2,height/2, Align.center);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        playButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.setScreen(new GameScreen(game));
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
        stage.draw(); //Draw the ui

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(star, 0,0,100,100,200,200,1,1,0,0,0,250,250,false,false);
        //game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 100);
        //game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

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