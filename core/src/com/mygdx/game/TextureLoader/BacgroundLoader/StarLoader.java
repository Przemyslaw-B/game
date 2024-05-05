package com.mygdx.game.TextureLoader.BacgroundLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class StarLoader {
    private AssetManager loader;
    private String star = "star.png";

    public StarLoader(AssetManager loader) {
        this.loader = loader;
        loadStar();
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

    public Texture getStar(){
        return loader.get(star);
    }
}
