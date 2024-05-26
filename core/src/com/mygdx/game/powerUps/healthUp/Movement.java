package com.mygdx.game.powerUps.healthUp;

public class Movement {
    private Position position;
    private Statistics statistics;

    public Movement(Position position, Statistics statistics){
        this.position = position;
        this.statistics = statistics;
    }

    public void move(float delta){
        int oldY = position.getY();
        int newY = oldY - Math.round(statistics.getMoveSpeed() * delta);
        position.setY(newY);
    }
}
