package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class SetDefault {
    JsonReader jsonReader;
    JsonValue jsonValue;
    static FileHandle fileDefault;
    private String pathPlayerStats = "..\\DefaultStats\\PlayerStats.json";

    String tekstTEST = "{\n" +
            "  \"id\": 1,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 2,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 2,\n" +
            "  \"SpeedSideways\": 2\n" +
            "}";

    public SetDefault(){
        this.jsonReader = new JsonReader();
    }

     public void setDefaultPlayerStats(){
         fileDefault = Gdx.files.classpath(pathPlayerStats);
         jsonValue = jsonReader.parse(fileDefault);
         Data.write.writeEntireJson(Data.filePlayerStats, jsonValue.toString());
     }

}
