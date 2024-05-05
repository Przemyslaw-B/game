package com.mygdx.game.display.gui.numbers;

import com.mygdx.game.TextureLoader.TexturesLoader;

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

    public Numbers(TexturesLoader manager){
        this.zero = new Zero(manager);
        this.one = new One(manager);
        this.two = new Two(manager);
        this.three = new Three(manager);
        this.four = new Four(manager);
        this.five = new Five(manager);
        this.six = new Six(manager);
        this.seven = new Seven(manager);
        this.eight = new Eight(manager);
        this.nine = new Nine(manager);
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
