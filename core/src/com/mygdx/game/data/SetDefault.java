package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class SetDefault {
    JsonReader jsonReader;
    JsonValue jsonValue;
    static FileHandle fileDefault;
    private String pathPlayerStats = "./game/data/DefaultStats/PlayerStats.json";

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
        if(!Data.fileCheck(Data.filePlayerStats)){
            Data.makeFile(Data.filePlayerStats);
        }
        //TODO ZŁA ŚCIEŻKA DO PLIKU PIERWSZEGO ODCZYTU USTAWIEŃ DOMYŚLNYCH Z PROJEKTU
        fileDefault = new FileHandle(pathPlayerStats);
        System.out.println("Czy plik domyślnych statystyk gracza istnieje? - " + Data.fileCheck(fileDefault));
        jsonValue = jsonReader.parse(fileDefault);
        Data.write.writeEntireJson(Data.filePlayerStats, jsonValue.toString());
     }

}
