package com.mygdx.game.data.setDefault;

import com.mygdx.game.data.Data;

public class EnemiesDefaultStats {

    static String defaultEnemyStats = "{\n" +
            "  \"id\": 2,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 1,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 5,\n" +
            "  \"speedSideways\": 5\n" +
            "  \"points\": 1\n" +
            "}";

    public void setDefaultEnemyStat(){
        Data.write.writeEntireJson(Data.fileEnemyStats, defaultEnemyStats);}

}
