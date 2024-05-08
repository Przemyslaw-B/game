package com.mygdx.game.display.gui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TextureLoader.TexturesLoader;
import com.mygdx.game.display.Drop;
import com.mygdx.game.display.gui.numbers.*;
import com.mygdx.game.score.Score;

import java.util.ArrayList;

public class DrawScore {

    Numbers numbers;
    private int x;
    private int y;


    private ArrayList numbersArray;

    public DrawScore(TexturesLoader manager){
        this.numbers = new Numbers(manager);
        numbersArray = new ArrayList<>();
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public void draw(int x, int y){
        checkScore();
        int positionX = x;
        for(int i = 0; i < numbersArray.size(); i++){
            switch ((int) numbersArray.get(i)){
                case 0:
                    numbers.getZero().draw(positionX, y);
                    positionX = positionX + numbers.getZero().endWidth()*2;
                    break;
                case 1:
                    numbers.getOne().draw(positionX, y);
                    positionX = positionX + numbers.getOne().endWidth()*2;
                    break;
                case 2:
                    numbers.getTwo().draw(positionX, y);
                    positionX = positionX + numbers.getTwo().endWidth()*2;
                    break;
                case 3:
                    numbers.getThree().draw(positionX, y);
                    positionX = positionX + numbers.getThree().endWidth()*2;
                    break;
                case 4:
                    numbers.getFour().draw(positionX, y);
                    positionX = positionX + numbers.getFour().endWidth()*2;
                    break;
                case 5:
                    numbers.getFive().draw(positionX, y);
                    positionX = positionX + numbers.getFive().endWidth()*2;
                    break;
                case 6:
                    numbers.getSix().draw(positionX, y);
                    positionX = positionX + numbers.getSix().endWidth()*2;
                    break;
                case 7:
                    numbers.getSeven().draw(positionX, y);
                    positionX = positionX + numbers.getSeven().endWidth()*2;
                    break;
                case 8:
                    numbers.getEight().draw(positionX, y);
                    positionX = positionX + numbers.getEight().endWidth()*2;
                    break;
                case 9:
                    numbers.getNine().draw(positionX, y);
                    positionX = positionX + numbers.getNine().endWidth()*2;
                    break;
                default:
                    break;
            }
            positionX += 5;
        }
        numbersArray.clear();

    }

    public void drawTopScore(int x, int y){
        clearNumbersArray();
        checkTopScore(Score.getTopScore());
        int positionX = x;
        for(int i = 0; i < numbersArray.size(); i++){
            switch ((int) numbersArray.get(i)){
                case 0:
                    numbers.getZero().draw(positionX, y);
                    positionX = positionX + numbers.getZero().endWidth()*2;
                    break;
                case 1:
                    numbers.getOne().draw(positionX, y);
                    positionX = positionX + numbers.getOne().endWidth()*2;
                    break;
                case 2:
                    numbers.getTwo().draw(positionX, y);
                    positionX = positionX + numbers.getTwo().endWidth()*2;
                    break;
                case 3:
                    numbers.getThree().draw(positionX, y);
                    positionX = positionX + numbers.getThree().endWidth()*2;
                    break;
                case 4:
                    numbers.getFour().draw(positionX, y);
                    positionX = positionX + numbers.getFour().endWidth()*2;
                    break;
                case 5:
                    numbers.getFive().draw(positionX, y);
                    positionX = positionX + numbers.getFive().endWidth()*2;
                    break;
                case 6:
                    numbers.getSix().draw(positionX, y);
                    positionX = positionX + numbers.getSix().endWidth()*2;
                    break;
                case 7:
                    numbers.getSeven().draw(positionX, y);
                    positionX = positionX + numbers.getSeven().endWidth()*2;
                    break;
                case 8:
                    numbers.getEight().draw(positionX, y);
                    positionX = positionX + numbers.getEight().endWidth()*2;
                    break;
                case 9:
                    numbers.getNine().draw(positionX, y);
                    positionX = positionX + numbers.getNine().endWidth()*2;
                    break;
                default:
                    break;
            }
            positionX += 5;
        }
        clearNumbersArray();
    }

    private void checkScore(){
        //System.out.println("Value of SCORE: " + Score.getScore());
        String scoreTxt = String.valueOf(Score.getScore());
        for(int i=0; i< scoreTxt.length(); i++){
            char sign = scoreTxt.charAt(i);
            int number = (int) sign - 48;
            if(number >= 0 || number <= 9) {
                addToArray(number);
            }
        }
    }

    private void checkTopScore(int value){
        String scoreTxt = String.valueOf(value);
        for(int i=0; i< scoreTxt.length(); i++){
            char sign = scoreTxt.charAt(i);
            int number = (int) sign - 48;
            if(number >= 0 || number <= 9) {
                addToArray(number);
            }
        }
    }

    private void addToArray(int numberToAdd){
        numbersArray.add(numberToAdd);
    }

    private void clearNumbersArray(){
        numbersArray.clear();
    }

    public int getScoreWidth(boolean isTopScore){
        int width=0;
        if(isTopScore){
            checkScore();
        } else {
            checkTopScore(Score.getTopScore());
        }
        for(int i = 0; i < numbersArray.size(); i++){
            switch ((int) numbersArray.get(i)){
                case 0:
                    width += numbers.getZero().getWidth();
                    break;
                case 1:
                    width += numbers.getOne().getWidth();
                    break;
                case 2:
                    width += numbers.getTwo().getWidth();
                    break;
                case 3:
                    width += numbers.getThree().getWidth();
                    break;
                case 4:
                    width += numbers.getFour().getWidth();
                    break;
                case 5:
                    width += numbers.getFive().getWidth();
                    break;
                case 6:
                    width += numbers.getSix().getWidth();
                    break;
                case 7:
                    width += numbers.getSeven().getWidth();
                    break;
                case 8:
                    width += numbers.getEight().getWidth();
                    break;
                case 9:
                    width += numbers.getNine().getWidth();
                    break;
                default:
                    break;
            }
        }
        clearNumbersArray();
        return width;
    }


}
