package com.mygdx.game.TextureLoader.EnemyLoader.Bosses;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class BossLoader {
    private AssetManager loader;
    private String boss = "boss.png";

    public BossLoader(AssetManager loader) {
        this.loader = loader;
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadEnemy() {
        if (!isLoaded(boss)) {
            loader.load(boss, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

}
