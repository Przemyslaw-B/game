package com.mygdx.game.enemies;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class Movement {
    Position position;
    Statistics statistics;
    int newX;
    int newY;
    double a;
    double b;
    float delta;
    boolean isFromTop;
    boolean tempIsLeft;
    int width;
    int height;
    int sizeX;
    int sizeY;
    boolean movingToRight;
    boolean movingDown;
    Random rand;
    int limiterY ;


    public Movement(Position position, Statistics statistics, int sizeX, int sizeY){
        this.rand = new Random();
        this.movingDown = true;
        int temp = Math.round(Gdx.graphics.getHeight()*0.7f);
        this.limiterY = getRng(50, temp);
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.position = position;
        this.statistics = statistics;
        this.isFromTop = position.isFromTop();
        this.tempIsLeft = calculateIsLeft();
        if(tempIsLeft){
            this.movingToRight = true;
        } else {
            this.movingToRight = false;
        }
    }

    public void move(float delta){  //TODO colision detect to add
        this.delta = delta;
        if(!isFromTop){
            moveIfDiagonal();
        }else{
            moveIfFromTop();
        }
    }

    private int getRng(int min, int max){
        return rand.nextInt(max-min) + min;
    }

    private void moveIfFromTop(){
        int newX = position.getX();
        int newY = position.getY();

        int tempX = Math.round(statistics.getSpeedSideways()/2);
        if(movingToRight){
            //newX += statistics.getSpeedSideways();
            newX += tempX;
            if(checkIfCloseToWall(newX)){
                movingToRight = false;
            }
        }else{
            //newX -= statistics.getSpeedSideways();
            newX -= tempX;
            if(checkIfCloseToWall(newX)){
                movingToRight = true;
            }
        }

        float tempY = statistics.getSpeedForward()/3;
        if(movingDown){
            newY -= Math.round(tempY);
        } else {
            newY += Math.round(tempY);
        }

        if(position.getY() <= limiterY){
            movingDown = false;
        }
        if(position.getY() >= height){
            movingDown = true;
        }

        position.setX(newX);
        position.setY(newY);
    }

    private void moveIfDiagonal(){
        calculateNewPosition(position.getRotation());
        position.setX(newX);
        position.setY(newY);
    }

    private boolean calculateIsLeft(){
        int tempPosition = position.getX();
        if(tempPosition < width/2){
            return true;
        }
        return false;
    }

    private boolean checkIfCloseToWall(int newX){
       int temp;
        if(movingToRight){
                  temp = newX + Math.round(sizeX/2);
            if(temp >= width){
                return true;
            } else{
                return false;
            }
        } else {
            temp = newX - Math.round(sizeX/2);
            if(temp <= 0){
                return true;
            } else {
                return false;
            }
        }
    }

    private void calculateNewPosition(int rotation){
        int oldX = position.getX();
        int oldY = position.getY();
        catchDirections(rotation);
        newX = oldX + (int) Math.round(a);
        newY = oldY + (int) Math.round(b);
    }

    private void catchDirections(int rotation){
        int updated;
        if(rotation == 0){
            moveUp();
        } else if(rotation > 0 && rotation < 90){
            calculatePathFromDegree(rotation);
        } else if(rotation == 90) {
            moveRight();
        }else if(rotation > 90 && rotation < 180){
            updated = rotation - 90;
            calculatePathFromDegree(updated);
            this.b = -b;
        } else if(rotation == 180){
            moveDown();
        } else if(rotation > 180 && rotation < 270){
            updated = rotation - 180;
            calculatePathFromDegree(updated);
            this.b = -b;
            this.a = -a;
        } else if(rotation == 270){
            moveLeft();
        } else if (rotation > 270) {
            updated = rotation - 180;
            calculatePathFromDegree(updated);
            this.a = -a;
        }
    }


    private void moveUp(){
        b = statistics.getSpeedForward();
    }
    private void moveLeft(){
        a = -statistics.getSpeedSideways();
    }
    private  void moveRight(){
        a = statistics.getSpeedSideways();
    }
    private void moveDown(){
        b = -statistics.getSpeedForward();
    }

    private void calculatePathFromDegree(int rotation){
        int forwardSpeed = statistics.getSpeedForward();
        int sidewaysSpeed = statistics.getSpeedSideways();
        double speed = ((forwardSpeed+sidewaysSpeed)/2);//*delta;
        double c = speed;
        double degree = Math.toRadians((double) rotation);
        double sinA = Math.sin(degree);
        a = sinA * c;
        b = Math.sqrt((c*c)-(a*a));
    }

}
