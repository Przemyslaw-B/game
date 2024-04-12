package com.mygdx.game.data;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.background.Star;
import com.mygdx.game.bullets.Bullet;

public class TexturesLoader {
    public String starAsset = "star.png";



    public AssetManager asset;
    public TexturesLoader(){
         this.asset=new AssetManager();
    }

    public void disposeALLTextures(){
        asset.dispose();
    }

    public void disposeAtEndOfLevel(){

    }



    public void loadBulletTexture(){
        asset.load("bullets/bullet.png", Bullet.class);
        asset.load("bullets/bullet_enemy.png", Bullet.class);
    }

    public void loadUserShipTexture(){
        asset.load("ship.png", com.mygdx.game.player.Skin.class);
    }

    public void loadEnemyShipTexture(){
        asset.load("enemy.png", com.mygdx.game.enemies.Skin.class);
    }

    public void loadStarTexture(){

        //FileHandleResolver resolver = new InternalFileHandleResolver();
        //asset.setLoader(Star.class, new Tex);
        asset.load(starAsset, Star.class);
    }

    public Texture getStarAsset(){
        return asset.get(starAsset);
    }

    public boolean checkStarAsset(){
        if(asset.isLoaded(starAsset)){
            return true;
        }
        return false;
    }

}
