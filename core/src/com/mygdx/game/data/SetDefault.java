package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class SetDefault {
    JsonReader jsonReader;
    JsonValue jsonValue;
    String defaultPlayerStat = "{\n" +
            "  \"id\": 1,\n" +
            "  \"health\": 3,\n" +
            "  \"damage\": 2,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 7,\n" +
            "  \"speedSideways\": 7\n" +
            "}";

    String defaultEnemyStats = "{\n" +
            "  \"id\": 2,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 1,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 7,\n" +
            "  \"speedSideways\": 7\n" +
            "  \"points\": 1\n" +
            "}";

    public SetDefault(){
        this.jsonReader = new JsonReader();
    }

     public void setDefaultPlayerStats(){
        Data.write.writeEntireJson(Data.filePlayerStats, defaultPlayerStat);
     }
     public void setDefaultEnemyStat(){
        Data.write.writeEntireJson(Data.fileEnemyStats, defaultEnemyStats);
     }

}
