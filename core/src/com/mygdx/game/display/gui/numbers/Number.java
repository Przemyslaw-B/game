package com.mygdx.game.display.gui.numbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Number {

    public int endWidth();
    public void draw(int valueX, int valueY);
}



