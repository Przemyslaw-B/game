package com.mygdx.game.data;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.player.Ship;
import com.mygdx.game.player.Statistics;

public class Data {
    Reading reading;
    Writing writing;
    FileHandle file;
    JsonReader jsonReader;
    JsonValue jsonValue;


    public Data() {
        this.file = Gdx.files.local("data/playerStats.json");
        this.jsonReader = new JsonReader();

        fileCheck(file);
        fileCheck(file);
        writeJson(file);

        this.jsonValue = jsonReader.parse(file);
        readJson(jsonValue);
        readJson(jsonValue.get("health"));


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

    public void writeJson(FileHandle file){
        String tekst = "{\"health\":1, \"damage\":5}";
        file.writeString(tekst, false);

    }


}
