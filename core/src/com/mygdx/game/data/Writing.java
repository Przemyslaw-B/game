package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Writing {

    public Writing(){

    }

    public void writeEntireJson(FileHandle file, String tekst){
        if(Create.fileCheck(file)){
            //file.writeString(tekst, false);
        } else{
            Create.makeFile(file);
            file.writeString(tekst, false);
        }
    }

    public void writeExistingJson(FileHandle file, String tekst){
        if(Create.fileCheck(file)){
            file.writeString(tekst, false);
        } else{
            Create.makeFile(file);
            file.writeString(tekst, false);
        }
    }


    public void updateJson(FileHandle file, String nazwa, int newValue){   //MOŻNA ZMIENIAĆ TYLKO WARTOŚCI INT
        if(!Create.fileCheck(file)){
            Create.makeFile(file);
            System.out.println("Plik nie istnięję. Tworzę plik!");
        } else {System.out.println("Plik już istnieje i nie muszę go tworzyć!");}
        JsonReader jsonReader = new JsonReader();
        JsonValue jsonValue = jsonReader.parse(file);
        if(jsonValue.has(nazwa)){
            System.out.println("Podany parametr istnieje!");
            System.out.println("Json value.size(): " + jsonValue.size());
            HashMap <String, Integer> lista = new HashMap<>();
            for(int i=0; i < jsonValue.size(); i++){
                lista.put(jsonValue.get(i).name(), jsonValue.getInt(i));
            }
            System.out.println(lista);
            StringWriter newJson = new StringWriter();
            newJson.write("{\n");
            for(String parameter : lista.keySet()){
                if(parameter.equals(nazwa)){
                    newJson.write("\"" + parameter + "\": " + newValue + ",\n");
                    System.out.println("Tutaj podmianka: parameter = new " + parameter + ", newValue = new " + newValue);
                } else {
                    newJson.write("\"" + parameter + "\": " + lista.get(parameter) + ",\n");
                    System.out.println("Tutaj bez podmiany: parameter = new " + parameter + ", newValue = new " + lista.get(parameter));
                }
            }
            newJson.write("}");
            //writeEntireJson(file, newJson.toString());
            writeExistingJson(file, newJson.toString());
        } else {System.out.println("Podany parametr nie istnieje!");}
    }
}

