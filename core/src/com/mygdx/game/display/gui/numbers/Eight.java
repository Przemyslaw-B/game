package com.mygdx.game.display.gui.numbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;

public class Eight implements Number{
    String path = "score/numbers/8.png";
    final Texture texture;
    final TextureRegion textureRegion;

    public Eight(TexturesLoader manager){
        this.texture = manager.getScoreNumbersLoader().getEightTexture();
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

    public int getWidth(){
        return textureRegion.getRegionWidth();
    }

    public int getHeight(){
        return textureRegion.getRegionHeight();
    }

}
