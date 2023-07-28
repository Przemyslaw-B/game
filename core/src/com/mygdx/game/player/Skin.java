package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Skin extends Ship{
    private Texture shipTexture;
    private TextureRegion shipMyTextureRegion;


    public Skin(){
        shipTexture = new Texture("ship.png");
    }
    public void setShipTexture(String shipTexture){
        this.shipTexture = new Texture(shipTexture);
        shipMyTextureRegion = new TextureRegion(this.shipTexture);
    }

    public int getShipWidth(){
        return shipMyTextureRegion.getRegionWidth();
    }

    public int getShipHeight(){
        return shipMyTextureRegion.getRegionHeight();
    }


}
