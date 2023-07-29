package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Skin extends Ship{
    private Texture shipTexture;
    private TextureRegion shipMyTextureRegion;
    private TextureRegionDrawable shipMyTextureRegionDrawable;

    public Skin(){
        shipTexture = new Texture(Gdx.files.internal("ship.png"));
        shipMyTextureRegion = new TextureRegion(shipTexture);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
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

    public Texture getShipTexture(){
        return shipTexture;
    }

    public TextureRegionDrawable getShipMyTextureRegionDrawable(){
        return shipMyTextureRegionDrawable;
    }


}