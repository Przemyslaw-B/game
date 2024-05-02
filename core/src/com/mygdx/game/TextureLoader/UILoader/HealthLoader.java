package com.mygdx.game.TextureLoader.UILoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class HealthLoader {

    private AssetManager loader;

    private String heart = "health/heart.png";
    private String x = "health/x.png";

    public HealthLoader(AssetManager loader) {
        this.loader = loader;
        loadHealthUi();
    }

    private void loadHealthUi(){
        loadHeart();
        loadX();
    }

    private boolean isLoaded(String filename){
        if(loader.isLoaded(filename)){
           return true;
        }
        return false;
    }

    private void loadHeart(){
        if(!isLoaded(heart)){
            loader.load(heart, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadX(){
        if(!isLoaded(x)){
            loader.load(x, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

}
