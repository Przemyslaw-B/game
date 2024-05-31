package com.mygdx.game.powerUps.addidionalBullet;
import com.mygdx.game.player.Ship;
import com.mygdx.game.powerUps.SpawnedPowerUps;

public class PickingUpAdditionalBullet {
    Ship player;
    private int playerX;
    private int playerY;
    private int boxX;
    private int boxY;

    private int playerMaxLeftX;
    private int playerMaxRightX;
    private int playerMaxTopY;
    private int playerMaxBottomY;

    private int boxMaxLeftX;
    private int boxMaxRightX;
    private int boxMaxTopY;
    private int boxMaxBottomY;


    public PickingUpAdditionalBullet(Ship player) {
        this.player = player;
    }

    private void checkAll(){
        if(SpawnedPowerUps.additionalBulletsArray.size() > 0){
            for(int i = SpawnedPowerUps.additionalBulletsArray.size() - 1; i >= 0; i--){
                AdditionalBullet picked = SpawnedPowerUps.additionalBulletsArray.get(i);
                setBoxBorders(picked);
                if(comparePosition()){
                    makeAction(picked);
                    removeObjectFromArray(picked);
                }
            }
        }
    }

    private void setPlayerParameters(){
        this.playerX = player.getPosition().getShipPositionX();
        this.playerY = player.getPosition().getShipPositionY();

        this.playerMaxLeftX = playerX - player.getSkin().getShipMyTextureRegion().getRegionWidth()/2;
        this.playerMaxRightX = playerX + player.getSkin().getShipMyTextureRegion().getRegionWidth()/2;
        this.playerMaxTopY = playerY + player.getSkin().getShipMyTextureRegion().getRegionHeight()/2;
        this.playerMaxBottomY = playerY - player.getSkin().getShipMyTextureRegion().getRegionHeight()/2;
    }

    private void setBoxBorders(AdditionalBullet picked){
        this.boxX = picked.getPosition().getX();
        this.boxY = picked.getPosition().getY();

        this.boxMaxLeftX = boxX - picked.getSkin().getTextureRegion().getRegionWidth()/2;
        this.boxMaxRightX = boxX + picked.getSkin().getTextureRegion().getRegionWidth()/2;
        this.boxMaxTopY = boxY + picked.getSkin().getTextureRegion().getRegionHeight()/2;
        this.boxMaxBottomY = boxY - picked.getSkin().getTextureRegion().getRegionHeight()/2;
    }


    private boolean comparePosition(){
        if(compareWidth() && compareHeight()){
            return true;
        }
        return false;
    }

    private boolean compareHeight(){
        if(playerMaxTopY == boxMaxTopY || playerMaxTopY == boxMaxBottomY){return true;}
        if(playerMaxBottomY == boxMaxTopY || playerMaxBottomY == boxMaxBottomY){return true;}
        if(playerMaxTopY <= boxMaxTopY && playerMaxTopY >= boxMaxBottomY){return true;}
        if(playerMaxBottomY <= boxMaxTopY && playerMaxBottomY >= boxMaxBottomY){return true;}
        return false;
    }

    private boolean compareWidth(){
        if(playerMaxLeftX == boxMaxLeftX || playerMaxLeftX == boxMaxRightX){return true;}
        if(playerMaxRightX == boxMaxRightX || playerMaxRightX == boxMaxLeftX){return true;}
        if(playerMaxLeftX >= boxMaxLeftX && playerMaxLeftX <= boxMaxRightX){return true;}
        if(playerMaxRightX <= boxMaxRightX && playerMaxRightX >= boxMaxLeftX){return true;}
        return false;
    }

    private void makeAction(AdditionalBullet picked){
        picked.getAction().addMainBullet();
    }

    private void removeObjectFromArray(AdditionalBullet picked){
        SpawnedPowerUps.additionalBulletsArray.remove(picked);
    }

    public void checkAndPickUp(){
        setPlayerParameters();
        checkAll();
    }
}
