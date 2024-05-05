package com.mygdx.game.TextureLoader.PowerUps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class PowerUpsLoader {


    private AssetManager loader;
    private HealthUpLoader healthUpLoader;
    private DamageUpLoader damageUpLoader;

    public PowerUpsLoader(AssetManager loader) {
        this.loader = loader;
        loadAllPowerUps();
    }


    private void loadAllPowerUps(){
        this.healthUpLoader = new HealthUpLoader(loader);
        this.damageUpLoader = new DamageUpLoader(loader);
    }

    public HealthUpLoader getHealthUpLoader() {
        return healthUpLoader;
    }

    public DamageUpLoader getDamageUpLoader() {
        return damageUpLoader;
    }





}
