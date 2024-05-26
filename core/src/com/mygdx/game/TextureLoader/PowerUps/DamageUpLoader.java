package com.mygdx.game.TextureLoader.PowerUps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class DamageUpLoader {
    private final String damageUp = "powerUps/damageUp.png";
    private AssetManager loader;

    public DamageUpLoader(AssetManager loader) {
        this.loader = loader;
        loadDamageUp();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadDamageUp(){
        if(!isLoaded(damageUp)){
            loader.load(damageUp, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getTexture(){
        if(!isLoaded(damageUp)){
            loadDamageUp();
        }
        return loader.get(damageUp);
    }
}
