package com.mygdx.game.levels;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.data.Data;

public class Level {
    int currentLevel;
    Combat combat;
    private EndlessLevel endlessLevel;

    public Level(){
        endlessLevel = new EndlessLevel();
    }
    public Level(Combat combat){
        this.combat = combat;
        loadLevel();
    }

    public Level(Combat combat, int lvl){
        this.combat = combat;
        loadLevel(lvl);
    }


    private void loadLevel(){
        currentLevel = Data.read.getFromFile(Data.fileLevelStats, "lvl");
    }
    private void loadLevel(int lvl){
        currentLevel = lvl;
    }

    public void loadNextLevel(){
        currentLevel++;
    }

    public EndlessLevel getEndlessLevel() {
        return endlessLevel;
    }

    public void tickOfLevel(float time){
        //TODO endless level for test
        endlessLevel.tickOfLevel(time);

    }
}

