package com.mygdx.game.background;

import com.badlogic.gdx.graphics.Texture;

public class Star {

    private Texture texture;
    private float x;
    private float y;

    public Star(int x, int y){
        this.x = x;
        this.y = y;
        setDefaultTexture();
    }

    private void setDefaultTexture(){
        texture = new Texture("star.png");
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
