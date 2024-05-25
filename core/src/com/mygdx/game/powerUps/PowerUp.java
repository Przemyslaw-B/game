package com.mygdx.game.powerUps;

import com.mygdx.game.TextureLoader.PowerUps.HealthUpLoader;
import com.mygdx.game.player.Ship;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.powerUps.addidionalBullet.AdditionalBullet;
import com.mygdx.game.powerUps.damageUp.DamageUp;
import com.mygdx.game.powerUps.healthUp.HealthUp;

public class   PowerUp {
    private Ship player;
    private TexturesLoader manager;
    private HealthUp healthUp;
    private SpawnedPowerUps spawnedPowerUps;
    private Drawing drawing;

    public PowerUp(TexturesLoader manager, Ship player){
        this.player = player;
        this.manager = manager;
        this.drawing = new Drawing(manager);
    }

    public void dropHealthUp(int x, int y){
        SpawnedPowerUps.healthUpArray.add(new HealthUp(manager, player, x, y));
    }

    public void dropDamageUp(int x, int y){
        SpawnedPowerUps.damageUpArray.add(new DamageUp(manager, player, x, y));
    }

    public void dropAdditionalBullet(int x, int y){
        SpawnedPowerUps.additionalBulletsArray.add(new AdditionalBullet(manager, player, x, y));
    }

    public void draw(){

    }
}
