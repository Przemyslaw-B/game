package com.mygdx.game.data;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;

public class Reading {

    JsonValue jsonValue;



    public Reading(){}


    public void readJson(JsonValue json){System.out.println(json);}
    public void readJson(FileHandle file){
        if(!Data.create.fileCheck(file)){
            Data.create.makeFile(file);
        }
        JsonReader jsonReader = new JsonReader();
        jsonValue = jsonReader.parse(file);
        System.out.println(jsonValue);
        //System.out.println("Size: " + jsonValue.size());
    }

    public int getFromFile(FileHandle file, String parameter){
        if(!Data.create.fileCheck(file)){
            Data.create.makeFile(file);
        }
        int value = 0;
        JsonReader jsonReader = new JsonReader();
        jsonValue = jsonReader.parse(file);
        if(jsonValue.get(parameter).isNumber()){
            value = jsonValue.getInt(parameter);
        }
        return value;
    }

    public boolean isParameterExist(FileHandle file, String parameter){
        if(!Data.create.fileCheck(file)){
            Data.create.makeFile(file);
        }
        JsonReader jsonReader = new JsonReader();
        jsonValue = jsonReader.parse(file);
        return jsonValue.has(parameter);
    }

    public static float readPlayerStat(String parameter){
        if(!Data.create.fileCheck(Data.filePlayerStats)){
            Data.create.makeFile(Data.filePlayerStats);
        }
        float value = 0;
        JsonReader jsonRead = new JsonReader();
        JsonValue json = jsonRead.parse(Data.filePlayerStats);
        if(json.has(parameter)){
            value = json.getInt(parameter);
        }
        return value;
    }

    public static float readEnemyStat(int id, String parameter){
        if(!Data.create.fileCheck(Data.fileEnemyStats)){
            Data.create.makeFile(Data.fileEnemyStats);
        }
        float value=0;
        JsonReader jsonRead = new JsonReader();
        JsonValue json = jsonRead.parse(Data.fileEnemyStats);
        if(json.has(parameter)){
            value=json.getInt(parameter);
        }
        return value;
    }


}
