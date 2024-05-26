package com.mygdx.game.TextureLoader.PowerUps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AdditionalBulletLoader {
    private final String additionalBullet = "powerUps/damageUp.png";
    private AssetManager loader;

    public AdditionalBulletLoader(AssetManager loader) {
        this.loader = loader;
        loadAdditionalBullet();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadAdditionalBullet(){
        if(!isLoaded(additionalBullet)){
            loader.load(additionalBullet, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getTexture(){
        if(!isLoaded(additionalBullet)){
            loadAdditionalBullet();
        }
        return loader.get(additionalBullet);
    }
}
