package com.mygdx.game.TextureLoader.BulletsLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.TextureLoader.BulletsLoader.EnemyBullets.EnemyDefaultBullet;
import com.mygdx.game.TextureLoader.BulletsLoader.PlayerBullets.PlayerDefaultBullet;

public class BulletsLoader {
    private AssetManager loader;
    private PlayerDefaultBullet playerBullet;
    private EnemyDefaultBullet enemyBullet;

    public BulletsLoader(AssetManager loader) {
        this.loader = loader;
        this.playerBullet = new PlayerDefaultBullet(loader);
        this.enemyBullet = new EnemyDefaultBullet(loader);
    }

    public PlayerDefaultBullet getPlayerBullet() {
        return playerBullet;
    }

    public EnemyDefaultBullet getEnemyBullet(){
        return enemyBullet;
    }
}
