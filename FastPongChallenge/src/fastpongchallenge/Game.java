/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastpongchallenge;

import fastpongchallenge.Entities.Ball;
import fastpongchallenge.States.MenuState;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import fastpongchallenge.States.PlayingState;

/**
 *
 * @author lospinas
 */
public class Game{
    
    private static Window game;
    private GameState gameState;
    private Entity ent = new Ball();
    
    private boolean running = false;

    
    public Game(GameState state) {
        game = new Window();
        gameState = state;
        start();
    }
    
    private void start() {
        if (running) return;
        running = true;
        run();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 30.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
   
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void render() {
        BufferStrategy bs = game.getBufferStrategy();
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        ///////////
        //DIBUJAR
        gameState.render(g);
        ///////////
        g.dispose();
        bs.show();
        
    }

    private void tick() {
        gameState.update();
    }
    
    public void setState(GameState state) {
        gameState = state;
    }
    
    public static void main(String[] args) {
        new Game(new MenuState());
    }
}
