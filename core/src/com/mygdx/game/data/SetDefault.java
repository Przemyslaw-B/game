package com.mygdx.game.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.data.setDefault.*;

public class SetDefault {
    JsonReader jsonReader;
    JsonValue jsonValue;
    String defaultPlayerStat = "{\n" +
            "  \"id\": 1,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 2,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 7,\n" +
            "  \"speedSideways\": 7\n" +
            "}";

    String defaultEnemyStats = "{\n" +
            "  \"id\": 2,\n" +
            "  \"health\": 1,\n" +
            "  \"damage\": 1,\n" +
            "  \"attackSpeed\": 1,\n" +
            "  \"speedForward\": 5,\n" +
            "  \"speedSideways\": 5\n" +
            "  \"points\": 1\n" +
            "}";

    String defaultLevelStats = "{\n" +
            "  \"lvl\": 1,\n" +
            "  \"topScore\": 0,\n" +
            "  \"money\": 0,\n" +
            "}";

    String defaultUprgradesStats= "{\n" +
            "  \"lvl\": 1,\n" +
            "  \"topScore\": 0,\n" +
            "  \"money\": 0,\n" +
            "}";

    public SetDefault(){
        this.jsonReader = new JsonReader();
    }
    public void resetEnemyToDefault(){
        Data.write.updateJson(Data.fileEnemyStats, "speedForward", 5);
        Data.write.updateJson(Data.fileEnemyStats, "speedSideways", 5);
    }

    public void setDefaultPlayerStats(){Data.write.writeEntireJson(Data.filePlayerStats, PlayerDefaultStats.getStats());}
    public void setDefaultEnemyStat(){Data.write.writeEntireJson(Data.fileEnemyStats, EnemiesDefaultStats.getStats());}
    public void setDefaultLevelStat(){Data.write.writeEntireJson(Data.fileLevelStats, LevelStats.getStats());}
    public void setDefaultUprgradesStats(){Data.write.writeEntireJson(Data.fileUpgradesStats, PowerupsDefaults.getStats());}

    //public void setDefaultPlayerStats(){Data.write.writeEntireJson(Data.filePlayerStats, defaultPlayerStat);}
    //public void setDefaultEnemyStat(){Data.write.writeEntireJson(Data.fileEnemyStats, defaultEnemyStats);}
    //public void setDefaultLevelStat(){Data.write.writeEntireJson(Data.fileLevelStats, defaultLevelStats);}
    //public void setDefaultUprgradesStats(){Data.write.writeEntireJson(Data.fileUpgradesStats, defaultUprgradesStats);}
}
