package com.mygdx.game.score;

public class Score {
    private int score;
    private double multiplier;
    public Score(){
        reset();
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
}
