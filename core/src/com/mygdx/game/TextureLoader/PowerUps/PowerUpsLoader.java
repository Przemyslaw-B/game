package com.mygdx.game.TextureLoader.PowerUps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class PowerUpsLoader {
    private final String healthUp = "healthUp.png";
    private final String damageUp = "powerUps/damageUp.png";

    private AssetManager loader;

    public PowerUpsLoader(AssetManager loader) {
        this.loader = loader;
        loadAllPowerUps();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadAllPowerUps(){
        loadHealthUp();
        loadDamageUp();
    }

    private void loadHealthUp(){
        if(!isLoaded(healthUp)){
            loader.load(healthUp, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadDamageUp(){
        if(!isLoaded(damageUp)){
            loader.load(damageUp, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

}
