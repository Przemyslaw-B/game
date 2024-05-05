package com.mygdx.game.TextureLoader.UILoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class ScoreNumbersLoader {
    private String zero = "score/numbers/0.png";
    private String one = "score/numbers/1.png";
    private String two = "score/numbers/2.png";
    private String three = "score/numbers/3.png";
    private String four = "score/numbers/4.png";
    private String five = "score/numbers/5.png";
    private String six = "score/numbers/6.png";
    private String seven = "score/numbers/7.png";
    private String eight = "score/numbers/8.png";
    private String nine = "score/numbers/9.png";

    private AssetManager loader;
    public ScoreNumbersLoader(AssetManager loader) {
        this.loader = loader;
        loadNumbers();
    }

    private boolean isLoaded(String filename) {
        if(loader.isLoaded(filename)) {
            return true;
        }
        return false;
    }

    private void loadNumbers(){
        loadZero();
        loadOne();
        loadTwo();
        loadThree();
        loadFour();
        loadFive();
        loadSix();
        loadSeven();
        loadEight();
        loadNine();
    }

    private void loadZero(){
        if (!isLoaded(zero)) {
            loader.load(zero, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getZeroTexture(){
        return loader.get(zero);
    }

    private void loadOne(){
        if (!isLoaded(one)) {
            loader.load(one, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getOneTexture(){
        return loader.get(one);
    }

    private void loadTwo() {
        if (!isLoaded(two)) {
            loader.load(two, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getTwoTexture(){
        return loader.get(two);
    }

    private void loadThree() {
        if (!isLoaded(three)) {
            loader.load(three, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getThreeTexture(){
        return loader.get(three);
    }

    private void loadFour() {
        if (!isLoaded(four)) {
            loader.load(four, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getFourTexture(){
        return loader.get(four);
    }

    private void loadFive() {
        if (!isLoaded(five)) {
            loader.load(five, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getFiveTexture(){
        return loader.get(five);
    }

    private void loadSix() {
        if (!isLoaded(six)) {
            loader.load(six, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getSixTexture(){
        return loader.get(six);
    }

    private void loadSeven() {
        if (!isLoaded(seven)) {
            loader.load(seven, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getSevenTexture(){
        return loader.get(seven);
    }

    private void loadEight() {
        if (!isLoaded(eight)) {
            loader.load(eight, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getEightTexture(){
        return loader.get(eight);
    }

    private void loadNine() {
        if (!isLoaded(nine)) {
            loader.load(nine, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    public Texture getNineTexture(){
        return loader.get(nine);
    }

}

