package com.mygdx.game.TextureLoader.BulletsLoader.PlayerBullets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class PlayerDefaultBullet {
    private String bullet = "bullets/bullet.png";
    private AssetManager loader;

    public PlayerDefaultBullet(AssetManager loader) {
        this.loader = loader;
        loadBullet();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }
    private void loadBullet(){
        if(!isLoaded(bullet)){
            loader.load(bullet, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getPlayerDefaultBullet() {
        return loader.get(bullet);
    }
}
