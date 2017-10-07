/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge.States;

import fastpongchallenge.GameState;
import fastpongchallenge.Window;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author lospinas
 */
public class MenuState implements GameState{

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Window.GAMEWIDTH, Window.GAMEHEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TestFont", 0, 30));
        g.drawString("THIS IS THE MENU BITCHES", 200, 200);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
