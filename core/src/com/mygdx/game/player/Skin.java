package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Skin{
    private static Texture shipTexture;
    private static TextureRegion shipMyTextureRegion;
    private static TextureRegionDrawable shipMyTextureRegionDrawable;
    private Sprite sprite;

    public Skin(){
        shipTexture = new Texture(Gdx.files.internal("ship.png"));
        shipMyTextureRegion = new TextureRegion(shipTexture);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        sprite = new Sprite(shipTexture,getShipWidth(), getShipHeight());
        setRotation(0);
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
    public int getRotation(){
        return 360-(int) sprite.getRotation();
    }

    public void setRotation(int rotation){
        sprite.setRotation(360-rotation);
    }
    public Sprite getSprite(float degree){
        sprite.setRotation(degree);
        return sprite;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public void setPositionSprite(int x, int y){
        sprite.setPosition((float) x, (float) y);
    }




}
