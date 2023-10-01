package com.mygdx.game.data;

import com.badlogic.gdx.files.FileHandle;

public class Create {

    public Create(){}

    public static boolean fileCheck(FileHandle file){
        if(file.exists()){
            return true;
        }
        return false;
    }

    public static void makeFile(FileHandle file){
        if(!file.exists()){
            file.write(false);
        } else {
            System.out.println("PLIK JUŻ ISTNIEJE!");
        }
    }
}
