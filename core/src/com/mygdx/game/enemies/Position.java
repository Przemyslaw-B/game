package com.mygdx.game.enemies;

import java.util.random.*;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y=y;
    }

    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
}