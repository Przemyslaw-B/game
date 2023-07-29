package com.mygdx.game.background;

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
    }
    public void createStarMap(){
        setRowsAmount(defaultRowsAmount);
    }

    private void setStarsAmount(){
        starsAmount = rowsAmount*columnsAmount;
    }

    private void generateSky(){
        int tempHeight=0;
        int tempWidth=0;
        setStarsAmount();
        starMap = new int[starsAmount][2];

    }



}
