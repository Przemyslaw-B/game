package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Writing {

    public Writing(){

    }

    public void writeJson(FileHandle file, String tekst){
        file.writeString(tekst, false);
    }

    public void writeJson(FileHandle file, String tekst, int value){
        //TODO zapis tylko jednej zmiennej
        //file.writeString(tekst, false);
    }

}

