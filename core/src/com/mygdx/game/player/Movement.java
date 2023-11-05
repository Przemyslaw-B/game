package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;

public class Movement extends Position{

    int[] vector;
    public Movement(){
        this.vector = new int[2];
    }

    private void readInputAndSetVector(){
        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        inputY = Gdx.app.getGraphics().getHeight() - inputY;    //odwróć oś Y
        vector[0] = getHorizontalMove(inputX);
        vector[1] = getVerticalMove(inputY);
        System.out.println("~BEFORE CALC~ Vector: X: " + vector[0] + " Y: " + vector[1]);
        calculateOptimalVector(inputX, inputY);
    }

    private void calculateOptimalVector(int inputX, int inputY){
        int oldX = vector[0];
        int oldY = vector[1];
        if(inputX != 0 && inputY != 0){
            float repeatX = inputX/getSpeedSideways();
            float repeatY = inputY/getSpeedForward();
            System.out.println("Numbers of REPEAT: X: " + repeatX + " Y: " + repeatY);
            if(repeatY < repeatX){
                vector[0] = getSpeedSideways();
                vector[1] = (int) ((float) inputY/repeatX);

            } else if(repeatY == repeatX){
                vector[0] = getSpeedSideways();
                vector[1] = getSpeedForward();
            } else {
                vector[0] = (int) ((float) inputX/repeatY);
                vector[1] = getSpeedForward();
            }
        } else {
            if(inputX == 0 && inputY ==0){
                vector[0] = 0;
                vector[1] = 0;
          } else if(inputY ==  0 && inputX != 0){
                vector[0] = getSpeedSideways();
                vector[1] = 0;
            } else {
                vector[0] = 0;
                vector[1] = getSpeedForward();
            }
        }
        setDirection(oldX, oldY);
    }

    private void setDirection(int x, int y){
        if(x < 0){
            vector[0] = -vector[0];
        }
        if(y < 0){
            vector[1] = -vector[1];
        }
    }



    private int getVerticalMove(int inputY){
        int vertical = inputY - getShipPositionY();
        return vertical;
    }

    private int getHorizontalMove(int inputX){
        int horizontal = inputX - getShipPositionX();
        return horizontal;
    }

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

    private void moveVertical(){
        if((vector[1]>0 && vector[1] <= getSpeedForward()) || (vector[1] <0 && -vector[1] <= getSpeedForward())){
            /*
            if(vector[1] > 0){
                setShipPositionY(getShipPositionY() + vector[1]);
            } else if (vector[1] < 0){
                setShipPositionY(getShipPositionY() - vector[1]);
            }
            */
        }
        System.out.println("Old Y position: " + getShipPositionY());
        setShipPositionY(getShipPositionY() + vector[1]);
        System.out.println("New Y position: " + getShipPositionY());


    }

    private void moveHorizontal(){
        if((vector[0]>0 && vector[0] <= getSpeedSideways()) || (vector[0] <0 && -vector[0] <= getSpeedSideways())){
            /*
            setShipPositionX(getShipPositionX() + vector[0]);
            if(vector[0] > 0){
                setShipPositionX(getShipPositionX() + vector[0]);
            } else if (vector[0] < 0){
                setShipPositionX(getShipPositionX() - vector[0]);
            }
            */
        }
        System.out.println("Old X position: " + getShipPositionX());
        setShipPositionX(getShipPositionX() + vector[0]);
        System.out.println("New X position: " + getShipPositionX());


    }

    public void shipControl(){
        readInputAndSetVector();
        System.out.println("Vector: X: " + vector[0] + " Y: " + vector[1]);

        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        inputY = Gdx.app.getGraphics().getHeight() - inputY;    //odwróć oś
        moveVertical();
        moveHorizontal();

        /*
        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        inputY = Gdx.app.getGraphics().getHeight() - inputY;    //odwróć oś
        moveHorizontal(inputX);
        moveVertical(inputY);

         */
    }

}
