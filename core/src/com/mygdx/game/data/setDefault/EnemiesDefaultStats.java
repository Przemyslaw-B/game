package com.mygdx.game.data.setDefault;

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

    public static String getStats(){
        return defaultEnemyStats;
    }
}
