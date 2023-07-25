package com.mygdx.game;

import com.mygdx.game.enemies.*;
import com.mygdx.game.bullets.*;
import java.util.ArrayList;
import java.util.List;

public class Fight {
    //static List<Bullet> bullets = new ArrayList<Bullet>();
    Ship ship;
    Enemy enemies;
    public Fight(Enemy enemies, Ship ship){
        this.enemies = enemies;
        this.ship = ship;

    }

    public void shot(int x, int y, int bulletAccelerateX, int bulletAccelerateY, boolean friendlyFire){
        //Bullet newBullet = new Bullet(x, y, bulletAccelerateX, bulletAccelerateY, id);
        //this.bullets.add(newBullet);
    }

}
