package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;

public class Movement extends Position{

    public Movement(){}

    private void moveVertical(int inputY){
        int differenceY = inputY - getShipPositionY();
        if(differenceY > 0){
            moveForward(inputY, differenceY);    //move forward
        } else if( differenceY < 0){
            moveBackward(inputY, differenceY);   //move backward
        } else {} //do not move vertical

    }

    private void moveHorizontal(int inputX){
        int differenceX = inputX - getShipPositionX();
        if(differenceX > 0){
            moveRight(inputX, differenceX);
        } else if(differenceX < 0){
            moveLeft(inputX, differenceX);
        } else {} //do not move horizontal
    }

    private void moveForward(int inputY, int differenceY){
        int positionY = getShipPositionY();   //get current ship position
        if(differenceY < getSpeedForward()){
            positionY = inputY;
        } else {
            positionY += getSpeedForward();     //change position
        }
        setShipPositionY(positionY);          //save new position
    }

    private void moveBackward(int inputY, int differenceY){
        int positionY= getShipPositionY(); //get current ship position
        if(-differenceY < getSpeedForward()){
            positionY = inputY;
        } else {
            positionY -= getSpeedForward(); //change position
        }
        setShipPositionY(positionY);      //save new position
    }

    private void moveRight(int inputX, int differenceX){
        int positionX = getShipPositionX();   //Read current position of player ship
        if(differenceX < getSpeedSideways()){
            positionX = inputX;
        } else {
            positionX += getSpeedSideways();    //change position
        }
        setShipPositionX(positionX);          //save position
    }

    private void moveLeft(int inputX, int differenceX){
        int positionX = getShipPositionX();   //Read current position of player ship
        if(-differenceX < getSpeedSideways()){
            positionX = inputX;
        } else {
            positionX -= getSpeedSideways();    //change position
        }
        setShipPositionX(positionX);          //save position
    }

    public void shipControl(){
        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        inputY = Gdx.app.getGraphics().getHeight() - inputY;
        moveHorizontal(inputX);
        moveVertical(inputY);
    }

}
