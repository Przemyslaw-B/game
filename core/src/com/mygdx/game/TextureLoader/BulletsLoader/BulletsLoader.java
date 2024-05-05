package com.mygdx.game.TextureLoader.BulletsLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
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

    public Texture getBulletTexture(int id) {
        switch (id) {
            case 1:
                return playerBullet.getPlayerDefaultBullet();

            case 2:
                return enemyBullet.getEnemyDefaultBullet();

            default:
                return enemyBullet.getEnemyDefaultBullet();
        }
    }
}
