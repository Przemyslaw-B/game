package com.mygdx.game.powerUps;

import com.mygdx.game.powerUps.addidionalBullet.AdditionalBullet;
import com.mygdx.game.powerUps.damageUp.DamageUp;
import com.mygdx.game.powerUps.healthUp.HealthUp;

import java.util.ArrayList;

public class SpawnedPowerUps {
    public static ArrayList<PowerUp> powerUpsArray = new ArrayList<PowerUp>();
    public static ArrayList<HealthUp> healthUpArray = new ArrayList<HealthUp>();
    public static ArrayList<DamageUp> damageUpArray = new ArrayList<DamageUp>();
    public static ArrayList<AdditionalBullet> additionalBulletsArray = new ArrayList<AdditionalBullet>();
}
