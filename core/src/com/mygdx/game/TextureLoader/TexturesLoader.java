package com.mygdx.game.TextureLoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.BacgroundLoader.BackgroundLoader;
import com.mygdx.game.TextureLoader.BulletsLoader.BulletsLoader;
import com.mygdx.game.TextureLoader.BulletsLoader.EnemyBullets.EnemyDefaultBullet;
import com.mygdx.game.TextureLoader.EnemyLoader.EnemyLoader;
import com.mygdx.game.TextureLoader.MainMenuLoader.MainMenuLoader;
import com.mygdx.game.TextureLoader.PlayerLoader.PlayerLoader;
import com.mygdx.game.TextureLoader.PowerUps.PowerUpsLoader;
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
    PowerUpsLoader powerUpsLoader;

    BackgroundLoader backgroundLoader;
    BulletsLoader bulletsLoader;
    EnemyLoader enemyLoader;
    MainMenuLoader mainMenuLoader;
    PlayerLoader playerLoader;



    public TexturesLoader(){
        this.asset=new AssetManager();
        this.scoreLoader = new ScoreLoader(asset);
        this.scoreNumbersLoader = new ScoreNumbersLoader(asset);
        this.healthLoader = new HealthLoader(asset);
        this.healthNumbersLoader = new HealthNumbersLoader(asset);

        this.powerUpsLoader = new PowerUpsLoader(asset);
        this.backgroundLoader = new BackgroundLoader(asset);
        this.bulletsLoader = new BulletsLoader(asset);
        this.enemyLoader = new EnemyLoader(asset);
        this.mainMenuLoader = new MainMenuLoader(asset);
        this.playerLoader = new PlayerLoader(asset);
        loadAll();
    }

    public PowerUpsLoader getPowerUpsLoader(){
        return powerUpsLoader;
    }

    public PlayerLoader getPlayerLoader(){
        return playerLoader;
    }

    public HealthLoader getHealthLoader() {
        return healthLoader;
    }

    public BulletsLoader getBulletsLoader() {
        return bulletsLoader;
    }

    public EnemyLoader getEnemyLoader() {
        return enemyLoader;
    }

    public HealthNumbersLoader getHealthNumbersLoader() {
        return healthNumbersLoader;
    }

    public ScoreLoader getScoreLoader() {
        return scoreLoader;
    }

    public MainMenuLoader getMainMenuLoader() {
        return mainMenuLoader;
    }

    public ScoreNumbersLoader getScoreNumbersLoader() {
        return scoreNumbersLoader;
    }


    private void loadAll(){
        while(!checkIfAllIsLoaded(asset)){
            System.out.println("Nie załadowano jeszcze wszystkich tekstur!");
        }
        System.out.println("Wszystko załadowane!");
    }

    private boolean checkIfAllIsLoaded(AssetManager assetManager){
        assetManager.update();
        if(assetManager.isFinished()){
            return true;
        }
        return false;
    }


    public BackgroundLoader getBackgroundLoader(){
        return backgroundLoader;
    }


    public void disposeALLTextures(){
        asset.dispose();
    }

    public void disposeAtEndOfLevel(){}

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
