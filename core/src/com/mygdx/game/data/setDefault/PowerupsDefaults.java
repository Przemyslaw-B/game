package com.mygdx.game.data.setDefault;

import com.mygdx.game.data.Data;

public class PowerupsDefaults {

    String defaultHealthUp = "{\n" +
            "  \"amount\": 1,\n" +
            "}";


    public void setDefaultUprgradesStats(){
        Data.write.writeEntireJson(Data.fileUpgradesStats, defaultHealthUp);
    }

}
