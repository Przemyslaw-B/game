package com.mygdx.game.score;

import com.mygdx.game.data.Data;

public class Score {
    private int score;
    private double multiplier;
    private int topScore;
    public Score(){
        reset();
        getTopScore();
    }

    public void addToScore(int value){
        this.score += value * multiplier;
    }
    public int getScore(){
        return this.score;
    }

    public void setMultiplier(double value){
        this.multiplier += multiplier + value;
    }

    public void resetMultiplier(){
        this.multiplier = 1.0;
    }

    public void resetScore(){
        this.score = 0;
    }

    public void reset(){
        resetMultiplier();
        resetScore();
    }

    public int getTopScore(){
        return Data.read.getFromFile(Data.fileLevelStats, "topScore");
    }

    private void setNewTopScore(int newScore){
        Data.write.updateJson(Data.fileLevelStats, "topScore", newScore);
        topScore = newScore;
    }

    public boolean isNewTopScore(){
        if(score > topScore){
            setNewTopScore(score);
            return true;
        }
        return false;
    }
}
