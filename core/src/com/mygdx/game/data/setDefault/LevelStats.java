package com.mygdx.game.data.setDefault;

import com.mygdx.game.data.Data;

public class LevelStats {

    String defaultLevelStats = "{\n" +
            "  \"lvl\": 1,\n" +
            "  \"topScore\": 0,\n" +
            "  \"money\": 0,\n" +
            "}";

    public void setDefaultLevelStat(){
        Data.write.writeEntireJson(Data.fileLevelStats, defaultLevelStats);
    }

}
