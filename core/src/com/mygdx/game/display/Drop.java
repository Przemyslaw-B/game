package com.mygdx.game.display;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.display.gui.MainMenuScreen;

public class Drop extends Game {

    public static SpriteBatch batch;
    public static BitmapFont font;

    public void create() {
        if(batch == null && font == null) {
            batch = new SpriteBatch();
            font = new BitmapFont(); // use libGDX's default Arial font
            this.setScreen(new MainMenuScreen(this));
        }
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}