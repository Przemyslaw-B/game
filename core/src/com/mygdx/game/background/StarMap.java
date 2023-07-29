package com.mygdx.game.background;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class StarMap {

    private int rowsAmount;
    private int columnsAmount;
    private int starsAmount;
    private int chance;
    private Random rand;
    private Stars star;
    private int defaultRowsAmount;
    private static int[][] starMap;

    public StarMap(){
        defaultRowsAmount = 5;    //default value
        columnsAmount = 10; //defaultValue
        chance = 75;
        star = new Stars();
        createStarMap();
    }

    public int getChance(){
        return chance;
    }
    public void setChance(int chance){
        this.chance = chance;
    }

    private void setRowsAmount(int rowsAmount){
        this.rowsAmount = rowsAmount;
    }

    public void setColumnsAmount(int columnsAmount){
        this.columnsAmount = columnsAmount;
    }

    public void createStarMap(int rowsAmount){
        setRowsAmount(rowsAmount);
        generateSky();
    }
    public void createStarMap(){
        setRowsAmount(defaultRowsAmount);
        generateSky();
    }

    private void setStarsAmount(){
        starsAmount = rowsAmount*columnsAmount;
    }

    private void generateSky(){
        int pieceHeight = Gdx.app.getGraphics().getHeight()/rowsAmount;
        int pieceWIdth = Gdx.app.getGraphics().getWidth()/columnsAmount;
        int tempHeight=0;
        int tempWidth=0;
        setStarsAmount();
        starMap = new int[starsAmount][2];
        for(int i=0; i< starsAmount; i++){
            int val = rand.nextInt(100);
            if(val<chance){
                starMap[i][0] = rand.nextInt(pieceWIdth)+tempWidth;   //    x location of star
                starMap[i][1] = rand.nextInt(pieceHeight)+tempHeight; //    y location of star
            } else {
                starMap[i][0] = -1; // star that will be not displayed
                starMap[i][1] = -1; // star that will be not displayed
            }
            tempWidth += pieceWIdth;
            if(tempWidth > Gdx.app.getGraphics().getWidth()){
                tempWidth = 0;
                tempHeight += pieceHeight;
            }
        }
    }

    public int[][] getSkyMap(){
        return starMap;
    }

    public int getAmountOfStars(){
        return starsAmount;
    }

    public int getSinglaStarX(int index){
        return starMap[index][0];
    }

    public int getSingleStarY(int index){
        return starMap[index][1];
    }




}
