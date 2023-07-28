package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;

public class Position extends Ship{
    private static int shipX;
    private static int shipY;

    public Position(){  //starting position is in the middle of the screen
        shipX = Gdx.app.getGraphics().getHeight()/2;
        shipY = Gdx.app.getGraphics().getWidth()/2;
    }

    public int getShipPositionX(){
        return shipX;
    }

    public void setShipPositionX(int shipX){
        Position.shipX =shipX;
    }

    public int getShipPositionY(){
        return shipY;
    }

    public void setShipPositionY(int shipY){
        Position.shipY=shipY;
    }

}
