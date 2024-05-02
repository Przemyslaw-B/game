package com.mygdx.game.TextureLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.UILoader.HealthLoader;
import com.mygdx.game.TextureLoader.UILoader.HealthNumbersLoader;
import com.mygdx.game.TextureLoader.UILoader.ScoreLoader;
import com.mygdx.game.TextureLoader.UILoader.ScoreNumbersLoader;

public class TexturesLoader {
    private String starAsset = "star.png";
    private String enemyBulletAsset = "bullets/bullet_enemy.png";
    private String userBulletAsset = "bullets/bullet.png";
    private String userShipAsset = "ship.png";
    private String enemyShipAsset_2 = "enemy.png";

    private String heartAsset = "health/heart.png";
    private String scoreAsset = "score/score.png";
    private String healthAsset = "health/x.png";

    private String healthUpAsset = "powerUps/healthUp.png";

    private AssetManager asset;


    HealthLoader healthLoader;
    HealthNumbersLoader healthNumbersLoader;
    ScoreLoader scoreLoader;
    ScoreNumbersLoader scoreNumbersLoader;

    public TexturesLoader(){
         this.asset=new AssetManager();
         this.scoreLoader = new ScoreLoader(asset);
         this.scoreNumbersLoader = new ScoreNumbersLoader(asset);
         this.healthLoader = new HealthLoader(asset);
         this.healthNumbersLoader = new HealthNumbersLoader(asset);
    }

    public void disposeALLTextures(){
        asset.dispose();
    }

    public void disposeAtEndOfLevel(){

    }

    public void update(){
        asset.update();
    }


    public void finishLoading(){
        asset.finishLoading();
    }

    public void loadBulletTexture(int id){
        if(!checkBulletTexture(id)){
            switch (id){
                case 1:
                    asset.load(userBulletAsset, Texture.class);
                    break;

                case 2:
                    asset.load(enemyBulletAsset, Texture.class);
                    break;

                default:
                    asset.load(enemyBulletAsset, Texture.class);
                    break;
            }
            asset.update();
            asset.finishLoading();
        }
    }

    public Texture getBulletTexture(int id){
        if(!checkBulletTexture(id)){
            loadBulletTexture(id);
        }
        switch (id){
            case 1:
                return asset.get(userBulletAsset);

            case 2:
                return asset.get(enemyBulletAsset);

            default:
                return asset.get(userBulletAsset);
        }
    }

    private boolean checkBulletTexture(int id){
        switch (id){
            case 1:
                if(asset.isLoaded(userBulletAsset)){
                    return true;
                } else {
                    return false;
                }

            case 2:
                if(asset.isLoaded(enemyBulletAsset)){
                    return true;
                } else {
                    return false;
                }

            default:
                if(asset.isLoaded(enemyBulletAsset)){
                    return true;
                } else {
                    return false;
                }
        }
    }


    public void loadUserShipTexture(){
        asset.load(userShipAsset, Texture.class);
    }
    public Texture getUserShipTexture(){return asset.get(userShipAsset, Texture.class);}
    public boolean checkUserShipTexture(){
        if(asset.isLoaded(userShipAsset)){
            return true;
        }
        return false;
    }


    public void loadEnemyShipTexture(int id){
        if(!checkEnemyShipTexture(id)){
            switch (id){
                case 2:
                    asset.load(enemyShipAsset_2, Texture.class);
                    break;

                default:
                    asset.load(enemyShipAsset_2, Texture.class);
                    break;
            }
            asset.update();
            asset.finishLoading();
        }
    }

    public boolean checkEnemyShipTexture(int id){
            switch (id){
                case 2:
                    if(asset.isLoaded(enemyShipAsset_2)){
                        return true;
                    } else {
                        return false;
                    }
                default:
                    if(asset.isLoaded(enemyShipAsset_2)){
                        return true;
                    } else {
                        return false;
                    }
            }
    }

    public Texture getEnemyShipTexture(int id){
        if(!checkEnemyShipTexture(id)){
            loadEnemyShipTexture(id);
        }
        switch (id){
            case 2:
                return asset.get(enemyShipAsset_2);
            default:
                return asset.get(enemyShipAsset_2);
        }
    }


    public void loadStarTexture(){
        asset.load(starAsset, Texture.class);
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
