package com.mygdx.game.display.gui.gameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.DrawScore;
import com.mygdx.game.score.Score;

public class DrawNewTopScoreAtTheEnd {
    TexturesLoader manager;
    DrawScore drawScore;

    public DrawNewTopScoreAtTheEnd(TexturesLoader manager) {
        this.manager = manager;
        this.drawScore = new DrawScore(manager);
    }

    public void draw(int y, int spaceLeft){
        int defaultPosition = getMiddleOfTheScreen();

        int newWordHeight  = getNewWordHeight();
        int newWordWidth = getNewWordWidth();
        int topScoreWordWidth = getTopScoreWordWidth();
        int topScoreWordHeight = getTopScoreWordHeight();
        int topScoreWidth = getTopScoreWidth();

        int position = defaultPosition - newWordWidth/2;
        y -= newWordHeight/3;
        Drop.batch.draw(manager.getScoreLoader().getNewWordTexture(),position, y);

        y += topScoreWordHeight/3;

        int sum = (topScoreWordWidth + topScoreWidth);
        position = defaultPosition - sum/2;

        Drop.batch.draw(manager.getScoreLoader().getTopScoreTexture(),position,y);
        position = defaultPosition + topScoreWordWidth/2;

        drawScore.drawTopScore(position,y);
    }

    private int getNewWordWidth(){
        TextureRegion newWordTextureRegion = new TextureRegion(manager.getScoreLoader().getNewWordTexture());
        return newWordTextureRegion.getRegionWidth();
    }

    private int getNewWordHeight(){
        TextureRegion newWordTextureRegion = new TextureRegion(manager.getScoreLoader().getNewWordTexture());
        return newWordTextureRegion.getRegionHeight();
    }

    private int getTopScoreWordWidth(){
        Texture topScoreWord = manager.getScoreLoader().getTopScoreTexture();
        TextureRegion topScoreWordRegion = new TextureRegion(topScoreWord);
        return topScoreWordRegion.getRegionWidth();
    }

    private int getTopScoreWordHeight(){
        Texture topScoreWord = manager.getScoreLoader().getTopScoreTexture();
        TextureRegion topScoreWordRegion = new TextureRegion(topScoreWord);
        return topScoreWordRegion.getRegionHeight();
    }

    private int getTopScoreWidth(){
        return drawScore.getScoreWidth(true);
    }

    private int getMiddleOfTheScreen(){
        return Gdx.graphics.getWidth()/2;
    }
}
