package com.mygdx.game.enemies;

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

    public Skin(int id){
        shipTexture = new Texture(Gdx.files.internal("enemy.png"));
        shipMyTextureRegion = new TextureRegion(shipTexture);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        sprite = new Sprite(shipTexture,getShipWidth(), getShipHeight());
        sprite.setRotation(180);
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
    public TextureRegion getTextureRegion(){return shipMyTextureRegion;}

    public TextureRegionDrawable getShipMyTextureRegionDrawable(){
        return shipMyTextureRegionDrawable;
    }

    public Sprite getSprite(){
        return sprite;
    }
    public int getRotation(){
        return 360-(int) sprite.getRotation();
    }

    public void setPositionSprite(int x, int y){
        sprite.setPosition((float) x, (float) y);
    }

    public Sprite getSprite(float degree){
        sprite.setRotation(degree);
        return sprite;
    }

}

