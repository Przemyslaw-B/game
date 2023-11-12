package com.mygdx.game.display.gui.gameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.GameScreen;
import com.mygdx.game.player.Ship;

public class GameOver {
    private static Texture buttonTexture;
    private Texture gameOverText;
    private TextureRegion gameOverTextureRegion;
    private static TextureRegion buttonMyTextureRegion;
    private static TextureRegionDrawable buttonMyTextureRegionDrawable;
    private ImageButton continueButton;
    private int gameOverTextX;
    private int gameOverTextY;
    private int x;
    private int y;
    private Stage stage;
    public GameOver(){
        setGameOverText();
        setTexture();
        continueButton = new ImageButton(buttonMyTextureRegionDrawable);
        setPosition();
        setButton();
        setStage();

    }

    private void setGameOverText(){
        gameOverText = new Texture("gameOver.png");
        gameOverTextureRegion = new TextureRegion(gameOverText);
        gameOverTextX = Gdx.graphics.getWidth()/2 - gameOverTextureRegion.getRegionWidth()/2;
        gameOverTextY = (int) (2*Gdx.graphics.getHeight())/3 - gameOverTextureRegion.getRegionHeight()/2;
    }
    private void drawText(){
        Drop.batch.draw(gameOverText, gameOverTextX,gameOverTextY);
    }

    private void setStage(){
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(continueButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
    }
    private void setTexture(){
        buttonTexture = new Texture("buttons/continue.png");
        buttonMyTextureRegion = new TextureRegion(buttonTexture);
        buttonMyTextureRegionDrawable = new TextureRegionDrawable(buttonMyTextureRegion);
    }

    private void setButton(){
        continueButton.setWidth(buttonMyTextureRegion.getRegionWidth());
        continueButton.setHeight(buttonMyTextureRegion.getRegionHeight());
        int height = gameOverTextY - gameOverTextureRegion.getRegionHeight()/2 - (Gdx.graphics.getHeight()/10);
        continueButton.setPosition(x, height, Align.center);
        continueButton.setVisible(false);

        continueButton.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                return true;
            }
        });
    }

    private void setPosition(){
        setPositionInTheMiddle();
    }

    private void  setPositionInTheMiddle(){
        x = Gdx.graphics.getWidth()/2;
        y = Gdx.graphics.getHeight()/2;
    }

    public boolean checkIfContinue(){
        if(continueButton.isPressed()){
        }
        return continueButton.isPressed();
    }

    private void drawButton(){
        continueButton.setVisible(true);
        //Drop.batch.draw(buttonTexture, x-buttonMyTextureRegion.getRegionWidth()/2, y-buttonMyTextureRegion.getRegionHeight()/2);
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }

    public void drawGameOver(){
        drawText();
        drawButton();
    }
}
