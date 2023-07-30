package com.mygdx.game.background;

import com.badlogic.gdx.graphics.Texture;

public class Star {

    private Texture texture;
    private int x;
    private int y;

    public Star(int x, int y){
        this.x = x;
        this.y = y;
        setDefaultTexture();
    }

    private void setDefaultTexture(){
        texture = new Texture("star.png");
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
