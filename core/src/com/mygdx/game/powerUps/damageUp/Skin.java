package com.mygdx.game.powerUps.damageUp;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class Skin {
    Texture texture;
    TextureRegion textureRegion;
    TexturesLoader manager;

    public Skin(TexturesLoader manager){
    this.manager = manager;
    texture = manager.getPowerUpsLoader().getDamageUpLoader().getDamageUpsTexture();
    textureRegion = new TextureRegion(texture);
    }

    public Texture getTexture(){
        return texture;
    }

    public TextureRegion getTextureRegion(){
        return textureRegion;
    }
}
