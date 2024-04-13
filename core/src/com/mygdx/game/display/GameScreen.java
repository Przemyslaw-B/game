package com.mygdx.game.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.background.Background;
import com.mygdx.game.data.TexturesLoader;
import com.mygdx.game.display.gui.MainMenuScreen;
import com.mygdx.game.levels.Level;
import com.mygdx.game.player.Ship;
import com.mygdx.game.combat.Combat;
import com.mygdx.game.display.gui.gameOver.GameOver;

public class GameScreen implements Screen {

    final Drop game;

    int height;
    int width;
    float time;
    Background background;
    private boolean exitFlag;
    boolean deadFlag=false;
    private Ship ship;

    private Vector3 touchPoint;
    private Combat combat;
    private Level level;
    private GameOver gameOver;
    private int backgroundSpeed = 200;
    private TexturesLoader manager;


    //Enemy enemy;
    //ArrayList<Enemy> enemyList;
    public GameScreen(final Drop game, Background background, Ship ship, TexturesLoader manager) {
        this.game=game;
        this.manager=manager;
        this.gameOver = new GameOver();
        this.exitFlag = false;
        this.ship = ship;
        this.time=0f;
        height = Gdx.app.getGraphics().getHeight(); //height of user device
        width = Gdx.app.getGraphics().getWidth();   //width of user device
        this.background = background;
        //this.ship=new Ship();
        this.combat = new Combat(ship, manager);
        //this.level = new Level(combat);
        //this.enemyList = new ArrayList<Enemy>();
        this.touchPoint = new Vector3();

        //DO TESTÓW JEDEN WRÓG
        //enemyList.add(new Enemy(500, 500, 2));

        //combat.spawnEnemy(2);
    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        time += delta;
        game.batch.begin();
        background.draw();
        background.move(delta);
        //System.out.println("Is Battle On: " + combat.isBattleOn());
        //System.out.println("Exit Flag: " + exitFlag);
        //combat.getAMOUNT_TEST_ONLY();

        if(exitFlag){ //exit to main menu
            //System.out.println("~~~~~Exit Flag: " + exitFlag + "~~~~~");
            combat.endOfGameKillAll();
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
        if(combat.isBattleOn()){
            if(time > 1){   //level here
                background.setSpeedPerSec(this.backgroundSpeed);
                combat.tickOfBattle(delta);
                //Ship Control
                if(Gdx.input.isTouched() && ship.statistics.isAlive()){
                    ship.movement.shipControl();
                }
                //End of Ship Control
            } else {ship.draw();} //TODO - DO TESTÓW WYŚWIETLANIA!!!
        } else {    //press anywhere to quit level
            //System.out.println("~~~~BATTLE IS NOT ON!~~~~~");
            gameOver.drawGameOver();
            combat.endOfGameKillAll();
            if(gameOver.checkIfContinue()){
                this.exitFlag = true;
                //System.out.println("~~~~~Exit Flag: " + exitFlag + "~~~~~");
            }
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
