package com.mygdx.game.powerUps.healthUp;

public class Status {
    private boolean isSpawned;

    public Status(){
        setSpawned(false);
    }

    public void setSpawned(boolean isSpawned){
        this.isSpawned = isSpawned;
    }
    public boolean getIsSpawned(){
        return isSpawned;
    }
}
