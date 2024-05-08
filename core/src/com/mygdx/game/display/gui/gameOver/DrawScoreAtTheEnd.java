package com.mygdx.game.display.gui.gameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.DrawScore;
import com.mygdx.game.score.Score;

public class DrawScoreAtTheEnd {
    private int score;
    private DrawScore drawScore;
    private TexturesLoader manager;

    public DrawScoreAtTheEnd(TexturesLoader manager) {
        this.manager = manager;
        this.score = Score.getScore();
        this.drawScore = new DrawScore(manager);
    }

    public void draw(int y){
        int scoreWordWidth = getScoreWordWidth();
        int scoreWidth = getScoreWidth();
        int defaultPosition = getMiddleOfScreen();

        int sum = (scoreWordWidth+scoreWidth);
        int position = defaultPosition - sum/2;

        Drop.batch.draw(manager.getScoreLoader().getScoreTexture(),position,y);
        position = defaultPosition + scoreWordWidth/2;
        drawScore.draw(position,y);
    }

    private int getScoreWordWidth(){
        Texture scoreWord = manager.getScoreLoader().getScoreTexture();
        TextureRegion scoreWordRegion = new TextureRegion(scoreWord);
        return scoreWordRegion.getRegionWidth();
    }

    private int getScoreWidth(){
        return drawScore.getScoreWidth(false);
    }

    private int getMiddleOfScreen(){
        return Gdx.graphics.getWidth()/2;
    }


}
