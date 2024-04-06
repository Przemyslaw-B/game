package com.mygdx.game.enemies;

public class Movement extends Enemy{
    Position position;
    Statistics statistics;
    int newX;
    int newY;
    double a;
    double b;
    float delta;

    public Movement(Position position, Statistics statistics){
        this.position = position;
        this.statistics = statistics;
    }

    public void move(float delta){
        this.delta = delta;
        calculateNewPosition(position.getRotation());
        position.setX(newX);
        position.setY(newY);
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
