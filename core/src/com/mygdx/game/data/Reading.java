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
        jsonValue = jsonReader.parse(file);
        System.out.println(jsonValue);
        //System.out.println("Size: " + jsonValue.size());
    }

    public int getFromFile(FileHandle file, String parameter){
        int value = 0;
        jsonValue = jsonReader.parse(file);
        if(jsonValue.get(parameter).isNumber()){
            value = jsonValue.getInt(parameter);
        }
        return value;
    }

    public boolean isParameterExist(FileHandle file, String parameter){
        jsonValue = jsonReader.parse(file);
        if(jsonValue.has(parameter)){
            return true;
        }
        return false;
    }


}
