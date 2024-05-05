package com.mygdx.game.display.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.health.DrawHealth;
import com.mygdx.game.score.Score;

public class BattleInterface{

    int heartX;
    int heartY;

    int scoreX;
    int scoreY;

    int xX;
    int xY;

    DrawHealth drawHealth;

    Score score;
    DrawScore drawScore;
    private static Texture heartTexture;
    private static TextureRegion heartTextureRegion;
    private static TextureRegionDrawable heartTextureRegionDrawable;

    private static Texture scoreTexture;
    private static TextureRegion scoreTextureRegion;
    private static TextureRegionDrawable scoreTextureRegionDrawable;

    private static Texture healthXTexture;
    private static TextureRegion healthXTextureRegion;
    private static TextureRegionDrawable healthXTextureRegionDrawable;



    public BattleInterface(TexturesLoader manager, Score score){
        this.score = score;
        this.drawScore = new DrawScore(manager, score);
        //heartTexture = new Texture(Gdx.files.internal("health/heart.png"));
        heartTexture = manager.getHealthLoader().getHeartTexture();
        heartTextureRegion = new TextureRegion(heartTexture);
        heartTextureRegionDrawable = new TextureRegionDrawable(heartTextureRegion);

        //scoreTexture = new Texture(Gdx.files.internal("score/score.png"));
        scoreTexture = manager.getScoreLoader().getScoreTexture();
        scoreTextureRegion = new TextureRegion(scoreTexture);
        scoreTextureRegionDrawable = new TextureRegionDrawable(scoreTextureRegion);

        //healthXTexture = new Texture(Gdx.files.internal("health/x.png"));
        healthXTexture = manager.getHealthLoader().getXTexture();
        healthXTextureRegion = new TextureRegion(scoreTexture);
        healthXTextureRegionDrawable = new TextureRegionDrawable(scoreTextureRegion);

        setScorePlace();
        setHeartPlace();
        setXPlace();
        drawHealth = new DrawHealth(manager,xX + xX/4, xY);
    }

    private void setScorePlace(){
        int height = Gdx.graphics.getHeight();
        int width = Gdx.graphics.getWidth();

        double value = width * 0.05;
        this.scoreX = 0 + (int) value;

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

    private void setXPlace(){
        xY = heartY;
        xX = heartX + heartTextureRegion.getRegionWidth();
    }
    public void drawInterface(){
        Drop.batch.draw(scoreTexture, scoreX, scoreY);
        drawScore.draw(scoreX + scoreTextureRegion.getRegionWidth(), scoreY);
        Drop.batch.draw(heartTexture, heartX, heartY);
        Drop.batch.draw(healthXTexture, xX, xY);
        drawHealth.drawHealthAmount();
    }
}
