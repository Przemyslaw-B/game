package com.mygdx.game.background;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.data.TexturesLoader;

public class Star {

    private Texture texture;
    private float x;
    private float y;
    private TexturesLoader manager;

    public Star(int x, int y, TexturesLoader manager){
        this.x = x;
        this.y = y;
        this.manager = manager;

        setDefaultTexture();
    }

    private void setDefaultTexture(){
        manager.asset.update();
        if(manager.checkStarAsset()){
            texture = manager.getStarAsset();
        } else{
            manager.loadStarTexture();
            setDefaultTexture();
        }
    }

    public void setX(float x){
        this.x = x;
    }
    public int getX(){
        return (int)x;
    }
    public void setY(float y){
        this.y = y;
    }
    public int getY(){
        return (int)y;
    }
    public void setTexture(Texture texture){
        this.texture = texture;
    }
    public void setTexture(String texture){
        this.texture = new Texture(texture);
    }
    public Texture getTexture(){
        return texture;
    }
}
