package com.mygdx.game.display.gui.health;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Number {

    public int endWidth();
    public void draw(int valueX, int valueY);
    public TextureRegion getTextureRegion();
}



