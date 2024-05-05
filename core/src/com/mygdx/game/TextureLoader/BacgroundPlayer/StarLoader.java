package com.mygdx.game.TextureLoader.BacgroundPlayer;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class StarLoader {
    private AssetManager loader;
    private String star = "star.png";

    public StarLoader(AssetManager loader) {
        this.loader = loader;
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadStar(){
        if(!isLoaded(star)){
            loader.load(star, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }
}