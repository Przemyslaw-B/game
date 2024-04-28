package com.mygdx.game.data.setDefault;

import com.mygdx.game.data.Data;

public class BossesDefaultStats {

    static String defaultBossStat = "EMPTY";


    public void setDefaultEnemyStat(){
        Data.write.writeEntireJson(Data.fileBossesStats, defaultBossStat);
    }
}
