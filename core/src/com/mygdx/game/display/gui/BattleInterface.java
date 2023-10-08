package com.mygdx.game.display.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.display.Drop;

public class BattleInterface {

    int heartX;
    int heartY;
    private static Texture heartTexture;
    private static TextureRegion heartTextureRegion;
    private static TextureRegionDrawable heartTextureRegionDrawable;

    private static Texture scoreTexture;
    private static TextureRegion scoreTextureRegion;
    private static TextureRegionDrawable scoreTextureRegionDrawable;



    public BattleInterface(){
        heartTexture = new Texture(Gdx.files.internal("score.png"));
        heartTextureRegion = new TextureRegion(heartTexture);
        heartTextureRegionDrawable = new TextureRegionDrawable(heartTextureRegion);

        setHeartPlace();
    }

    private void setHeartPlace(){
        int height = Gdx.graphics.getHeight();
        int width = Gdx.graphics.getWidth();

        double value =width * 0.05;
        this.heartX = 0 + (int) value;
        this.heartX = heartX + heartTextureRegion.getRegionWidth()/2;

        value = height * 0.05;
        this.heartY = height - (int) value;
        this.heartY = heartY - heartTextureRegion.getRegionHeight()/2;
    }

    public void drawInterface(){
            Drop.batch.draw(heartTexture, heartX, heartY);
    }
}
