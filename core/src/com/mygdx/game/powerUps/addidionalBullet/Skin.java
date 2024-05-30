package com.mygdx.game.powerUps.addidionalBullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class Skin {
    private Texture texture;
    private TextureRegion textureRegion;
    private TexturesLoader manager;

    public Skin(TexturesLoader manager) {
        this.manager = manager;
        this.texture = manager.getPowerUpsLoader().getAdditionalBulletLoader().getTexture();
        this.textureRegion = new TextureRegion(texture);
    }

    public Texture getTexture() {return this.texture;}
    public TextureRegion getTextureRegion() {return this.textureRegion;}


}
