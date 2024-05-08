package com.mygdx.game.score;

import com.mygdx.game.data.Data;

public class Score {
    private static int score;
    private static double multiplier = 1.0;
    private static int topScore;
    public Score(){
        //reset();
        getTopScore();
    }

    public static void addToScore(int value){
        score += value * multiplier;
    }
    public static int getScore(){
        return score;
    }

    public void setMultiplier(double value){
        this.multiplier += multiplier + value;
    }

    public void resetMultiplier(){
        this.multiplier = 1.0;
    }

    public static void resetScore(){
        score = 0;
    }

    public void reset(){
        resetMultiplier();
        resetScore();
    }

    public static int getTopScore(){
        return Data.read.getFromFile(Data.fileLevelStats, "topScore");
    }

    private static void setNewTopScore(int newScore){
        Data.write.updateJson(Data.fileLevelStats, "topScore", newScore);
        topScore = newScore;
    }

    public static boolean isNewTopScore(){
        if(score > getTopScore()){
            setNewTopScore(score);
            return true;
        }
        return false;
    }


}
