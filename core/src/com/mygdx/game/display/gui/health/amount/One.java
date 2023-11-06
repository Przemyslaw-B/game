package com.mygdx.game.display.gui.health.amount;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.health.Number;

public class One implements Number {
    String path = "health/numbers/1.png";
    final Texture texture;
    final TextureRegion textureRegion;
    public One(){
        this.texture = new Texture(Gdx.files.internal(path));
        this.textureRegion = new TextureRegion(texture);
    }

    public int endWidth() {
        return textureRegion.getRegionWidth() / 2;
    }
    @Override
    public void draw(int valueX, int valueY) {
        int x = valueX + textureRegion.getRegionWidth()/2;
        Drop.batch.draw(texture, x, valueY);
    }
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
}
