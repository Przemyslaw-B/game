package com.mygdx.game.data;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.player.Ship;
import com.mygdx.game.player.Statistics;

public class Data {
    public static Reading read;
    public static Writing write;
    public static Create create;
    public static SetDefault setDefault;
    public static final String playerStats = "data/playerStats.json";
    public static final String enemyStats = "data/enemyStats.json";
    static FileHandle filePlayerStats;
    static FileHandle fileEnemyStats;
    JsonReader jsonReader;
    JsonValue jsonValue;


    public Data() {
        this.create = new Create();
        this.write = new Writing();
        this.read = new Reading();
        this.setDefault = new SetDefault();
        this.filePlayerStats = Gdx.files.local(playerStats);
        this.fileEnemyStats = Gdx.files.local(enemyStats);
        this.jsonReader = new JsonReader();
        setDefault.setDefaultPlayerStats();
        setDefault.setDefaultEnemyStat();
        read.readJson(filePlayerStats);
        //write.updateJson(filePlayerStats, "damage", 1);
        //System.out.println("AFTER UPDATE!");
        //read.readJson(filePlayerStats);
        //this.jsonValue = jsonReader.parse(file);
        //readJson(jsonValue);
        //readJson(jsonValue.get("health"));
        //System.out.println("AFTER SETTING DEFAULT!");
        //setDefault.setDefaultPlayerStats();
        //read.readJson(filePlayerStats);
    }






}
