package com.mygdx.game.TextureLoader.PowerUps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class HealthUpLoader {

    private final String healthUp = "powerUps/healthUp.png";
    AssetManager loader;

    public HealthUpLoader(AssetManager loader) {
        this.loader = loader;
        loadHealthUp();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadHealthUp(){
        if(!isLoaded(healthUp)){
            loader.load(healthUp, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getHealthUpTexture() {
        return loader.get(healthUp);
    }
}
