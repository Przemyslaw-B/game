package com.mygdx.game.enemies;

public class Movement extends Enemy{
    Position position;
    Statistics statistics;

    public Movement(Position position, Statistics statistics){
        this.position = position;
        this.statistics = statistics;
    }

    public void move(){
        calculateNewPosition(position.getRotation());
    }

    private void calculateNewPosition(int rotation){
        int oldX = position.getX();
        int oldY = position.getY();
        int forwardSpeed = statistics.getSpeedForward();
        int sidewaysSpeed = statistics.getSpeedSideways();
        int speed = (forwardSpeed+sidewaysSpeed)/2; //TODO w uproszczeniu
        //TODO obliczanie nowej pozycji przeciwnika
        double a;
        double b;
        double c = speed;
        double sinA = Math.sin((float) rotation);
        a = sinA * c;
        b = Math.sqrt((c*c)-(a*a));
        //int newX = (int) a;
        //int newY = (int) b;

        int newX = oldX + 10;
        int newY = oldY + 10;
        position.setX(newX);
        position.setY(newY);

        System.out.println("~~~STARA POZYCJA WROGA~~~");
        System.out.println("X: " + oldX + ", Y: " + oldY);
        System.out.println("~~~NOWA POZYCJA WROGA~~~");
        System.out.println("X: " + newX + ", Y: " + newY);




    }
}
