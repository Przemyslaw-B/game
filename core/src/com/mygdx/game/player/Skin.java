package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.TextureLoader.TexturesLoader;

public class Skin{
    private static Texture shipTexture;
    private static TextureRegion shipMyTextureRegion;
    private static TextureRegionDrawable shipMyTextureRegionDrawable;
    private Sprite sprite;
    private TexturesLoader manager;

    public Skin(TexturesLoader manager){
        this.manager = manager;
        loadShipTexture();

        shipMyTextureRegion = new TextureRegion(shipTexture);
        shipMyTextureRegionDrawable = new TextureRegionDrawable(shipMyTextureRegion);
        sprite = new Sprite(shipTexture,getShipWidth(), getShipHeight());
        setRotation(0);
    }
    public void setShipTexture(String shipTexture){

    }

    private void loadShipTexture(){
        /*
        if(manager.checkUserShipTexture()){
            this.shipTexture = manager.getUserShipTexture();
        } else {
            manager.loadUserShipTexture();
            manager.update();
            manager.finishLoading();
            this.shipTexture = manager.getUserShipTexture();
        }
         */
        shipTexture = manager.getPlayerLoader().getPlayerShipTexture();
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

    public TextureRegion getShipMyTextureRegion(){return shipMyTextureRegion;}
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
