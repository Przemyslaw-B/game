package com.mygdx.game.display.gui.numbers;

import java.util.ArrayList;

public class Numbers {
    private Zero zero;
    private One one;
    private Two two;
    private Three three;
    private Four four;
    private Five five;
    private Six six;
    private Seven seven;
    private Eight eight;
    private Nine nine;

    public Numbers(){
        this.zero = new Zero();
        this.one = new One();
        this.two = new Two();
        this.three = new Three();
        this.four = new Four();
        this.five = new Five();
        this.six = new Six();
        this.seven = new Seven();
        this.eight = new Eight();
        this.nine = new Nine();
    }

    public Zero getZero() {
        return zero;
    }

    public One getOne() {
        return one;
    }

    public Two getTwo() {
        return two;
    }

    public Three getThree() {
        return three;
    }

    public Four getFour() {
        return four;
    }

    public Five getFive() {
        return five;
    }

    public Six getSix() {
        return six;
    }

    public Seven getSeven() {
        return seven;
    }

    public Eight getEight() {
        return eight;
    }

    public Nine getNine() {
        return nine;
    }


}
