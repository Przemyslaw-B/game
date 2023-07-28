package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;

public class Movement extends Ship{

    public Movement(){}

    private void moveVertical(int inputY){
        int differenceY = inputY - Ship.position.getShipPositionY();
        if(differenceY > 0){
            moveForward(inputY, differenceY);    //move forward
        } else if( differenceY < 0){
            moveBackward(inputY, differenceY);   //move backward
        } else {} //do not move vertical

    }

    private void moveHorizontal(int inputX){
        int differenceX = inputX - Ship.position.getShipPositionX();
        if(differenceX > 0){
            moveRight(inputX, differenceX);
        } else if(differenceX < 0){
            moveLeft(inputX, differenceX);
        } else {} //do not move horizontal
    }

    private void moveForward(int inputY, int differenceY){
        int positionY = Ship.position.getShipPositionY();   //get current ship position
        if(differenceY < Ship.statistics.getSpeedForward()){
            positionY = inputY;
        } else {
            positionY += Ship.statistics.getSpeedForward();     //change position
        }
        Ship.position.setShipPositionY(positionY);          //save new position
    }

    private void moveBackward(int inputY, int differenceY){
        int positionY=Ship.position.getShipPositionY(); //get current ship position
        if(differenceY < Ship.statistics.getSpeedForward()){
            positionY = inputY;
        } else {
            positionY -= Ship.statistics.getSpeedForward(); //change position
        }
        Ship.position.setShipPositionY(positionY);      //save new position
    }

    private void moveRight(int inputX, int differenceX){
        int positionX = Ship.position.getShipPositionX();   //Read current position of player ship
        if(differenceX < Ship.statistics.getSpeedSideways()){
            positionX = inputX;
        } else {
            positionX += Ship.statistics.getSpeedSideways();    //change position
        }
        Ship.position.setShipPositionX(positionX);          //save position
    }

    private void moveLeft(int inputX, int differenceX){
        int positionX = Ship.position.getShipPositionX();   //Read current position of player ship
        if(differenceX < Ship.statistics.getSpeedSideways()){
            positionX = inputX;
        } else {
            positionX -= Ship.statistics.getSpeedSideways();    //change position
        }
        Ship.position.setShipPositionX(positionX);          //save position
    }

    public void shipControl(){
        //inputY = Gdx.app.getGraphics().getHeight() - inputY;
        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        moveHorizontal(inputX);
        moveVertical(inputY);
    }

}
