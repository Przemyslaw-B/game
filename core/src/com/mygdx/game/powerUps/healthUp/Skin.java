package com.mygdx.game.powerUps.healthUp;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class Skin {
    TexturesLoader manager;
    Texture texture;
    TextureRegion textureRegion;


    public Skin(TexturesLoader manager){
        this.manager = manager;
        texture = manager.getPowerUpsLoader().getHealthUpLoader().getHealthUpTexture();
        textureRegion = new TextureRegion(texture);
    }

    public Texture getTexture(){
        return texture;
    }

    public TextureRegion getTextureRegion(){
        return textureRegion;
    }
}
