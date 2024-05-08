package com.mygdx.game.score;

import com.mygdx.game.data.Data;

public class Score {
    private static int score;
    private static double multiplier = 1.0;
    private static boolean isNewTopScore = false;
    public Score(){
        //reset();
        getTopScore();
    }

    public static void addToScore(int value){
        score += (int) Math.round(value * multiplier);
    }
    public static int getScore(){
        return score;
    }

    public static void setMultiplier(double value){
        multiplier = value;
    }

    public static void resetMultiplier(){
        multiplier = 1.0;
    }

    public static void resetScore(){
        score = 0;
    }

    public static void reset(){
        resetMultiplier();
        isNewTopScore = false;
        resetScore();
    }
    public static boolean checkIsNewTopScore(){
        return isNewTopScore;
    }

    public static int getTopScore(){
        return Data.read.getFromFile(Data.fileLevelStats, "topScore");
    }

    private static void setNewTopScore(int newScore){
        Data.write.updateJson(Data.fileLevelStats, "topScore", newScore);
        isNewTopScore = true;
    }

    public static boolean isNewTopScore(){
        if(score > getTopScore()){
            setNewTopScore(score);
            return true;
        }
        return false;
    }


}
