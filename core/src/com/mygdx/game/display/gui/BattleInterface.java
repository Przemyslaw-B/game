package com.mygdx.game.display.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.display.Drop;
import com.mygdx.game.score.Score;

public class BattleInterface {

    int heartX;
    int heartY;

    int scoreX;
    int scoreY;
    Score score;
    DrawScore drawScore;
    private static Texture heartTexture;
    private static TextureRegion heartTextureRegion;
    private static TextureRegionDrawable heartTextureRegionDrawable;

    private static Texture scoreTexture;
    private static TextureRegion scoreTextureRegion;
    private static TextureRegionDrawable scoreTextureRegionDrawable;



    public BattleInterface(Score score){
        this.score = score;
        this.drawScore = new DrawScore(score);
        heartTexture = new Texture(Gdx.files.internal("health/heart.png"));
        heartTextureRegion = new TextureRegion(heartTexture);
        heartTextureRegionDrawable = new TextureRegionDrawable(heartTextureRegion);

        scoreTexture = new Texture(Gdx.files.internal("score/score.png"));
        scoreTextureRegion = new TextureRegion(scoreTexture);
        scoreTextureRegionDrawable = new TextureRegionDrawable(scoreTextureRegion);

        setScorePlace();
        setHeartPlace();
    }

    private void setScorePlace(){
        int height = Gdx.graphics.getHeight();
        int width = Gdx.graphics.getWidth();

        double value = width * 0.05;
        this.scoreX = 0 + (int) value;
        //this.scoreX = scoreX + scoreTextureRegion.getRegionWidth()/2;

        value = height * 0.05;
        this.scoreY = height - (int) value;
        this.scoreY = scoreY - scoreTextureRegion.getRegionHeight()/2;
    }

    private void setHeartPlace(){
        int height = Gdx.graphics.getHeight();
        int width = Gdx.graphics.getWidth();

        double value = width * 0.05;
        this.heartX = 0 + (int) value;
        //this.heartX = heartX + heartTextureRegion.getRegionWidth()/2;

        value = height * 0.05;
        this.heartY = this.scoreY - scoreTextureRegion.getRegionHeight()/2 - (int) value;
        this.heartY = heartY - heartTextureRegion.getRegionHeight()/2;
    }
    public void drawInterface(){
        Drop.batch.draw(scoreTexture, scoreX, scoreY);
        drawScore.draw(scoreX + scoreTextureRegion.getRegionWidth(), scoreY);
        Drop.batch.draw(heartTexture, heartX, heartY);
    }
}
