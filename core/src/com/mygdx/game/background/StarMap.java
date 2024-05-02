package com.mygdx.game.background;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.TextureLoader.TexturesLoader;

import java.util.ArrayList;
import java.util.Random;

public class StarMap {

    private int rowsAmount;
    private int columnsAmount;
    private int starsAmount;
    private int chance;
    private Random rand;
    private final int defaultRowsAmount;
    private static ArrayList<Star> starMap;
    private int pieceHeight;
    private int pieceWidth;
    private TexturesLoader manager;

    public StarMap(TexturesLoader manager){
        this.manager = manager;
        rand = new Random();
        defaultRowsAmount = 4;    //default value
        columnsAmount = 8; //defaultValue
        chance = 75;
        starMap = new ArrayList<>();
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
        pieceHeight = Gdx.app.getGraphics().getHeight()/rowsAmount;
        pieceWidth = Gdx.app.getGraphics().getWidth()/columnsAmount;
        int tempHeight=0;
        int tempWidth=0;
        setStarsAmount();
        for(int i=0; i< starsAmount; i++){
            rand=new Random();
            int val = rand.nextInt(100);
            if(val<chance){
                int starX = rand.nextInt(pieceWidth)+tempWidth;   //    x location of star
                int starY = rand.nextInt(pieceHeight)+tempHeight; //    y location of star
                starMap.add(new Star(starX, starY, manager));    //add new star
            }
            tempWidth += pieceWidth;
            if(tempWidth > Gdx.app.getGraphics().getWidth()){
                tempWidth = 0;
                tempHeight += pieceHeight;
            }
        }
    }

    public ArrayList<Star> getStarMap(){
        return starMap;
    }
    public void setStarMap(ArrayList<Star> starMap){
        StarMap.starMap =starMap;
    }

    private int findStarX(int index){
        int beforeX=0;
        int starX=beforeX;
        int tempWidth=pieceWidth;
        while(starMap.get(index).getX() >= tempWidth){
            beforeX = tempWidth;
            starX=beforeX;
            tempWidth += pieceWidth;
        }
        return starX;
    }

    public void renewSingleStar(int index){
        int starX = findStarX(index);
        starMap.get(index).setX(rand.nextInt(pieceWidth)+starX);    //set star X
        starMap.get(index).setY(rand.nextInt(pieceHeight)+Gdx.app.getGraphics().getHeight());   //set star Y
    }

    public int getAmountOfStars(){
        return starsAmount;
    }

    public int getSinglaStarX(int index){
        return starMap.get(index).getX();
    }
    public int getSingleStarY(int index){
        return starMap.get(index).getY();
    }




}
