package com.mygdx.game.TextureLoader.EnemyLoader.Simple;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class SimpleEnemyLoader {
    private AssetManager loader;
    private String enemy = "enemy.png";

    public SimpleEnemyLoader(AssetManager loader) {
        this.loader = loader;
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadEnemy(){
        if(!isLoaded(enemy)){
            loader.load(enemy, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }
}
