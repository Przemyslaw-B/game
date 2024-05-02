package com.mygdx.game.TextureLoader.UILoader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class HealthNumbersLoader {
    private String zero = "health/numbers/0.png";
    private String one = "health/numbers/1.png";
    private String two = "health/numbers/2.png";
    private String three = "health/numbers/3.png";
    private String four = "health/numbers/4.png";
    private String five = "health/numbers/5.png";
    private String six = "health/numbers/6.png";
    private String seven = "health/numbers/7.png";
    private String eight = "health/numbers/8.png";
    private String nine = "health/numbers/9.png";
    private String max = "health/numbers/MAX.png";

    private AssetManager loader;

    public HealthNumbersLoader(AssetManager loader) {
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
        loadMax();
    }

    private void loadZero(){
        if (!isLoaded(zero)) {
            loader.load(zero, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadOne(){
        if (!isLoaded(one)) {
            loader.load(one, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadTwo() {
        if (!isLoaded(two)) {
            loader.load(two, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadThree() {
        if (!isLoaded(three)) {
            loader.load(three, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadFour() {
        if (!isLoaded(four)) {
            loader.load(four, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadFive() {
        if (!isLoaded(five)) {
            loader.load(five, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadSix() {
        if (!isLoaded(six)) {
            loader.load(six, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadSeven() {
        if (!isLoaded(seven)) {
            loader.load(seven, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadEight() {
        if (!isLoaded(eight)) {
            loader.load(eight, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadNine() {
        if (!isLoaded(nine)) {
            loader.load(nine, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

    private void loadMax(){
        if (!isLoaded(max)){
            loader.load(max, Texture.class);
            loader.update();
            loader.finishLoading();
        }
    }

}
