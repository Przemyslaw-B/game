package com.mygdx.game.data.setDefault;

import com.mygdx.game.data.Data;

public class PlayerDefaultStats {

    static String defaultPlayerStat = "{\n" +
            "  \"id\": 1,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 2,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 7,\n" +
            "  \"speedSideways\": 7\n" +
            "}";

    public void setDefaultPlayerStats(){
        Data.write.writeEntireJson(Data.filePlayerStats, defaultPlayerStat);
    }



}
