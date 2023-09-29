package com.mygdx.game.data;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Reading {

    JsonReader jsonReader;
    JsonValue jsonValue;
    public Reading(){
        this.jsonReader = new JsonReader();
    }

    public void readJson(JsonValue json){System.out.println(json);}
    public void readJson(FileHandle file){
        this.jsonValue = jsonReader.parse(file);
        System.out.println(jsonValue);
    }


}
