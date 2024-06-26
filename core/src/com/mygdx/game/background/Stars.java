package com.mygdx.game.background;

import java.util.Random;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class Stars {
    private Texture starTexture;
    private  int width;
    int rowStarsAmount;
    private int height;
    private int starsAmount;
    private int starsLines;
    private TexturesLoader manager;
    Random rand;
    int chance = 75;    // value of chance to get a star from 0 to 99

    public Stars(int width, int height, TexturesLoader manager){
        this.manager = manager;
        this.width = width;
        this.height = height;
        this.rowStarsAmount = 10;
        rand = new Random();
    }

    public Stars(){}

    public void setTexture(){
        this.starTexture = manager.getStarAsset();
    }

    public Texture getStarTexture(){
        return starTexture;
    }


    public void setStarsAmount(int starsAmount) {
        if(starsAmount > 0) {
            this.starsAmount = starsAmount;
        } else {
            this.starsAmount = 0;
        }
    }

    public void setStarsLines(int density) {
        if(density>0) {
            this.starsLines = density;
        } else{
            this.starsLines = 1;
        }
    }

    private void divide(int density){
        int amount = rowStarsAmount * density;
        setStarsLines(density);
        setStarsAmount(amount);
    }

    public float[][] createSkyMap(int density){
        divide(density);
        float[][] skyMap = new float[starsAmount][2];
        int pieceHeight = height/starsLines;
        int pieceWidth = width/rowStarsAmount;
        int tempHeight = 0;
        int tempWidth = 0;
        for(int i=0; i<starsAmount; i++){
            int val = rand.nextInt(100);
            if(val < chance) {
                skyMap[i][0] = rand.nextInt(pieceWidth) + tempWidth;    // x location of star
                skyMap[i][1] = rand.nextInt(pieceHeight) + tempHeight;  // y location of star
            } else {
                skyMap[i][0] = -1;    // x location of star
                skyMap[i][1] = -1;  // y location of star
            }
            tempWidth += pieceWidth;
            if(tempWidth > width){
                tempWidth = 0;
                tempHeight += pieceHeight;
            }
        }
        return skyMap;
    }

    public void createRowOfSky(int density){

    }

}
