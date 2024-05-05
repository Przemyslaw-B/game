package com.mygdx.game.TextureLoader.BacgroundLoader;

import com.badlogic.gdx.assets.AssetManager;

public class BackgroundLoader {

    private AssetManager loader;
    StarLoader starLoader;

    public BackgroundLoader(AssetManager loader) {
        this.loader = loader;
        this.starLoader = new StarLoader(loader);
    }
}
