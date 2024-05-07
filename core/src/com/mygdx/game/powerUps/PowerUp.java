package com.mygdx.game.powerUps;

import com.mygdx.game.TextureLoader.PowerUps.HealthUpLoader;
import com.mygdx.game.player.Ship;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.powerUps.healthUp.HealthUp;

public class   PowerUp {
    private Ship player;
    private TexturesLoader manager;
    private HealthUp healthUp;

    public PowerUp(TexturesLoader manager, Ship player){
        this.player = player;
        this.manager = manager;
    }
}
