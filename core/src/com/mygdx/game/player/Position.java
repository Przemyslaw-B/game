package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;

public class Position extends Statistics{
    private static int shipX;
    private static int shipY;

    public Position(){  //starting position is in the middle of the screen
        shipX = Gdx.app.getGraphics().getWidth()/2;
        shipY = Gdx.app.getGraphics().getHeight()/2;
    }

    public static int getShipPositionX(){return shipX;}

    public void setShipPositionX(int shipX){
        this.shipX =shipX;
    }

    public static int getShipPositionY(){
        return shipY;
    }

    public void setShipPositionY(int shipY){
        this.shipY=shipY;
    }

}
