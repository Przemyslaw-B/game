package com.mygdx.game.display.gui.health;

import com.mygdx.game.player.Ship;

public class DrawHealth {
    Numbers numbers;
    int x;
    int y;

    public DrawHealth(int x, int y){
        this.numbers = new Numbers();
        this.x = x;
        this.y = y;
    }

    public void drawHealthAmount(){
        drawNumbers(updateHealth());
    }

    private int updateHealth(){
        int health = Ship.statistics.getHealth();
        return health;
    }

    private void drawNumbers(int health){
        switch (health){
            case 1:
                numbers.getOne().draw(x,y);
                break;
            case 2:
                numbers.getTwo().draw(x,y);
                break;
            case 3:
                numbers.getThree().draw(x,y);
                break;
            case 4:
                numbers.getFour().draw(x,y);
                break;
            case 5:
                numbers.getFive().draw(x,y);
                break;
            case 6:
                numbers.getSix().draw(x,y);
                break;
            case 7:
                numbers.getSeven().draw(x,y);
                break;
            case 8:
                numbers.getEight().draw(x,y);
                break;
            case 9:
                numbers.getNine().draw(x,y);
                break;
            case 10:
                numbers.getMax().draw(x,y);
                break;
            default:
                numbers.getZero().draw(x,y);
                break;
        }
    }
}
