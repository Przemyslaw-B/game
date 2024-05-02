package com.mygdx.game.levels;
import com.mygdx.game.data.Data;
import com.mygdx.game.TextureLoader.TexturesLoader;

import java.util.ArrayList;

public class Level {
    int currentLevel;
    private TexturesLoader manager;
    //Object loadedLevel;
    ArrayList loadedLevel;
    private EndlessLevel endlessLevel;


    public Level(boolean isEndlessLevel, TexturesLoader manager){
        this.manager = manager;
        loadedLevel = new ArrayList();
        pickLevel(isEndlessLevel);
    }

    private void loadLevel(){
        currentLevel = Data.read.getFromFile(Data.fileLevelStats, "lvl");
    }
    
    public void loadNextLevel(){
        currentLevel++;
        saveNewTopLevel();
    }

    private void saveNewTopLevel(){
        Data.write.updateJson(Data.fileLevelStats, "lvl", currentLevel);
    }

    public void tickOfLevel(float time){
        switch (currentLevel){
            case 0:
                endlessLevel.tickOfLevel(time);
               break;

            default:

                break;

        }
    }

    public void pickLevel(boolean isEndlessLevel){
    if(isEndlessLevel){
        currentLevel = 0;
        endlessLevel = new EndlessLevel(manager);
    } else {
        loadLevel();
    }
    }


}

