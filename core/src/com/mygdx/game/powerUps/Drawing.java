package com.mygdx.game.powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.powerUps.damageUp.DamageUp;
import com.mygdx.game.powerUps.healthUp.HealthUp;

public class Drawing {
    TexturesLoader manager;

    public Drawing(TexturesLoader manager){
        this.manager = manager;
    }

    public void draw(){
        drawHealthUp();
    }

    private void drawHealthUp(){
        if(!SpawnedPowerUps.healthUpArray.isEmpty()){
            for(HealthUp picked : SpawnedPowerUps.healthUpArray){
                int x = picked.getPosition().getX();
                int y = picked.getPosition().getY();
                Drop.batch.draw(picked.getSkin().getTexture(), x, y);
            }
        }
    }

    private void drawDamageUp(){
        if(!SpawnedPowerUps.damageUpArray.isEmpty()){
            for(DamageUp picked : SpawnedPowerUps.damageUpArray){
                int x = 0;
                int y = 0;
            }
        }
    }

    private void drawAdditionalHealth(){

    }

}
