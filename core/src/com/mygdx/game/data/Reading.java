package com.mygdx.game.data;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

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
        //System.out.println("Size: " + jsonValue.size());
    }


}
