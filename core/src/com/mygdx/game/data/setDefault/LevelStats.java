package com.mygdx.game.data.setDefault;

public class LevelStats {

    static String defaultLevelStats = "{\n" +
            "  \"lvl\": 1,\n" +
            "  \"topScore\": 0,\n" +
            "  \"money\": 0,\n" +
            "}";

    public static String getStats(){
        return defaultLevelStats;
    }

}
