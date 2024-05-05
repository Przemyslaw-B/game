package com.mygdx.game.TextureLoader.BacgroundLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class BackgroundLoader {

    private AssetManager loader;
    private StarLoader starLoader;

    public BackgroundLoader(AssetManager loader) {
        this.loader = loader;
        this.starLoader = new StarLoader(loader);
    }

    public StarLoader getStarLoader(){
        return starLoader;
    }
}
