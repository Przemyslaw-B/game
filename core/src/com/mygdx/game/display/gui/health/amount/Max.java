package com.mygdx.game.display.gui.health.amount;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.health.Number;

public class Max implements Number {
    String path = "health/numbers/MAX.png";
    final Texture texture;
    final TextureRegion textureRegion;

    public Max(TexturesLoader manager) {
        this.texture = manager.getHealthNumbersLoader().getMaxTexture();
        this.textureRegion = new TextureRegion(texture);
    }

    public int endWidth() {
        return textureRegion.getRegionWidth() / 2;
    }

    @Override
    public void draw(int valueX, int valueY) {
        int x = valueX + textureRegion.getRegionWidth() / 2;
        Drop.batch.draw(texture, x, valueY);
    }
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
}