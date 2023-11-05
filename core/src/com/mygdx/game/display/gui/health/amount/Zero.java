package com.mygdx.game.display.gui.health.amount;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.health.Number;

public class Zero implements Number {
    String path = "health/numbers/0.png";
    final Texture texture;
    final TextureRegion textureRegion;
    public Zero(){
        this.texture = new Texture(Gdx.files.internal("score/numbers/0.png"));
        this.textureRegion = new TextureRegion(texture);
    }

    public int endWidth() {
        return textureRegion.getRegionWidth() / 2;
    }
    @Override
    public void draw(int valueX, int valueY) {
        Drop.batch.draw(texture, valueX, valueY);
    }
}
