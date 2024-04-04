package com.mygdx.game.enemies;

import java.util.random.*;

public class Position {

    private int x;
    private int y;
    private int rotation;
    private boolean isFromTop;

    public Position(int x, int y){
        this.x = x;
        this.y=y;
        this.rotation = 0;
    }

    public Position(int x, int y, int rotation, boolean isFromTop){
        this.x = x;
        this.y=y;
        this.rotation = rotation;
        this.isFromTop = isFromTop;
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

    public int getRotation() {
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public boolean isFromTop() {
        return isFromTop;
    }
}
