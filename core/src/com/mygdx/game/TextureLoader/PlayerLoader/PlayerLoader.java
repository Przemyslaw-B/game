package com.mygdx.game.TextureLoader.PlayerLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class PlayerLoader {

    private String playerShip = "ship.png";
    private AssetManager loader;
    public PlayerLoader(AssetManager loader) {
        this.loader = loader;
        loadPlayerShip();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadPlayerShip() {
        if(!isLoaded(playerShip)){
            loader.load(playerShip, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getPlayerShipTexture() {
        return loader.get(playerShip);
    }

}
