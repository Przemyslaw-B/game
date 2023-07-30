package com.mygdx.game.background;

public class Background {

    private int speed;
    private final StarMap starMap;
    //private static float time;

    public Background(){
        starMap = new StarMap();
        //time = 0f;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }

    public void move(){
        int[][] tempMap = starMap.getStarMap();
        for(int i=0; i<starMap.getAmountOfStars(); i++){
            if(tempMap[i][1] > 0){
                tempMap[i][1] += speed;
            } else {
                starMap.renewSingleStar(i);
            }
        }
    }

    //public void draw(){}


}
