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
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.data.Data;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.GameScreen;
import com.mygdx.game.player.Ship;
import com.mygdx.game.score.Score;

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
    private DrawScoreAtTheEnd drawScoreAtTheEnd;
    private DrawTopScoreAtTheEnd drawTopScoreAtTheEnd;
    private DrawNewTopScoreAtTheEnd drawNewTopScoreAtTheEnd;
    private TexturesLoader manager;
    boolean topScoreFlag;
    boolean wasDisplayed;

    public GameOver(TexturesLoader manager){
        this.topScoreFlag = false;
        this.wasDisplayed = false;
        this.manager = manager;
        setGameOverText();
        setTexture();
        continueButton = new ImageButton(buttonMyTextureRegionDrawable);
        setPosition();
        setButton();
        setStage();
        drawScoreAtTheEnd = new DrawScoreAtTheEnd(manager);
        drawTopScoreAtTheEnd = new DrawTopScoreAtTheEnd(manager);
        drawNewTopScoreAtTheEnd = new DrawNewTopScoreAtTheEnd(manager);
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
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }



    private void drawScoreTable(){
        int tempY = Gdx.graphics.getHeight()/3;

        if(Score.checkIsNewTopScore()){
            //TODO show "NEW TOP SCORE"
            drawNewTopScoreAtTheEnd.draw(tempY);
            //drawScore.drawTopScore(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/3);
        } else {
            drawScoreAtTheEnd.draw(tempY);
            tempY -= 70;
            drawTopScoreAtTheEnd.draw(tempY);
            //TODO DRAW "TOP SCORE"
            //drawScore.drawTopScore(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/3);
        }
    }

    public void drawGameOver(){
        drawText();
        drawScoreTable();
        drawButton();

        //check();
    }

    private void check(){
        System.out.println("~~~ GAME OVER ~~~");
        System.out.println("| Ilość zdobytych punktów: " + Score.getScore());
        System.out.println("| Czy zdobyto właśnie najlepszy wynik: " + Score.isNewTopScore());
        System.out.println("| Najlepszy wynik gracza: " + Score.getTopScore());
        System.out.println("~~~ KONIEC RAPORTU ~~~");
    }

}
