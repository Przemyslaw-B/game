package com.mygdx.game.TextureLoader.BulletsLoader.EnemyBullets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class EnemyDefaultBullet {
    private String bullet = "bullets/bullet_enemy.png";
    private AssetManager loader;

    public EnemyDefaultBullet (AssetManager loader) {
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

    public Texture getEnemyBullet(){
        return loader.get(bullet);
    }
}
