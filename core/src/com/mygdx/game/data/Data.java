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
    public static SetDefault setDefault;
    public static final String playerStats = "data/playerStats.json";
    static FileHandle filePlayerStats;
    JsonReader jsonReader;
    JsonValue jsonValue;


    public Data() {
        this.write = new Writing();
        this.read = new Reading();
        this.setDefault = new SetDefault();

        this.filePlayerStats = Gdx.files.local(playerStats);
        this.jsonReader = new JsonReader();

        //fileCheck(filePlayerStats);

        //write.writeEntireJson(file, tekstTEST);
        makeFile(filePlayerStats);
        setDefault.setDefaultPlayerStats();
        System.out.println("BEFORE UPDATE!");
        read.readJson(filePlayerStats);
        write.updateJson(filePlayerStats, "damage", 10);
        System.out.println("AFTER UPDATE!");
        read.readJson(filePlayerStats);
        //this.jsonValue = jsonReader.parse(file);
        //readJson(jsonValue);
        //readJson(jsonValue.get("health"));
        System.out.println("AFTER SETTING DEFAULT!");
        setDefault.setDefaultPlayerStats();
        read.readJson(filePlayerStats);

    }

    public static boolean fileCheck(FileHandle file){
        if(file.exists()){
            return true;
        }
        return false;
    }

    public static void makeFile(FileHandle file){
        if(!file.exists()){
            file.write(false);
        } else {
            System.out.println("PLIK JUŻ ISTNIEJE!");
        }
    }




}
