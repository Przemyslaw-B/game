package com.mygdx.game.TextureLoader.UILoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class ScoreLoader {
    private AssetManager loader;
    private String score = "score/score.png";
    private String newWord = "score/new.png";
    private String topScore = "score/topScore.png";


    public ScoreLoader(AssetManager loader){
        this.loader = loader;
        loadScoreUI();
    }

    private void loadScoreUI(){
        loadScoreWord();
        loadNewWord();
        loadTopScoreWord();
    }

    private boolean isLoaded(String filename){
        if(loader.isLoaded(filename)){
            return true;
        }
        return false;
    }

    private void loadScoreWord(){
        if(!isLoaded(score)){
            loader.load(score, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadNewWord(){
        if(!isLoaded(newWord)){
            loader.load(newWord, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadTopScoreWord(){
        if(!isLoaded(topScore)){
            loader.load(topScore, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }


}
