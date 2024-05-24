package com.mygdx.game.display.gui.gameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.DrawScore;
import com.mygdx.game.score.Score;

public class DrawTopScoreAtTheEnd {
    private int score;
    private DrawScore drawScore;
    private TexturesLoader manager;
    int width;
    int height;

    public DrawTopScoreAtTheEnd(TexturesLoader manager) {
        this.manager = manager;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.score = Score.getScore();
        this.drawScore = new DrawScore(manager);
    }

    public void draw(int y){
        int topScoreWordWidth = getTopScoreWordWidth();
        int scoreWidth = getTopScoreWidth();
        int defaultPosition = getMiddleOfScreen();

        int sum = (topScoreWordWidth+scoreWidth);
        int position = defaultPosition - sum/2;

        Drop.batch.draw(manager.getScoreLoader().getTopScoreTexture(),position,y);
        position = defaultPosition + topScoreWordWidth/2;

        drawScore.drawTopScore(position,y);
    }

    private int getTopScoreWordWidth(){
        Texture topScoreWord = manager.getScoreLoader().getTopScoreTexture();
        TextureRegion topScoreWordRegion = new TextureRegion(topScoreWord);
        return topScoreWordRegion.getRegionWidth();
    }

    private int getTopScoreWidth(){
        return drawScore.getScoreWidth(true);
    }

    private int getMiddleOfScreen(){
        return Gdx.graphics.getWidth()/2;
    }

    public int getTopScoreWordHeight(){
        Texture topScoreWord = manager.getScoreLoader().getTopScoreTexture();
        TextureRegion topScoreWordRegion = new TextureRegion(topScoreWord);
        return topScoreWordRegion.getRegionHeight();
    }


}