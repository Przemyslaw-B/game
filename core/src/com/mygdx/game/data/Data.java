package com.mygdx.game.data;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.player.Ship;
import com.mygdx.game.player.Statistics;

public class Data {
    Reading read;
    Writing write;
    FileHandle file;
    JsonReader jsonReader;
    JsonValue jsonValue;


    public Data() {
        this.write = new Writing();
        this.read = new Reading();

        this.file = Gdx.files.local("data/playerStats.json");
        this.jsonReader = new JsonReader();

        fileCheck(file);
        fileCheck(file);
        String tekstTEST = "{\n" +
                "  \"id\": 1,\n" +
                "  \"health\": 1,\n" +
                "  \"damage\": 2,\n" +
                "  \"attackSpeed\": 1,\n" +
                "  \"speedForward\": 2,\n" +
                "  \"SpeedSideways\": 2\n" +
                "}";
        write.writeJson(file, tekstTEST);

        this.jsonValue = jsonReader.parse(file);
        //readJson(jsonValue);
        //readJson(jsonValue.get("health"));
        read.readJson(file);

    }

    public void fileCheck(FileHandle file){
        if(!file.exists()){
            System.out.println("Plik nie istnieje");
            file.write(false);
            System.out.println("~~~~~~~~~~~~~~ UTWORZONO NOWY PLIK ~~~~~~~~~~~~~~");
        }
        else {
            System.out.println("Plik istnieje!");
        }
    }

    public void readJson(JsonValue json){
        System.out.println(json);
    }




}
