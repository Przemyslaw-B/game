package com.mygdx.game.TextureLoader.EnemyLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.TextureLoader.EnemyLoader.Bosses.BossLoader;
import com.mygdx.game.TextureLoader.EnemyLoader.Simple.SimpleEnemyLoader;

public class   EnemyLoader {

    private AssetManager loader;
    private BossLoader bossLoader;
    private SimpleEnemyLoader simpleEnemyLoader;

    public EnemyLoader(AssetManager loader){
        this.loader = loader;
        this.simpleEnemyLoader = new SimpleEnemyLoader(loader);
        this.bossLoader = new BossLoader(loader);
    }

    public SimpleEnemyLoader getEnemy(){
        return simpleEnemyLoader;
    }

    public BossLoader getBossLoader(){
        return bossLoader;
    }

}
