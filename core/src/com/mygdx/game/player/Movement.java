package com.mygdx.game.player;
import com.badlogic.gdx.Gdx;

public class Movement {

    int[] vector;
    private Position position;
    private Statistics statistics;

    public Movement(Position position, Statistics statistics){
        this.position = position;
        this.statistics = statistics;
        this.vector = new int[2];
    }

    private void readInputAndSetVector(){
        int inputX = Gdx.input.getX();
        int inputY = Gdx.input.getY();
        inputY = Gdx.app.getGraphics().getHeight() - inputY;    //odwróć oś Y
        vector[0] = getHorizontalMove(inputX);
        vector[1] = getVerticalMove(inputY);
        calculateOptimalVector(inputX, inputY);
    }

    private void calculateOptimalVector(int inputX, int inputY){
        int oldX = vector[0];
        int oldY = vector[1];
        float repeatX = vector[0]/statistics.getSpeedSideways();
        float repeatY = vector[1]/statistics.getSpeedForward();

        if(repeatX < 0 ){
            repeatX = -repeatX;
        }
        if(repeatY < 0){
            repeatY = -repeatY;
        }

        if(repeatX != 0 && repeatY != 0){
            if(repeatY < repeatX){
                vector[0] = statistics.getSpeedSideways();
                vector[1] = (int) ((float) statistics.getSpeedForward()/(repeatX/repeatY));

            } else if(repeatY == repeatX){
                vector[0] = statistics.getSpeedSideways();
                vector[1] = statistics.getSpeedForward();
            } else {
                vector[0] = (int) ((float) statistics.getSpeedSideways()/(repeatY/repeatX));
                vector[1] = statistics.getSpeedForward();
            }
        } else {
            if(repeatX == 0 && repeatY ==0){
                vector[0] = 0;
                vector[1] = 0;
          } else if(repeatY ==  0 && repeatX != 0){

                vector[0] = statistics.getSpeedSideways();
                vector[1] = 0;
            } else {
                vector[0] = 0;
                vector[1] = statistics.getSpeedForward();
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
        int vertical = inputY - position.getShipPositionY();
        return vertical;
    }

    private int getHorizontalMove(int inputX){
        int horizontal = inputX - position.getShipPositionX();
        return horizontal;
    }


    private void moveVertical(){
        position.setShipPositionY(position.getShipPositionY() + vector[1]);
    }

    private void moveHorizontal() {
        position.setShipPositionX(position.getShipPositionX() + vector[0]);
    }

    public void shipControl(){
        readInputAndSetVector();
        moveVertical();
        moveHorizontal();
    }

}
