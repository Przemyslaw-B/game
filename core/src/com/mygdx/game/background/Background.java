package com.mygdx.game.background;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;

import java.util.ArrayList;

public class Background {

    private float speedPerSec;
    private final StarMap starMap;
    private float time;
    private float newPosition;
    private TexturesLoader manager;

    public Background(TexturesLoader manager){
        this.manager = manager;
        starMap = new StarMap(manager);
        speedPerSec = 50f;
        time=0f;
    }

    public void setSpeedPerSec(float speedPerSec){
        this.speedPerSec = speedPerSec;
    }
    public float getSpeedPerSec(){
        return speedPerSec;
    }

    public void move(float delta){

        ArrayList<Star> tempMap = starMap.getStarMap();
        for(int i=0; i<tempMap.size()-1; i++){
            if(tempMap.get(i).getY() > 0){
                newPosition = tempMap.get(i).getY();
                newPosition -= speedPerSec*delta;
                tempMap.get(i).setY(newPosition);
            } else {
                starMap.renewSingleStar(i);
            }
        }

    }

    public void draw(){

        ArrayList<Star> tempStarMap = starMap.getStarMap();
        for(int i=0; i<tempStarMap.size()-1; i++){
            Star star = tempStarMap.get(i);
            Texture starTexture = star.getTexture();
            int starX = star.getX();
            int starY = star.getY();
            Drop.batch.draw(starTexture, starX, starY);
        }

    }


}
