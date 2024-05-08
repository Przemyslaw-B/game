package com.mygdx.game.display.gui.gameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.gui.DrawScore;
import com.mygdx.game.score.Score;

public class DrawScoreAtTheEnd {
    private int score;
    private DrawScore drawScore;
    private TexturesLoader manager;
    int width;
    int height;

    public DrawScoreAtTheEnd(TexturesLoader manager) {
        this.manager = manager;
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.score = Score.getScore();
        this.drawScore = new DrawScore(manager, score);
    }

    public void draw(int x, int y){
        drawScore.draw(x,y);
    }
}
