package com.mygdx.game.data;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.player.Ship;
import com.mygdx.game.player.Statistics;

import java.io.BufferedReader;
import java.io.File;

public class Data {
    Reading reading;
    Writing writing;
    FileHandle file;

    BufferedReader reader;


    JsonReader jsonReader;
    JsonValue jsonValue;



    public Data() {
        this.file = Gdx.files.local("data/playerStats.json");

        fileCheck(file);
        System.out.println("~~~~~~~~~~~~~~ UTWORZONO NOWY PLIK ~~~~~~~~~~~~~~");
        fileCheck(file);
        writeJson(file);

        this.jsonValue = jsonReader.parse(file);
        readJson(jsonValue);


    }

    public void fileCheck(FileHandle file){
        if(!file.exists()){
            System.out.println("Plik nie istnieje");
            file.write(false);
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

    public void setDefault(){

    }


}
