/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge.States;

import fastpongchallenge.Entities.Ball;
import fastpongchallenge.Entity;
import fastpongchallenge.GameState;
import fastpongchallenge.Window;
import java.awt.Graphics2D;

/**
 *
 * @author lospinas
 */
public class PlayingState implements GameState{
    
    private Entity ent;
    
    public PlayingState() {
        ent = new Ball();
    }

    @Override
    public void render(Graphics2D g) {
        g.fillRect(0, 0, Window.GAMEWIDTH, Window.GAMEHEIGHT);
        g.setColor(ent.getColor());
        g.draw(ent.getRenderObject());
    }

    @Override
    public void update() {
        ent.update();
    }
}
